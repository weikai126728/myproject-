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
import com.abbot.schimneylife.pojo.shopping.MallProductType;
import com.abbot.schimneylife.service.fenxiao.OrdersDistributionService;
import com.abbot.schimneylife.service.fenxiao.ProductCateDistributionService;
import com.abbot.schimneylife.service.fenxiao.ProductDistributionService;
import com.abbot.schimneylife.util.CommonKey;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/distribution/order")
@Controller
public class OrderDistributionController extends BaseController {

	@Resource
	private OrdersDistributionService orderService;

	@RequestMapping("/selectOrder")
	public ModelAndView selectOrder() {
		List<OrdersDistribution> orderList = orderService.selectOrder();
		ModelAndView model = new ModelAndView("manager/distribution_orderList");
		model.addObject("orderList", orderList);
		model.addObject("count", orderList.size());
		return model;
	}
	
	@RequestMapping("/index")
	public ModelAndView index(String typeId) {
		ModelAndView model=new ModelAndView("manager/distribution_orderList");
		Integer totalCount=orderService.totalCount();
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
		String column = "orders.id";
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
		List<OrdersDistribution> orderList = orderService.findByPageAndType( column, "asc".equals(order)?"asc":"desc",  start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(orderList));
		json.put("draw", draw);
		Integer totalResult = orderService.totalCount();
		json.put("recordsTotal", totalResult);
		json.put("recordsFiltered", totalResult);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/deleteById")
	public void deleteById(Integer orderId) {
		boolean bool = orderService.deleteById(orderId);
		JSONObject object = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(object.toJSONString());
	}
	
	@RequestMapping("/selectOrderBy")
	public ModelAndView selectOrderBy(String name) {
		List<OrdersDistribution> orderList=orderService.selectOrderBy(name);
		ModelAndView model = new ModelAndView("manager/distribution_orderList");
		model.addObject("orderList", orderList);
		model.addObject("count", orderList.size());
		return model;
	}

}