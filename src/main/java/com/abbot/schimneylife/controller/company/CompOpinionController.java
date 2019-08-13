package com.abbot.schimneylife.controller.company;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.company.compOpinion;
import com.abbot.schimneylife.service.company.CompOpinionService;
import com.abbot.schimneylife.util.CommonKey;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/company/opinion")
public class CompOpinionController extends BaseController{

	@Resource
	CompOpinionService opinionService;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("manager/company_opinion");
		Integer totalCount = opinionService.totalCount();
		model.addObject("count", totalCount);// 商品总数量
		return model;
	}

	@RequestMapping("/findByType")
	public void findByType(Integer draw, Integer start, Integer length) {
		String order = request.getParameter("order[0][dir]");
		String column = "create_time";
		List<compOpinion> comList = opinionService.findByPage(column, "asc".equals(order) ? "asc" : "desc", start,
				length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(comList));
		json.put("draw", draw);
		Integer totalResult = opinionService.totalCount();
		json.put("recordsTotal", totalResult);
		json.put("recordsFiltered", totalResult);
		this.writeJSON(json.toJSONString());
	}
	
	@RequestMapping("/deleteById")
	public void deleteById(String opinionId) {
		boolean bool=opinionService.deleteById(opinionId);
		JSONObject object = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(object.toJSONString());
	}
}
