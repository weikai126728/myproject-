package com.abbot.schimneylife.controller.fenxiao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.fenxiao.CommissionDistribution;
import com.abbot.schimneylife.service.fenxiao.CommissionDistributionService;
import com.abbot.schimneylife.util.CommonKey;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
 

@RequestMapping("/distribution/commission")
@Controller
public class CommissionDistributionController extends BaseController {

	@Resource
	private CommissionDistributionService commService;

	@RequestMapping("/selectCommission")
	public ModelAndView selectCommission() {
		ModelAndView model = new ModelAndView("manager/distribution_commission");
		List<CommissionDistribution> commissionList = commService.selectCommission();
		model.addObject("commissionList", commissionList);
		model.addObject("count", commissionList.size());
		return model;
	}

	@RequestMapping("/selectCommissionBy")
	public ModelAndView selectCommissionBy(String name) {
		List<CommissionDistribution> commissionList = commService.selectCommissionBy(name);
		ModelAndView model = new ModelAndView("manager/distribution_commission");
		model.addObject("commissionList", commissionList);
		model.addObject("count", commissionList.size());
		return model;
	}

	@RequestMapping("/index")
	public ModelAndView index(String typeId) {
		ModelAndView model = new ModelAndView("manager/distribution_commission");
		Integer totalCount = commService.totalCount();
		model.addObject("count", totalCount);// 商品总数量
		if (typeId != null && !typeId.isEmpty()) {
			model.addObject("typeIde", typeId);
		}
		return model;
	}

	@RequestMapping("/findByType")
	public void findByType(Integer draw, Integer start, Integer length) {

		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "c.id";
		if (orderCol != null) {
			switch (orderCol) {
			case 6:
				column = "create_time";
				break;
			case 7:
				column = "param_status";
				break;
			}
		}
		List<CommissionDistribution> commList = commService.findByPageAndType(column,
				"asc".equals(order) ? "asc" : "desc", start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(commList));
		json.put("draw", draw);
		Integer totalResult = commService.totalCount();
		json.put("recordsTotal", totalResult);
		json.put("recordsFiltered", totalResult);
		this.writeJSON(json.toJSONString());
	}

}