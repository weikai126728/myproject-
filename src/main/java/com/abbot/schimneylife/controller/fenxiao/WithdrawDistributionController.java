package com.abbot.schimneylife.controller.fenxiao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.fenxiao.ProductCateDistribution;
import com.abbot.schimneylife.pojo.fenxiao.ProductDistribution;
import com.abbot.schimneylife.pojo.fenxiao.WithdrawDistribution;
import com.abbot.schimneylife.pojo.shopping.MallProductType;
import com.abbot.schimneylife.service.fenxiao.OrdersDistributionService;
import com.abbot.schimneylife.service.fenxiao.ProductCateDistributionService;
import com.abbot.schimneylife.service.fenxiao.ProductDistributionService;
import com.abbot.schimneylife.service.fenxiao.WithdrawDistributionService;
import com.abbot.schimneylife.util.CommonKey;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/distribution/withdraw")
@Controller
public class WithdrawDistributionController extends BaseController {

	@Resource
	private WithdrawDistributionService withdrawService;

	@RequestMapping("/selectWithdraw")
	public ModelAndView selectWithdraw() {
		ModelAndView model = new ModelAndView("manager/distribution_withdrawList");
		List<WithdrawDistribution> whitdrawList=withdrawService.selectWithdraw();
		model.addObject("whitdrawList", whitdrawList);
		model.addObject("count", whitdrawList.size());
		return model;
	}
	@RequestMapping("/selectWithdrawBy")
	public ModelAndView selectWithdrawBy(String name) {
		List<WithdrawDistribution> whitdrawList=withdrawService.selectWithdrawBy(name);
		ModelAndView model = new ModelAndView("manager/distribution_withdrawList");
		model.addObject("whitdrawList", whitdrawList);
		model.addObject("count", whitdrawList.size());
		return model;
	}
	@RequestMapping("/delete")
	public void delete(Integer wId) {
		boolean bool=withdrawService.delete(wId);
		JSONObject object = this.createJSONResult(0, bool);
		this.writeJSON(object.toJSONString());
	}
	@RequestMapping("/update")
	public void update (Integer wId) {
		boolean bool=withdrawService.update(wId);
		JSONObject object = this.createJSONResult(0, bool);
		this.writeJSON(object.toJSONString());
	}
	@RequestMapping("/index")
	public ModelAndView index(String typeId) {
		ModelAndView model=new ModelAndView("manager/distribution_withdrawList");
		Integer totalCount=withdrawService.totalCount();
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
		String column = "w.id";
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
		List<WithdrawDistribution> withList = withdrawService.findByPageAndType(column, "asc".equals(order)?"asc":"desc", start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(withList));
		json.put("draw", draw);
		Integer totalCount=withdrawService.totalCount();
		json.put("recordsTotal", totalCount);
		json.put("recordsFiltered", totalCount);
		this.writeJSON(json.toJSONString());
	}
}