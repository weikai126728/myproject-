package com.abbot.schimneylife.controller.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.pojo.user.UserCustomer;
import com.abbot.schimneylife.service.shopping.CustomerFootmarkService;
import com.abbot.schimneylife.service.user.UserCustomerService;
import com.abbot.schimneylife.service.user.UserService;
import com.abbot.schimneylife.util.AliMsgUtil;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.ImageUtil;
import com.abbot.schimneylife.util.Md5Util;
import com.abbot.schimneylife.util.SessionManager;
import com.abbot.schimneylife.util.SessionManager.Key;
import com.abbot.schimneylife.util.validateCode.ValidateCode;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

/**
 * 用户
 * 
 * @author xinye
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	Logger logger = Logger.getLogger(UserController.class);

	@Resource
	private UserService userService;
	@Resource
	private UserCustomerService ucService;
	@Resource
	private CustomerFootmarkService markService;

	/**
	 * 获取验证码图片
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/to/validateCode")
	public void getValidateCode(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("图片");
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		ValidateCode instance = new ValidateCode();
		Cookie cookie = new Cookie("scaptcha", ValidateCode.getCode());
		cookie.setMaxAge(1800);
		response.addCookie(cookie);
		try {
			instance.write(response.getOutputStream());
		} catch (IOException e) {
			logger.error("��ȡ��֤���쳣��", e);
		}
	}

	/**
	 * 注册用户
	 * 
	 * @param user
	 * @throws Exception
	 */
	@RequestMapping("/to/register")
	public void register(String phone, String yz, String password) {
		JSONObject object;
		if (userService.phoneUsed(phone,CommonKey.Role.MEMBER.getLevel())) {
			String check = SessionManager.getAttribute(request, SessionManager.Key.VERIFICATION);

			if (check != null && check != "") {
				String checkMessage[] = check.split(";");

				if (checkMessage[0].equals(phone) && checkMessage[1].equals(yz)) {

					try {
						User user = new User();

						String salt = Md5Util.createSalt();
						user.setSalt(salt);
						String encode = Md5Util.encodeByMod5(password, salt);
						user.setPassword(encode);
						user.setNickName(phone);
						user.setPhone(phone);
						user.setGender(1);
						user.setStatus(CommonKey.User.Status.ENABLE.getValue());
						userService.addUser(user, CommonKey.Role.MEMBER.getLevel());
						object = this.createJSONResult(0, "true");
						this.writeJSON(object.toJSONString());
					} catch (Exception e) {
						logger.error("注册用户异常！", e);
						object = this.createJSONResult(0, "注册失败");
						this.writeJSON(object.toJSONString());
					}
				} else {
					object = this.createJSONResult(0, "手机号与验证码不匹配");
					this.writeJSON(object.toJSONString());
				}
			} else {
				object = this.createJSONResult(0, "请先获取验证码");
				this.writeJSON(object.toJSONString());
			}
		} else {
			object = this.createJSONResult(0, "手机号已被注册");
			this.writeJSON(object.toJSONString());
		}
	}

	/**
	 * 修改密码
	 * 
	 * @param user
	 */
	@RequestMapping("/to/forget")
	public void forgetPassword(String phone, String password, String yz) {
		String check = SessionManager.getAttribute(request, SessionManager.Key.VERIFICATION);
		System.out.println(check);
		if (check != null || check != "") {
			String checkMessage[] = check.split(";");
			System.out.println(checkMessage[0]);
			System.out.println(checkMessage[1]);
			System.out.println(phone);
			System.out.println(yz);
			JSONObject object;
			if (checkMessage[0].equals(phone) && checkMessage[1].equals(yz)) {

				if (userService.findByPhone(phone) != null) {
					User user = new User();
					user.setPhone(phone);
					try {
						String salt = Md5Util.createSalt();
						System.out.println(salt);
						user.setSalt(salt);
						String encode = Md5Util.encodeByMod5(password, salt);
						user.setPassword(encode);
						boolean result = userService.forgetPassword(user);

						object = this.createJSONResult(0, String.valueOf(result));
						this.writeJSON(object.toJSONString());

					} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
						logger.error("修改用户异常！", e);
						object = this.createJSONResult(0, String.valueOf("修改失败"));
						this.writeJSON(object.toJSONString());
					}
				}
			} else {
				object = this.createJSONResult(0, String.valueOf("手机号与验证码不匹配"));
				this.writeJSON(object.toJSONString());
			}
		}
	}

	public String registerBusiness(String phone, String password, String verify, String adress) {
		return null;
	}

	/**
	 * 用户登陆
	 * 
	 * @param phone
	 *            手机号
	 * @param password
	 *            密码
	 * @param verify
	 *            验证码
	 */
	@RequestMapping("/to/login")
	public ModelAndView login(String phone, String password, HttpServletRequest request, HttpServletResponse response) {
		User user = userService.findByPhone(phone);

		if (user != null && user.getStatus() == CommonKey.ENABLE_FLAG && user.getRole() != null
				&& user.getRole().getLevel() == CommonKey.Role.MEMBER.getLevel()) {
			try {
				if (Md5Util.checkPassword(password, user.getSalt(), user.getPassword())) {

					SessionManager.addAttribute(request, SessionManager.Key.USER, user);
					UserCustomer uc = ucService.fetchByUserId(user.getId());
					SessionManager.addAttribute(request, Key.CUSTOMER, uc);
					if (SessionManager.contains(request, SessionManager.Key.REDIRECTURL)) {
						String url = "redirect:" + SessionManager.getAttribute(request, SessionManager.Key.REDIRECTURL);
						Map<String,String[]> map = SessionManager.getAttribute(request, SessionManager.Key.REDIRECTPARAMETER);
						StringBuffer sb = new StringBuffer();
						String g = "";
						Iterator<String> iterator = map.keySet().iterator();
						while(iterator.hasNext()) {
							String key = iterator.next();
							String[] values = map.get(key);
							for(String value:values) {
								sb.append(g);
								g="&";
								sb.append(key);
								sb.append("=");
								sb.append(value);						
							}
						}
						if(sb.length()>0) {
							url +="?"+sb.toString();
						}
						SessionManager.removeAttribute(request, SessionManager.Key.REDIRECTURL);
						SessionManager.removeAttribute(request, SessionManager.Key.REDIRECTPARAMETER);
						ModelAndView model = new ModelAndView(url);
						return model;
					}
//					ModelAndView model = new ModelAndView("page/shopping/wap_my");
					ModelAndView model = new ModelAndView("redirect:../../wap/home/index.do");

					// 删除失效的足迹数据
					String days = ConfigureUtil.FOOTMARK_DAYS.toString();
					int d = 7;// 默认数据7天有效
					if (this.isNumeric(days)) {
						d = Integer.valueOf(days);
					}
					markService.delete(uc.getId(), d);
					return model;
				}
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				logger.error("用户登陆异常！", e);
				ModelAndView model = new ModelAndView("page/shopping/wap_SignIn");
				model.addObject("errMessage", "用户登陆异常");
				return model;
			}
			ModelAndView model = new ModelAndView("page/shopping/wap_SignIn");
			model.addObject("phone", phone);
			model.addObject("errMessage", "密码错误");
			return model;
		}
		ModelAndView model = new ModelAndView("page/shopping/wap_SignIn");
		model.addObject("errMessage", "没有此账号");
		return model;
	}

	@RequestMapping("/to/wap/home")
	public ModelAndView goLogin() {
		ModelAndView model = new ModelAndView("page/shopping/wap_SignIn");
		return model;
	}

	/**
	 * 修改个人信息
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping("/updateUser")
	public ModelAndView updateUser(@RequestParam("file") MultipartFile file, String nickName, int gender, String bir)
			throws IllegalStateException, IOException {
		User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		UserCustomer uc = SessionManager.getAttribute(request, Key.CUSTOMER);

		if (file != null && file.getSize() != 0) {
			String fileName = ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString());
			uc.setIco(fileName);
		}

		uc.setNickName(nickName);
		uc.setUserID(user.getId());
		user.setNickName(nickName);
		user.setGender(gender);
		user.setBirthday(bir);
		int us = userService.updateUser(user);
		int cu = ucService.updateCustomer(uc);
		if (us > 0 && cu > 0) {
			SessionManager.addAttribute(request, Key.USER, user);
			SessionManager.addAttribute(request, Key.CUSTOMER, uc);
			ModelAndView model = new ModelAndView("page/shopping/wap_personal");
			model.addObject("msg", "保存成功");
			return model;
			// object=this.createJSONResult(0, true);
			// this.writeJSON(object.toJSONString());
		}
		ModelAndView model = new ModelAndView("page/shopping/wap_personal");
		model.addObject("msg", "修改失败");
		return model;
		// object=this.createJSONResult(0, "修改失败");
		// this.writeJSON(object.toJSONString());
	}

	// /**
	// * 原手机号验证
	// *
	// * @param phone
	// * @param yz
	// * @return
	// */
	// @RequestMapping("/oldPhone")
	// public ModelAndView oldPhone(String phone, String yz) {
	// String check = SessionManager.getAttribute(request,
	// SessionManager.Key.VERIFICATION);
	// User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
	// System.out.println("验证消息" + check);
	// String checkMessage[] = check.split(";");
	// if (user.getPhone().equals(phone) && checkMessage[1].equals(yz)) {
	// ModelAndView model = new ModelAndView("page/shopping/wap_updatePhone2");
	// return model;
	// }
	// ModelAndView model = new ModelAndView("page/shopping/wap_updatePhone");
	// model.addObject("errMessage", "手机号码不正确");
	// return model;
	// }

	/**
	 * 新手机号绑定
	 * 
	 * @param phone
	 * @param yz
	 * @return
	 */

	@RequestMapping("/newPhone")
	public void newPhone(String phone, String yz) {
		String check = SessionManager.getAttribute(request, SessionManager.Key.VERIFICATION);
		User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		System.out.println("验证消息" + check);
		JSONObject object;
		String checkMessage[] = check.split(";");
		if (checkMessage[0].equals(phone) && checkMessage[1].equals(yz)) {
			user.setPhone(phone);
			if (userService.updatePhone(user)) {
				// ModelAndView model = new ModelAndView("redirect:update.do");
				// SessionManager.addAttribute(request, SessionManager.Key.USER, user);
				// return model;
				object = this.createJSONResult(0, "true");
				this.writeJSON(object.toJSONString());
			} else {
				// ModelAndView model = new ModelAndView("page/shopping/wap_updatePhone");
				// model.addObject("errMessage", "修改失败");
				// return model;
				object = this.createJSONResult(0, "修改失败");
				this.writeJSON(object.toJSONString());
			}
		}
		// ModelAndView model = new ModelAndView("page/shopping/wap_updatePhone");
		// model.addObject("errMessage", "验证码不正确");
		// return model;
		object = this.createJSONResult(0, "手机号与验证码不匹配");
		this.writeJSON(object.toJSONString());
	}

	/**
	 * 修改密码
	 * 
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */

	@RequestMapping("/updatePassword")
	public void updatePassword(String oldPassword, String newPassword) {
		User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		JSONObject object;
		try {
			if (Md5Util.checkPassword(oldPassword, user.getSalt(), user.getPassword())) {
				String salt = Md5Util.createSalt();
				String encode = Md5Util.encodeByMod5(newPassword, salt);
				System.out.println("原盐值" + user.getSalt());
				user.setSalt(salt);

				user.setPassword(encode);
				if (userService.updatePassword(user)) {
					System.out.println("修改成功");
					System.out.println("现盐值" + user.getSalt());
					// ModelAndView model = new ModelAndView("page/shopping/wap_my");
					// return model;
					SessionManager.addAttribute(request, Key.USER, user);
					object = this.createJSONResult(0, "true");
					this.writeJSON(object.toJSONString());
				}
				// ModelAndView model = new ModelAndView("page/shopping/wap_updatePassword");
				// model.addObject("errMessage", "修改失败");
				// return model;
				object = this.createJSONResult(0, "修改失败");
				this.writeJSON(object.toJSONString());
			}
			// ModelAndView model = new ModelAndView("page/shopping/wap_updatePassword");
			// model.addObject("errMessage", "原始密码不正确");
			// return model;
			object = this.createJSONResult(0, "原始密码不正确");
			this.writeJSON(object.toJSONString());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// ModelAndView model = new ModelAndView("page/shopping/error");
			// model.addObject("errMessage", "系统错误");
			// return model;
			object = this.createJSONResult(0, "系统繁忙,请稍后再试");
			this.writeJSON(object.toJSONString());
		}
	}

	/**
	 * 跳转到我的界面
	 * 
	 * @return
	 */
	@RequestMapping("/to/my")
	public ModelAndView toMy() {
		User user = new User();
		user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		ModelAndView model = new ModelAndView("page/shopping/wap_my");
		model.addObject("userMessage", user);
		return model;
	}

	// /**
	// * 跳转到个人信息页面
	// *
	// * @return
	// */
	// @RequestMapping("/persional")
	// public ModelAndView toPersional() {
	// User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
	// UserCustomer uc = SessionManager.getAttribute(request,
	// SessionManager.Key.CUSTOMER);
	// ModelAndView model = new ModelAndView("page/shopping/wap_personal");
	// model.addObject("userMessage", user);
	// model.addObject("uc", uc);
	// return model;
	// }

	/**
	 * 昵称是否被使用
	 * 
	 * @param nickName
	 */
	@RequestMapping("nick")
	public void nick(String nickName) {
		boolean used = userService.nickUsed(nickName);
		JSONObject object = this.createJSONResult(0, String.valueOf(used));
		this.writeJSON(object.toJSONString());
	}

	/**
	 * 用户管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/update")
	public ModelAndView toUpdate() {
		User user = new User();
		user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		ModelAndView model = new ModelAndView("page/shopping/wap_user");
		model.addObject("userMessage", user);
		return model;
	}

	/**
	 * 手机号是否被使用
	 * 
	 * @param phone
	 */
	@RequestMapping("/to/checkPhone")
	public void phone(String phone) {
		boolean used = userService.phoneUsed(phone,CommonKey.Role.MEMBER.getLevel());
		JSONObject object = this.createJSONResult(0, String.valueOf(used));
		this.writeJSON(object.toJSONString());
	}

	/**
	 * 登出
	 * 
	 * @return
	 */
	@RequestMapping("/to/logout")
	public ModelAndView logout(HttpServletRequest request) {
		SessionManager.removeAll(request);
		ModelAndView model = new ModelAndView("page/shopping/wap_my");
		return model;
	}

	/**
	 * 发送字母加数字短信验证码
	 * 
	 * @param request
	 * @param phone
	 * @return
	 */
	@RequestMapping("/to/Allverifica")
	public void verificationAllCode(HttpServletRequest request, String phone) {
		// String code = Md5Util.createSalt();
		String message = (Math.random() * 9 + 1) * 100000 + "";
		String code = message.substring(0, 6);
		JSONObject json = new JSONObject();
		json.put("code", CommonKey.SUCCESS_CODE);
		long before = 0l;
		long now = System.currentTimeMillis();
		if (SessionManager.contains(request, SessionManager.Key.TIMESTAMP)) {
			before = SessionManager.getAttribute(request, SessionManager.Key.TIMESTAMP);
		}
		if (now - before > 118000) {// ����120s���������·���
			SessionManager.addAttribute(request, SessionManager.Key.VERIFICATION, phone + ";" + code);// ������֤��
			SessionManager.addAttribute(request, SessionManager.Key.TIMESTAMP, now);// ����ʱ��

			new Thread(new Runnable() {
				@Override
				public void run() {
					SendSmsResponse ssResponse;
					try {
						ssResponse = AliMsgUtil.sendSms(code, phone);
						System.out.println("短信回执----------------");
						System.out.println("Code=" + ssResponse.getCode());
						System.out.println("Message=" + ssResponse.getMessage());
						System.out.println("RequestId=" + ssResponse.getRequestId());
						System.out.println("BizId=" + ssResponse.getBizId());
						System.out.println(phone);

					} catch (ClientException e) {
						logger.error("���﷢����֤���쳣��", e);
					}
				}

			}).start();
		}
		json.put("result", true);
		this.writeJSON(json.toJSONString());
	}

	/**
	 * 发送六位数字短信验证码
	 * 
	 * @param request
	 * @param phone
	 * @return
	 */
	@RequestMapping("/to/verifica")
	public void verificationCode(HttpServletRequest request, String phone) {
		String message = (Math.random() * 9 + 1) * 100000 + "";
		String code = message.substring(0, 6);
		User user = SessionManager.getAttribute(request, Key.USER);
		JSONObject json = new JSONObject();
		json.put("code", CommonKey.SUCCESS_CODE);
		long before = 0l;

		long now = System.currentTimeMillis();
		if (SessionManager.contains(request, SessionManager.Key.TIMESTAMP)) {
			before = SessionManager.getAttribute(request, SessionManager.Key.TIMESTAMP);
		}
		if (now - before > 118000 || !phone.equals(user.getPhone())) {// ����120s���������·���
			SessionManager.addAttribute(request, SessionManager.Key.VERIFICATION, phone + ";" + code);// ������֤��
			SessionManager.addAttribute(request, SessionManager.Key.TIMESTAMP, now);// ����ʱ��

			new Thread(new Runnable() {
				@Override
				public void run() {
					SendSmsResponse ssResponse;
					try {
						ssResponse = AliMsgUtil.sendSms(code, phone);
						System.out.println("短信回执----------------");
						System.out.println("Code=" + ssResponse.getCode());
						System.out.println("Message=" + ssResponse.getMessage());
						System.out.println("RequestId=" + ssResponse.getRequestId());
						System.out.println("BizId=" + ssResponse.getBizId());
						System.out.println(phone);

					} catch (ClientException e) {
						logger.error("���﷢����֤���쳣��", e);
					}
				}

			}).start();
		}
		json.put("result", true);
		this.writeJSON(json.toJSONString());
	}

	@RequestMapping("/to/weixin")
	public void weixinLogin(String signature, String echostr, String timestamp, String nonce) {
		System.out.println(signature);
		System.out.println(echostr);
		JSONObject json = new JSONObject();
		json.put("echostr", echostr);
		this.writeJSON(json.toJSONString());
	}

	@RequestMapping("/to/qq")
	public String qqLogin() {
		Enumeration<String> keys = request.getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println(key + " : " + request.getParameter(key));
		}
		return "index";
	}
	
	
}
