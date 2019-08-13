package com.abbot.schimneylife.controller.manager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.CustomerOrder;
import com.abbot.schimneylife.pojo.user.Authority;
import com.abbot.schimneylife.pojo.user.Role;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.pojo.user.UserCustomer;
import com.abbot.schimneylife.pojo.weixin.OrderMerchantPayment;
import com.abbot.schimneylife.pojo.weixin.WanghongTixian;
import com.abbot.schimneylife.service.shopping.CustomerOrderService;
import com.abbot.schimneylife.service.user.AuthorityService;
import com.abbot.schimneylife.service.user.RoleService;
import com.abbot.schimneylife.service.user.UserCustomerService;
import com.abbot.schimneylife.service.user.UserOperationLogService;
import com.abbot.schimneylife.service.user.UserService;
import com.abbot.schimneylife.service.weixin.RedpackService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigNativeUtil;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.Md5Util;
import com.abbot.schimneylife.util.MerchantPaymentUtil;
import com.abbot.schimneylife.util.SessionManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/manager/user")
@Controller
public class UserManagerController extends BaseController {
	private static final Logger logger = Logger.getLogger(UserManagerController.class);
	@Resource
	private UserService userService;
	@Resource
	private UserCustomerService customerService;
	@Resource
	private RoleService roleService;
	@Resource
	private AuthorityService authorityService;
	@Resource
	private CustomerOrderService orderService;
	@Resource
	private RedpackService redService;
	@Resource
	private UserOperationLogService operationLogService;

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	public ModelAndView addUser(String name, int gender, String phone, int status) {
		try {
			User user = new User();
			UserCustomer uc = new UserCustomer();
			String password = "123456";
			String salt = Md5Util.createSalt();
			user.setSalt(salt);
			String encode;
			encode = Md5Util.encodeByMod5(password, salt);
			user.setPassword(encode);
			user.setNickName(name);
			user.setPhone(phone);
			user.setGender(gender);
			user.setStatus(status);
			userService.addUser(user, CommonKey.Role.MEMBER.getLevel());
			uc.setUserID(user.getId());
			customerService.addCustomer(uc);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView model = new ModelAndView("redirect:userList.do");
		return model;
	}
	@RequestMapping("/addLineRed")
	public ModelAndView addLineRed(String name, int gender, String phone, int status,String number) {
		try {
			User user = new User();
			String password = "123456";
			String salt = Md5Util.createSalt();
			user.setSalt(salt);
			String encode;
			encode = Md5Util.encodeByMod5(password, salt);
			user.setPassword(encode);
			user.setNickName(name);
			user.setPhone(phone);
			user.setNumber(number);
			user.setGender(gender);
			user.setStatus(status);
			userService.addUser(user, CommonKey.Role.LINERED.getLevel());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView model = new ModelAndView("redirect:redIndex.do");
		return model;
	}

	/**
	 * 查询用户列表
	 * 
	 * @return
	 */
	@RequestMapping("/userList")
	public ModelAndView selectUser() {
		List<User> list = userService.selectAllUser();
		ModelAndView model = new ModelAndView("manager/user_list");
		int count = list.size();
		model.addObject("userList", list);
		model.addObject("count", count);
		return model;
	}
	@RequestMapping("/index")
	public ModelAndView index(String typeId) {
		ModelAndView model=new ModelAndView("manager/user_list");
		Integer totalCount=userService.selectCount();
		model.addObject("count",totalCount);//商品总数量
		if(typeId!=null&&!typeId.isEmpty()) {
			model.addObject("typeIde",typeId);
		}
		return model;
	}
	@RequestMapping("/redIndex")
	public ModelAndView redIndex() {
		ModelAndView model=new ModelAndView("manager/user_red_list");
		Integer totalCount=userService.totalCount(null);
		model.addObject("count",totalCount);//商品总数量
		
		return model;
	}
	@RequestMapping("/queryRedUserByPhone")
	public ModelAndView queryRedUserByPhone(String number) {
		ModelAndView model=new ModelAndView("manager/user_red_detail");
		Integer totalCount=userService.redCount(number);
		model.addObject("count",totalCount);//商品总数量
		model.addObject("number", number);
		return model;
	}
	
	@RequestMapping("/findByType")
	public void findByType(Integer draw,Integer start,Integer length) {
		
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "id";
		if(orderCol!=null) {
			switch(orderCol) {
			case 6:
				column = "create_time";
				break;
			case 7:
				column = "param_status";
				break;
			}
		}
		List<User> userList = userService.findByPageAndType( column, "asc".equals(order)?"asc":"desc", start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(userList));
		json.put("draw", draw);
		Integer totalCount=userService.selectCount();
		json.put("recordsTotal", totalCount);
		json.put("recordsFiltered", totalCount);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/findRedByType")
	public void findRedByType(Integer draw,Integer start,Integer length) {
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "id";
		if(orderCol!=null) {
			switch(orderCol) {
			case 6:
				column = "create_time";
				break;
			case 7:
				column = "param_status";
				break;
			}
		}
		List<User> userList = userService.findRedByType( column, "asc".equals(order)?"asc":"desc", start, length,search);
		JSONArray array = (JSONArray) JSONArray.toJSON(userList);
		String[] productIds = null;
		if(ConfigureUtil.LINEREDPRODUCT.toString()!=null&&!"".equals(ConfigureUtil.LINEREDPRODUCT.toString().trim())) {
			productIds = ConfigureUtil.LINEREDPRODUCT.toString().split(",");
		}
		Double percent = 0d;
		if(ConfigureUtil.LINEREDPERCENTAGE.toString()!=null&&!"".equals(ConfigureUtil.LINEREDPERCENTAGE.toString().trim())) {
			percent = Double.valueOf(ConfigureUtil.LINEREDPERCENTAGE.toString());
		}
		for(int i=0;i<array.size();i++) {
			List<User> fans = userService.findRedDetailByType(null, null, null, null, array.getJSONObject(i).getString("number"));
			Integer[] userIds = new Integer[fans.size()];
			for(int j=0;j<fans.size();j++) {
				userIds[j] = fans.get(j).getId();
			}
			Double money = orderService.sumTotalByProduct(null, null, null, productIds, userIds.length==0?null:userIds, true);
			array.getJSONObject(i).put("money", money);
			array.getJSONObject(i).put("percent", money*percent);
			array.getJSONObject(i).put("fans", fans.size());
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, array);
		json.put("draw", draw);
		Integer totalCount=userService.totalCount(null);
		json.put("recordsTotal", totalCount);
		Integer recordsFiltered = userService.totalCount(search);
		json.put("recordsFiltered", recordsFiltered);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/findRedDetailByType")
	public void findRedDetailByType(Integer draw,Integer start,Integer length,String number) {
		
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "id";
		if(orderCol!=null) {
			switch(orderCol) {
			case 6:
				column = "create_time";
				break;
			case 7:
				column = "param_status";
				break;
			}
		}
		List<User> userList = userService.findRedDetailByType( column, "asc".equals(order)?"asc":"desc", start, length,number);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(userList));
		json.put("draw", draw);
		Integer totalCount=userService.redCount(number);
		json.put("recordsTotal", totalCount);
		json.put("recordsFiltered", totalCount);
		this.writeJSON(json.toJSONString());
	}
	/**
	 * 查询用户个人信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryUserById")
	public ModelAndView queryUserById(Integer id) {
		ModelAndView model = new ModelAndView("manager/user_show");
		User user = userService.findById(id);
		UserCustomer uc = customerService.fetchByUserId(id);
 
		model.addObject("user", user);
		model.addObject("customer", uc);
 
		return model;
	}

	/**
	 * 修改时单查
	 * 
	 * @param phone
	 * @return
	 */
	@RequestMapping("/findById")
	public ModelAndView findById(int userId) {
		User user = userService.findById(userId);
		ModelAndView model = new ModelAndView("manager/user_update");
		model.addObject("user", user);
		return model;
		// JSONObject object = this.createJSONResult(0, String.valueOf(user));
		// this.writeJSON(object.toJSONString());
	}

	/**
	 * 修改用户
	 * 
	 * @param id
	 * @param name
	 * @param gender
	 * @param phone
	 * @param status
	 * @return
	 */
	@RequestMapping("/updateUser")
	public void updateUser(int id, String name, int gender, String phone, int status) {
		User user = new User();
		user.setId(id);
		user.setNickName(name);
		user.setGender(gender);
		user.setPhone(phone);
		user.setStatus(status);
		int i = userService.updateUser(user);
		JSONObject object = this.createJSONResult(0, String.valueOf(i));
		this.writeJSON(object.toJSONString());

	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
//	@RequestMapping("/deleteOneUser")
//	public void deleteOneUser(int userId) {
//		boolean used = userService.deleteOneUser(userId);
//		JSONObject object = this.createJSONResult(0, String.valueOf(used));
//		this.writeJSON(object.toJSONString());
//	}

	/**
	 * 停用
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/stop")
	public void disable(int userId) {
		
		boolean used = userService.disable(userId);
		JSONObject object = this.createJSONResult(0, String.valueOf(used));
		this.writeJSON(object.toJSONString());
		// ModelAndView model = new ModelAndView("redirect:userList.do");
		// return model;
	}

	/**
	 * 启用
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/start")
	public void enable(int userId) {
	
		boolean used = userService.enable(userId);
		JSONObject object = this.createJSONResult(0, String.valueOf(used));
		this.writeJSON(object.toJSONString());
		// ModelAndView model = new ModelAndView("forword:userList.do");
		// return model;
	}

	/**
	 * 搜索查询
	 * 
	 * @param name
	 * @param time
	 */
	@RequestMapping("/selectUser")
	public ModelAndView selectUser(String name) {
		List<User> user = userService.selectUserByName(name);
		ModelAndView model = new ModelAndView("manager/user_select");
		model.addObject("count", user.size());
		model.addObject("userList", user);
		return model;
	}
	@RequestMapping("/selectRedUser")
	public ModelAndView selectRedUser(String name) {
		List<User> user = userService.selectRedUserByName(name);
		ModelAndView model = new ModelAndView("manager/user_red_select");
		model.addObject("count", user.size());
		model.addObject("userList", user);
		return model;
	}

	/**
	 * 登陆页
	 * 
	 * @return
	 */
	@RequestMapping("/to/login")
	public ModelAndView toLogin() {
		ModelAndView model = new ModelAndView("manager/login");
		return model;
	}

	/**
	 * 登陆验证
	 * 
	 * @param loginName
	 * @param password
	 */
	@RequestMapping("/to/in")
	public void login(String loginName, String password) {
		User user = userService.findByLoginName(loginName);
		boolean res = false;
		String path = "";
		if (user != null && user.getStatus() == CommonKey.ENABLE_FLAG && user.getRole() != null) {
			List<Authority> aList = authorityService.findByRole(user.getRole().getId());
			//只要角色分配了权限就可以进入
			if(user.getRole().getLevel().equals(CommonKey.Role.SUPERMANAGER.getLevel())||(aList!=null&&aList.size()>0)){
				try {
					if (Md5Util.checkPassword(password, user.getSalt(), user.getPassword())) {
						res = true;
						SessionManager.addAttribute(request, SessionManager.Key.USER, user);
						UserCustomer customer = customerService.fetchByUserId(user.getId());
						SessionManager.addAttribute(request, SessionManager.Key.CUSTOMER, customer);
						if (SessionManager.contains(request, SessionManager.Key.REDIRECTURL)) {
							path = SessionManager.getAttribute(request, SessionManager.Key.REDIRECTURL);
							SessionManager.removeAttribute(request, SessionManager.Key.REDIRECTURL);
						} else {
							path = request.getContextPath() + "/manager/system/index.do";
						}
					}
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, res);
		json.put("path", path);
		this.writeJSON(json.toJSONString());
	}

	@RequestMapping("/logout")
	public void logout() {
		SessionManager.removeAll(request);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
	}

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("manager/manager_list");
		List<Role> roleList = roleService.groupByNoMarketAndMember();
		model.addObject("roleList", roleList);
		Integer total = 0;
		for (Role role : roleList) {
			total += role.getNumber();
		}
		model.addObject("total", total);
		List<Role> roles = roleService.findByNoMarketAndMember();
		model.addObject("roles", roles);
		return model;
	}

	@RequestMapping("/findByPage")
	public void findByPage(Integer draw, Integer start, Integer length, Integer level) {
		String search = request.getParameter("search[value]");
		String order = request.getParameter("order[0][dir]");
		List<User> userList = userService.findByLevel(level, start, length, search, order);
		JSONArray array = new JSONArray();
		for (User user : userList) {
			JSONObject o = new JSONObject();
			o.put("realName", user.getRealName());
			o.put("nickName", user.getNickName());
			o.put("phone", user.getPhone());
			o.put("birthday", user.getBirthday());
			o.put("createTime", user.getCreateTime().substring(0, 16));
			o.put("status", user.getStatus());
			o.put("roleName", user.getRole().getName());
			o.put("id", user.getId());
			array.add(o);
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, array);
		json.put("draw", draw);
		Integer totalResult = userService.countByLevel(level, null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = userService.countByLevel(level, search);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}

	@RequestMapping("/disable")
	public void disable(Integer id) {
		User user = userService.findById(id);
		if (user != null && user.getRole() != null
				&& user.getRole().getLevel() != CommonKey.Role.SUPERMANAGER.getLevel()) {
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, userService.disable(id)).toJSONString());
		} else {
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}

	@RequestMapping("/enable")
	public void enable(Integer id) {
		User user = userService.findById(id);
		if (user != null && user.getRole() != null
				&& user.getRole().getLevel() != CommonKey.Role.SUPERMANAGER.getLevel()) {
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, userService.enable(id)).toJSONString());
		} else {
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}

	@RequestMapping("/delete")
	public void delete(Integer id) {
		User user = userService.findById(id);
		boolean res = false;
		String msg = "";
		if (user != null && user.getStatus() == CommonKey.DISABLE_FLAG
				&& user.getRole().getLevel() >= CommonKey.Role.MANAGER.getLevel()) {
			try {
				userService.deletUserAndRelation(id);
				res = true;
			} catch (Exception e) {
				logger.error(e);
				msg = "删除失败";
				res = false;
			}
		} else {
			msg = "只能删除禁用状态的普通管理员";
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, res);
		json.put("msg", msg);
		this.writeJSON(json.toJSONString());
	}
	/**
	 * 拥有权限的昵称只能有一个，不能重复
	 * @param user
	 * @param level
	 * @return
	 */
	@RequestMapping("/addManager")
	public ModelAndView addManager(User user, Integer level) {
		ModelAndView model = new ModelAndView("manager/tips");
		boolean used = userService.nickUsed(user.getNickName());
//		boolean used = userService.phoneUsed(user.getPhone(),level);
		if(!used) {//手机号唯一
			model.addObject("msg", "昵称已被使用！");
		}else {
			try {
				String salt = Md5Util.createSalt();
				user.setSalt(salt);
				String pas = Md5Util.encodeByMod5(user.getPassword(), salt);
				user.setPassword(pas);
				user.setStatus(CommonKey.DISABLE_FLAG);
				userService.addUser(user, level);
				model.addObject("msg", "添加成功！");
			} catch (Exception e) {
				logger.error(e);
				model.addObject("msg", "添加失败！");
			}			
		}
		model.addObject("path", "manager/user/list.do");
		return model;
	}

	@RequestMapping("/rolelist")
	public ModelAndView roleList() {
		ModelAndView model = new ModelAndView("manager/manager_role");
		List<Role> roleList = roleService.findAll();
		model.addObject("roleList", roleList);
		return model;
	}

	@RequestMapping("/manageredit")
	public ModelAndView managerEdit(Integer userId) {
		ModelAndView model = new ModelAndView("manager/manager_edit");
		User user = userService.findById(userId);
		model.addObject("user", user);
//		List<Role> roleList = roleService.findByLevelLessThan(CommonKey.Role.MANAGER.getLevel());
		List<Role> roleList = roleService.groupByNoMarketAndMember();
		model.addObject("roleList", roleList);
		return model;
	}

	@RequestMapping("/editManager")
	public void editManager(User user, Integer roleId) {
		try {
			if (user.getPassword() != null&&!"".equals(user.getPassword().trim())) {
				String salt = Md5Util.createSalt();
				user.setSalt(salt);
				user.setPassword(Md5Util.encodeByMod5(user.getPassword(), salt));
			}else {
				user.setPassword(null);
			}
			userService.updateUser(user, roleId);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}

	/**
	 * 新增角色
	 * 
	 * @param role
	 */
	@RequestMapping("/addRole")
	public void addRole(Role role) {
		boolean res = roleService.addRole(role);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}

	@RequestMapping("/updateRole")
	public void updateRole(Role role) {
		boolean res = roleService.updateRole(role);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}

	@RequestMapping("/delRole")
	public void delRole(Integer roleId) {
		Integer num = roleService.counUserByRoleId(roleId);
		boolean res = false;
		if (num == 0) {
			res = roleService.delete(roleId);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}

	/**
	 * 修改密码
	 * 
	 * @param oldPass
	 * @param newPass
	 */
	@RequestMapping("/updatePassword")
	public void updatePassword(String oldPass, String newPass) {
		User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		boolean res = false;
		try {
			if (Md5Util.checkPassword(oldPass, user.getSalt(), user.getPassword()) && newPass != null) {
				String salt = Md5Util.createSalt();
				user.setSalt(salt);
				user.setPassword(Md5Util.encodeByMod5(newPass, salt));
				res = userService.updatePassword(user);
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			logger.error("修改密码", e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	
	
	
	@RequestMapping("/queryWanghongCount")
	public ModelAndView queryWanghongCount() {
		ModelAndView model=new ModelAndView("manager/red_wanghong_list");
		Integer totalCount=userService.totalCount(null);
		model.addObject("count",totalCount);//商品总数量
		return model;
	}
	
	
	@RequestMapping("/queryWanghongList")
	public void queryWanghongList(Integer draw, String typeId, Integer start, Integer length) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "id";
		if (orderCol != null) {
			switch (orderCol) {
			case 6:
				column = "id";
				break;
			case 7:
				column = "id";
				break;
			}
		}
		List<User> user =userService.queryWanghongList(search, column,
				"asc".equals(order) ? "asc" : "desc", typeId == null || typeId.trim().isEmpty() ? null : typeId, start,
				length);
		for (User u : user) {
			System.out.println("++++"+u.getOpenid());
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(user));
		json.put("draw", draw);
		Integer totalResult = userService.queryWanghongCount();
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = userService.queryWanghongCount();
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	
	
	@RequestMapping("/tixianWanghong")
	public void tixianWanghong(String alopenid, double money,String nickname,Integer userid) {
		User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		String datell = SessionManager.getAttribute(request, SessionManager.Key.DATELL);
		Integer merchantpayment=(int) (money*100);
		logger.info("企业转账的用户为："+alopenid+" 金额为："+merchantpayment+"操作人为："+user.getNickName()+"收款人姓名:"+nickname+"系统当前时间为datell:"+datell);
		SortedMap<Object, Object> map = new TreeMap<Object, Object>();
		if(merchantpayment<=0) {
			logger.error("企业付款任务失败金额必须大于0");
			JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, "false");
			this.writeJSON(json.toJSONString());
		}else {
		try {
			map = (SortedMap<Object, Object>) MerchantPaymentUtil.merchantPayment(alopenid, merchantpayment);
			if (String.valueOf(map.get("return_code")).equalsIgnoreCase("SUCCESS")
					&& String.valueOf(map.get("result_code")).equalsIgnoreCase("SUCCESS")) {
				logger.info("企业付款加盟商任务成功");
				OrderMerchantPayment orderMerchantPayment = new OrderMerchantPayment();
				orderMerchantPayment.setPayment_no(String.valueOf(map.get("payment_no")));
				orderMerchantPayment.setPartner_trade_no(String.valueOf(map.get("partner_trade_no")));
				orderMerchantPayment.setMchid(ConfigNativeUtil.MCH_ID);
				orderMerchantPayment.setMch_appid(ConfigNativeUtil.APP_ID);
				orderMerchantPayment.setMerchantpayment(merchantpayment);
				orderMerchantPayment.setStorename("网红提现");
				orderMerchantPayment.setAlname("操作人为："+user.getNickName());
				orderMerchantPayment.setAlopenid(alopenid);
				boolean boo = redService.addMerchantPayment(orderMerchantPayment);
				
				WanghongTixian wanghongtixian=new WanghongTixian();
				wanghongtixian.setAlopenid(alopenid);
				wanghongtixian.setMch_appid(ConfigNativeUtil.APP_ID);
				wanghongtixian.setMerchantpayment(merchantpayment);
				wanghongtixian.setNickName(nickname);
				wanghongtixian.setStorename("网红提现");
				wanghongtixian.setOperator(user.getNickName());
				wanghongtixian.setPartner_trade_no(String.valueOf(map.get("partner_trade_no")));
				wanghongtixian.setPayment_no(String.valueOf(map.get("payment_no")));
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String date1 = df.format(new Date());// new Date()为获取当前系统时间
				logger.info("付款时间为:"+date1);
				wanghongtixian.setPayment_time(date1);
				boolean bool=userService.addRednetnow(wanghongtixian);
				
				if (boo) {
					logger.info("手动企业付款存储成功");
				}else {
					logger.error("手动企业付款存储任务失败");
				}
				if(bool) {
					logger.info("网红提现信息存储网红提现表成功");
				}else {
					logger.error("网红提现信息存储网红提现表任务失败");
				}
				
				String[] productIds = null;
				if(ConfigureUtil.LINEREDPRODUCT.toString()!=null&&!"".equals(ConfigureUtil.LINEREDPRODUCT.toString().trim())) {
					productIds = ConfigureUtil.LINEREDPRODUCT.toString().split(",");
				}
				System.out.println("userid:"+userid);
				Integer userId=userid;
				System.out.println("userId:"+userId);
				Integer[] userIds = null;
					User red = userService.findById(userId);
					List<User> fans = userService.findRedDetailByType(null, null, null, null, red.getNumber());
					userIds = new Integer[fans.size()];
					for(int i = 0;i<fans.size();i++) {
						userIds[i] = fans.get(i).getId();
					}
				List<CustomerOrder> orderList = orderService.findByPageAndProductByTime(null, null, null, null, null, productIds, userIds, null, null, true,datell);
				for (CustomerOrder c : orderList) {
					System.out.println(c.getId()+"**********"+c.getCreateTime());
					
					try {
						orderService.updateCashbackStatus(c.getId(), CommonKey.Order.CASHBACK_OK.getStatus());
						User use = SessionManager.getAttribute(request, SessionManager.Key.USER);
						operationLogService.insert(use.getId(), "确认订单返现", CommonKey.UserOperationLog.ORDER.getType(), c.getId(), "");
					} catch (Exception e) {
						logger.error("确认订单返现",e);
					}
				}
				
				
				JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, "true");
				this.writeJSON(json.toJSONString());
				
				
				
				
			} else {
				logger.error("企业付款任务失败");
				JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, "false");
				this.writeJSON(json.toJSONString());
			}
		} catch (IOException e) {
			logger.error("企业付款任务时异常",e);
		}
		
	}
	}
}
