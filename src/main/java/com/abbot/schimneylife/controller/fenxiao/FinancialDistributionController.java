package com.abbot.schimneylife.controller.fenxiao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.fenxiao.CommissionDistribution;
import com.abbot.schimneylife.pojo.fenxiao.FinancialDistribution;
import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.fenxiao.ProductCateDistribution;
import com.abbot.schimneylife.pojo.fenxiao.ProductDistribution;
import com.abbot.schimneylife.pojo.fenxiao.WithdrawDistribution;
import com.abbot.schimneylife.pojo.shopping.MallProductType;
import com.abbot.schimneylife.service.fenxiao.CommissionDistributionService;
import com.abbot.schimneylife.service.fenxiao.FinancialDistributionService;
import com.abbot.schimneylife.service.fenxiao.OrdersDistributionService;
import com.abbot.schimneylife.service.fenxiao.ProductCateDistributionService;
import com.abbot.schimneylife.service.fenxiao.ProductDistributionService;
import com.abbot.schimneylife.util.CommonKey;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/distribution/financial")
@Controller
public class FinancialDistributionController extends BaseController {

	@Resource
	private FinancialDistributionService fService;

	@RequestMapping("/selectFinancial")
	public ModelAndView selectFinancial() {
		ModelAndView model = new ModelAndView("manager/distribution_financialList");
		List<FinancialDistribution> financialList = fService.selectFinancial();
		model.addObject("financialList", financialList);
		model.addObject("count", financialList.size());
		return model;
	}

	@RequestMapping("/selectFinancialBy")
	public ModelAndView selectFinancialBy(String name) {
		ModelAndView model = new ModelAndView("manager/distribution_financialList");
		List<FinancialDistribution> financialList = fService.selectFinancialBy(name);
		model.addObject("financialList", financialList);
		model.addObject("count", financialList.size());
		return model;
	}

	@RequestMapping("/index")
	public ModelAndView index(String typeId) {
		ModelAndView model = new ModelAndView("manager/distribution_financialList");
		Integer totalCount = fService.totalCount();
		model.addObject("count", totalCount);// 商品总数量
		if (typeId != null && !typeId.isEmpty()) {
			model.addObject("typeIde", typeId);
		}
		return model;
	}

	@RequestMapping("/findByType")
	public void findByType(Integer draw,  Integer start, Integer length) {
		
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "f.id";
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
		List<FinancialDistribution> fList = fService.findByPageAndType(column,
				"asc".equals(order) ? "asc" : "desc",start,
				length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(fList));
		json.put("draw", draw);
		Integer totalResult = fService.totalCount();
		json.put("recordsTotal", totalResult);
		json.put("recordsFiltered", totalResult);
		this.writeJSON(json.toJSONString());
	}
}