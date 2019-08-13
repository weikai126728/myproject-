package com.abbot.schimneylife.controller.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.service.user.UserService;
import com.abbot.schimneylife.util.CommonKey;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * 公众号  加盟店、流水、业务员
 * @author Administrator
 *
 */
@RequestMapping("/wechat")
@Controller
public class WeChatManagerController extends BaseController{

	@Resource
	private UserService userService;
	/**
	 * 分页查询业务员
	 * @param draw
	 * @param typeId
	 * @param start
	 * @param length
	 */
	@RequestMapping("/findSalesman")
	public void findSalesman(Integer draw,String typeId,Integer start,Integer length) {
		String like = request.getParameter("search[value]");
		if(like==null||like.isEmpty()) {
			like = null;
		}
		String order = request.getParameter("order[0][dir]");
		List<User> userList = userService.findByLevel(CommonKey.Role.SALESMAN.getLevel(), start, length, like, order);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(userList));
		json.put("draw", draw);
		Integer totalResult = userService.countByLevel(CommonKey.Role.SALESMAN.getLevel(), like);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = userService.countByLevel(CommonKey.Role.SALESMAN.getLevel(), null);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
}
