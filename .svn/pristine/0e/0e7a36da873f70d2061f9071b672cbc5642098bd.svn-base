package com.abbot.schimneylife.controller.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.YingLiOrder;
import com.abbot.schimneylife.service.shopping.YingLiOrderService;
import com.abbot.schimneylife.util.CommonKey;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/manager/yingli")
@Controller
public class YingLiManagerController extends BaseController{

	@Resource
	private YingLiOrderService orderService;
	
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("manager/yingli_home");
		model.addObject("total",orderService.countTotal(null, null, null));
		return model;
	}
	@RequestMapping("/findByPage")
	public void findByPage(Integer draw,Integer start,Integer length,String startTime,String endTime) {
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = null;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = null;
		}
		List<YingLiOrder> orders = orderService.findByPage(start*length, length, search, startTime, endTime);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(orders));
		json.put("draw", draw);
		Integer totalResult = orderService.countTotal(null, null, null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = orderService.countTotal(search, startTime, endTime);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
}
