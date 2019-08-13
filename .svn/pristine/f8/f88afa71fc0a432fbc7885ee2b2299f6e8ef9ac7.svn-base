package com.abbot.schimneylife.controller.manager;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.service.shopping.CustomerOrderService;
import com.abbot.schimneylife.service.user.UserCustomerService;
import com.abbot.schimneylife.util.CommonKey;

@RequestMapping("/manager/system")
@Controller
public class SystemManagerController {

	@Resource
	private UserCustomerService customerService;
	@Resource
	private CustomerOrderService orderService;
	@RequestMapping("/index")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("manager/index");
		return model;
	}
	@RequestMapping("/home")
	public ModelAndView showAll() {
		ModelAndView model = new ModelAndView("manager/home");
		/*Integer total = customerService.countTotal();
		model.addObject("total",total);//用户数量
		Integer orders = orderService.countTotal();
		model.addObject("orders",orders);//订单数量
		BigDecimal trading = orderService.tradingVolume();
		model.addObject("trading",trading);//总交易额
		Integer[] order0 = orderService.countByStatus(null);//全部订单
		Integer[] order1 = orderService.countByStatus(CommonKey.Order.NO_PAY.getStatus());//代付款
		Integer[] order2 = orderService.countByStatus(CommonKey.Order.NO_SEND_NO_SETTLEMENT.getStatus());//待发货
		Integer[] order3 = orderService.countByStatus(CommonKey.Order.NO_GOT.getStatus());//待收货
		Integer[] order4 = orderService.countByStatus(CommonKey.Order.SUCCESS_NO_EVALUATE.getStatus());//待评价
		Integer[] order5 = new Integer[12];//已付款
		for(int i=0;i<12;i++) {
			order5[i] = order3[i]+order4[i]+order2[i];
		}
		
		model.addObject("allOrder",this.getArray(order0));
		model.addObject("noPay",this.getArray(order1));
		model.addObject("noPay1",this.getMaxAndMin(order1));
		model.addObject("pay",this.getArray(order5));
		model.addObject("pay1",this.getMaxAndMin(order5));
		model.addObject("noSend",this.getArray(order2));
		model.addObject("noSend1",this.getMaxAndMin(order2));*/
		return model;
	}
	private String getArray(Integer[] arg0) {
		StringBuffer sb0 = new StringBuffer();
		sb0.append("[");
		String str = "";
		for(Integer i:arg0) {
			sb0.append(str);
			str = ",";
			sb0.append(i);
		}
		sb0.append("]");
		return sb0.toString();
	}
	private String getMaxAndMin(Integer[] arg0) {
		StringBuffer sb0 = new StringBuffer();
		sb0.append("[");
		int max = 0;
		int index = 0;
		int min = 0;
		int minIndex = 0;
		for(int i=0;i<arg0.length;i++) {
			if(arg0[i]>max) {
				max = arg0[i];
				index = i;
			}
			if(arg0[i]<min) {
				min = arg0[i];
				minIndex = i;
			}
		}
		sb0.append(max);
		sb0.append(",");
		sb0.append(index);
		sb0.append(",");
		sb0.append(min);
		sb0.append(",");
		sb0.append(minIndex);
		sb0.append("]");
		return sb0.toString();
	}
}
