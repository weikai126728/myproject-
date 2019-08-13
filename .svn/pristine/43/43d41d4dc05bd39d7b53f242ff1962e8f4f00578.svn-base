package com.abbot.schimneylife.controller.user;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.pojo.user.Authority;
import com.abbot.schimneylife.service.user.AuthorityService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/manager/authority")
@Controller
public class AuthorityManagerController {
	private static final Logger logger = Logger.getLogger(AuthorityManagerController.class);
	@Resource
	private AuthorityService authorityService;
	
	@RequestMapping("/allocation")
	public ModelAndView allocation(Integer roleId) {
		ModelAndView model = new ModelAndView("manager/manager_authority");
		List<Authority> authorityList = authorityService.findAllFather();
		model.addObject("list", authorityList);
		model.addObject("roleId", roleId);
		List<Integer> list = authorityService.findByRoleId(roleId);
		JSONArray array = (JSONArray) JSONObject.toJSON(list);
		model.addObject("array", array);
		return model;
	}
	@RequestMapping("/save")
	public ModelAndView save(Integer[] authority,Integer roleId) {
		ModelAndView model = new ModelAndView("manager/tips");
		String msg = "保存失败";
		try {
			authorityService.allocation(roleId, authority);
			msg = "保存成功";
		} catch (Exception e) {
			logger.error("保存角色权限关联关系异常",e);
		}
		model.addObject("msg",msg);
		model.addObject("path","manager/authority/allocation.do?roleId="+roleId);
		return model;
	}
}
