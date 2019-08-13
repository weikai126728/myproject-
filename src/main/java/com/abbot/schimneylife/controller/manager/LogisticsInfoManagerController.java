package com.abbot.schimneylife.controller.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.LogisticsInfo;
import com.abbot.schimneylife.service.shopping.LogisticsInfoService;
import com.abbot.schimneylife.util.CommonKey;

@RequestMapping("/manager/logistics")
@Controller
public class LogisticsInfoManagerController extends BaseController{

	@Resource
	private LogisticsInfoService logisticsService;
	
	@RequestMapping("/add")
	public void add(String company,String waybill,String logisticsNo,String orderId) {
		LogisticsInfo logistics = logisticsService.fetchByOrderId(orderId);
		boolean res = false;
		if(logistics!=null&&logistics.getId()!=null) {
			res = logisticsService.update(logistics.getId(), company, waybill, logisticsNo);
		}else {
			res = logisticsService.insert(company, waybill, logisticsNo, orderId);			
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	
	@RequestMapping("/update")
	public ModelAndView save(String id,String company,String waybill,String logisticsNo) {
		boolean res = logisticsService.update(id, company, waybill, logisticsNo);
		ModelAndView model = new ModelAndView("manager/tips");
		model.addObject("msg",res?"保存成功！":"保存失败");
		return model;
	}
	
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(String orderId) {
		ModelAndView model = new ModelAndView("manager/logistics_edit");
		LogisticsInfo logistics = logisticsService.fetchByOrderId(orderId);
		model.addObject("logistics",logistics);
		return model;
	}
}
