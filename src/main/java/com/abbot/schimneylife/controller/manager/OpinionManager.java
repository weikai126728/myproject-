package com.abbot.schimneylife.controller.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.user.Opinion;
import com.abbot.schimneylife.service.user.OpinionService;
import com.abbot.schimneylife.util.CommonKey;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/manager/opinion")
@Controller
public class OpinionManager extends BaseController {

	@Resource
	OpinionService opService;

	@RequestMapping("/checkOpinion")
	private ModelAndView checkOpinion() {
		ModelAndView model = new ModelAndView("manager/opinion_list");
		List<Opinion> list = opService.checkOpinion();
		int count = list.size();
		model.addObject("opinionList", list);
		model.addObject("count", count);
		return model;
	}
	@RequestMapping("/index")
	public ModelAndView index(String typeId) {
		ModelAndView model=new ModelAndView("manager/opinion_list");
		Integer totalCount=opService.totalCount();
		model.addObject("count",totalCount);//商品总数量
		if(typeId!=null&&!typeId.isEmpty()) {
			model.addObject("typeIde",typeId);
		}
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
		List<Opinion> orderList = opService.findByPageAndType(column, "asc".equals(order)?"asc":"desc", start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(orderList));
		json.put("draw", draw);
		Integer totalCount=opService.totalCount();
		json.put("recordsTotal", totalCount);
		json.put("recordsFiltered", totalCount);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/deleteById")
	private void deleteById(Integer opinionId ) {
		boolean bool=opService.deleteById(opinionId);
		JSONObject object = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(object.toJSONString());
	}
}
