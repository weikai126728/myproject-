package com.abbot.schimneylife.controller.user;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.CustomerShippingAddress;
import com.abbot.schimneylife.pojo.user.Join;
import com.abbot.schimneylife.pojo.user.Opinion;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.pojo.user.UserCustomer;
import com.abbot.schimneylife.service.shopping.CustomerShippingAddressService;
import com.abbot.schimneylife.service.user.JoinService;
import com.abbot.schimneylife.service.user.OpinionService;
import com.abbot.schimneylife.util.SessionManager;
import com.abbot.schimneylife.util.SessionManager.Key;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/my")
public class MyController extends BaseController {

	@Resource
	private OpinionService os;
	@Resource
	private JoinService js;
	@Resource
	private CustomerShippingAddressService csas;

	/**
	 * 意见建议
	 * 
	 * @param request
	 * @param name
	 * @param phone
	 * @param message
	 * @return
	 */
	@RequestMapping("/opinion")
	public void addOpinion(HttpServletRequest request, String name, String phone, String message) {
		Opinion opinion = new Opinion();
		User user = SessionManager.getAttribute(request, Key.USER);
		opinion.setUserId(user.getId() + "");
		opinion.setName(name);
		opinion.setPhone(phone);
		opinion.setMessage(message);
		JSONObject object;
		if (os.insert(opinion) > 0) {
			// ModelAndView model = new ModelAndView("page/shopping/wap_opinion");
			// model.addObject("errMessage", "提交成功");
			// System.out.println("添加成功");
			// return model;
			object = this.createJSONResult(0, "true");
			this.writeJSON(object.toJSONString());
		} else {
			// ModelAndView model = new ModelAndView("page/shopping/wap_opinion");
			// System.out.println("添加失败");
			// model.addObject("errMessage", "提交失败");
			// return model;
			object = this.createJSONResult(0, "提交失败");
			this.writeJSON(object.toJSONString());
		}

	}

	@RequestMapping("/toOpinion")
	public ModelAndView toOpinion() {
		ModelAndView model = new ModelAndView("page/shopping/wap_opinion");
		return model;
	}

	@RequestMapping("/toJoin")
	public ModelAndView toJoin() {
		ModelAndView model = new ModelAndView("page/shopping/wap_join");
		return model;
	}

	/**
	 * 加入我们
	 * 
	 * @param request
	 * @param name
	 * @param phone
	 * @param store
	 * @param type
	 * @param address
	 * @param place
	 * @return
	 */
	@RequestMapping("/join")
	public void addJoin(HttpServletRequest request, String name, String phone, String store, String type,
			String address, String place) {
		Join join = new Join();
		User user = SessionManager.getAttribute(request, Key.USER);
		join.setUserId(user.getId());
		join.setName(name);
		join.setPhone(phone);
		join.setStore(store);
		join.setType(type);
		join.setAddress(address);
		join.setPlace(place);
		JSONObject object;
		if (js.insert(join) != 0) {
			// ModelAndView model = new ModelAndView("page/shopping/wap_join");
			// model.addObject("errMessage", "提交成功");
			// return model;
			object = this.createJSONResult(0, "true");
			this.writeJSON(object.toJSONString());
		} else {
			// ModelAndView model = new ModelAndView("page/shopping/wap_join");
			// model.addObject("errMessage", "提交失败");
			// return model;
			object = this.createJSONResult(0, "添加失败");
			this.writeJSON(object.toJSONString());
		}

	}

	/**
	 * 新建地址
	 * 
	 * @param request
	 * @param name
	 * @param phone
	 * @param address
	 * @param place
	 * @return
	 */
	@RequestMapping("/address")
	public void insertAddress(HttpServletRequest request, String name, String phone, String address, String place,
			String idCard,Integer status) {
		JSONObject object;
		UserCustomer userCustomer = SessionManager.getAttribute(request, Key.CUSTOMER);
		CustomerShippingAddress csa = new CustomerShippingAddress();
		csa.setContactUser(name);
		csa.setContactPhone(phone);
		csa.setAddress(address);
		csa.setPlace(place);
		csa.setContactUserIdCard(idCard);
		csa.setStatus(status);
		csa.setCustomerId(userCustomer.getId());
		if (csas.addAddress(csa)) {
			if(status==1) {				
				csas.updateAddressMessage(userCustomer.getId(), csa.getId());
			}
			// ModelAndView model = new ModelAndView("redirect:/my/checkAddress.do");
			// return model;
			object = this.createJSONResult(0, "true");
			this.writeJSON(object.toJSONString());
		}
		// ModelAndView model = new ModelAndView("page/shopping/wap_address");
		// model.addObject("errMessage", "新增地址失败");
		// System.out.println("新增地址失败");
		// return model;
		object = this.createJSONResult(0, "新增地址失败");
		this.writeJSON(object.toJSONString());
	}

	/**
	 * 地址管理
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/checkAddress")
	public ModelAndView checkAddress(HttpServletRequest request, HttpServletResponse response) {
		UserCustomer userCustomer = SessionManager.getAttribute(request, Key.CUSTOMER);
		List<CustomerShippingAddress> csa = Collections.emptyList();
		csa = csas.queryCustomerShippingAddress(userCustomer.getId());
		int length = csa.size();
		ModelAndView model = new ModelAndView("page/shopping/wap_checkAddress");
		model.addObject("listAddress", csa);
		model.addObject("length", length);
		return model;
	}

	/**
	 * 地址管理
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/selectAddress")
	public ModelAndView selectAddress(HttpServletRequest request, HttpServletResponse response, String ids,
			String mallIds, Integer addressId, String paramId, String productId,Integer count) {
		UserCustomer userCustomer = SessionManager.getAttribute(request, Key.CUSTOMER);
		List<CustomerShippingAddress> csa = Collections.emptyList();
		csa = csas.queryCustomerShippingAddress(userCustomer.getId());
			ModelAndView model = new ModelAndView("page/shopping/wap_selectAddress");
			model.addObject("listAddress", csa);
			model.addObject("ids", ids);
			model.addObject("mallIds", mallIds);
			model.addObject("addressId", addressId);	
			model.addObject("productId", productId);
			model.addObject("paramId", paramId);
			model.addObject("count", count);
			return model;
	}

	/**
	 * 修改默认地址
	 * 
	 * @param request
	 * @param id
	 */
	@RequestMapping("/updateAddressMessage")
	public void updateAddressMessage(HttpServletRequest request, Integer id) {
		UserCustomer userCustomer = SessionManager.getAttribute(request, Key.CUSTOMER);
		csas.setAddressMessage(id);
		boolean bool = csas.updateAddressMessage(userCustomer.getId(), id);
		JSONObject object = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(object.toJSONString());
	}

	/**
	 * 修改地址
	 * 
	 * @param request
	 * @param id
	 * @param name
	 * @param phone
	 * @param address
	 * @param place
	 * @param idCard
	 * @return
	 */
	@RequestMapping("/updateAddress")
	public void updateAddress(HttpServletRequest request, Integer id, String name, String phone, String address,
			String place, String idCard , Integer status) {
		JSONObject object;
		CustomerShippingAddress csa = new CustomerShippingAddress();
		csa.setId(id);
		csa.setContactUser(name);
		csa.setContactPhone(phone);
		csa.setAddress(address);
		csa.setPlace(place);
		csa.setContactUserIdCard(idCard);
		csa.setStatus(status);
		if (csas.updateAddress(csa)) {
			// ModelAndView model = new ModelAndView("redirect:checkAddress.do");
			// return model;
			object = this.createJSONResult(0, "true");
			this.writeJSON(object.toJSONString());
		}
		object = this.createJSONResult(0, "修改失败");
		this.writeJSON(object.toJSONString());
		// ModelAndView model = new ModelAndView("");
		// return model;
	}

	/**
	 * 根据ID查找地址
	 * 
	 * @param request
	 * @param id
	 */
	@RequestMapping("/fetchAddressId")
	public ModelAndView fetchAddressId(HttpServletRequest request, Integer id) {
		CustomerShippingAddress customerAddress = csas.fetchCommonId(id);
		ModelAndView model = new ModelAndView("page/shopping/wap_updateAddress");
		model.addObject("customerAddress", customerAddress);
		return model;
	}

	/**
	 * 删除地址
	 * 
	 * @param request
	 * @param id
	 */
	@RequestMapping("/deleteAddress")
	public void deleteAddress(HttpServletRequest request, Integer id) {
		UserCustomer userCustomer = SessionManager.getAttribute(request, Key.CUSTOMER);
		Integer Nid = csas.deleteAddress(id,userCustomer.getId());
		
		// ModelAndView model = new ModelAndView("redirect:checkAddress.do");
		// return model;
		JSONObject object = this.createJSONResult(0, Nid);
		this.writeJSON(object.toJSONString());
	}
}
