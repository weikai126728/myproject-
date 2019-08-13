package com.abbot.schimneylife.controller.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.Logistics;
import com.abbot.schimneylife.pojo.shopping.Refund;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.service.shopping.LogisticsService;
import com.abbot.schimneylife.service.shopping.RefundService;
import com.abbot.schimneylife.util.CommonKey;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/manager/service")
public class RefundManagerController extends BaseController {
	@Resource
	RefundService refundService;
	@Resource
	LogisticsService logService;

	/**
	 * 查询所有售后申请
	 */
	@RequestMapping("/serviceList")
	public ModelAndView selectAllRefund() {
		ModelAndView model = new ModelAndView("manager/service_list");
		List<Refund> list = refundService.selectAllRefund();
		model.addObject("serviceList", list);
		model.addObject("count",list.size());
		return model;
	}
	@RequestMapping("/index")
	public ModelAndView index(String typeId) {
		ModelAndView model=new ModelAndView("manager/service_list");
		Integer totalCount=refundService.selectCount();
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
		String column = "sale.id";
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
		List<Refund> refundList = refundService.findByPageAndType( column, "asc".equals(order)?"asc":"desc", start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(refundList));
		json.put("draw", draw);
		Integer totalCount=refundService.selectCount();
		json.put("recordsTotal", totalCount);
		json.put("recordsFiltered", totalCount);
		this.writeJSON(json.toJSONString());
	}
	/**
	 * 同意
	 * 
	 * @param id
	 */
	@RequestMapping("/agree")
	public void agreeRefund(String sId) {

		int serviceStatus = CommonKey.service_status_agree;
		boolean bool = refundService.agreeRefund(sId, serviceStatus);
		JSONObject object = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(object.toJSONString());
	}

	/**
	 * 拒绝
	 * 
	 * @param id
	 */
	@RequestMapping("/disagree")
	public void disagreeRefund(String sId, String refuseReason) {
		int serviceStatus = CommonKey.service_status_disagree;
		boolean bool=false;
		if (refundService.addReason(sId,refuseReason)) {
			bool = refundService.agreeRefund(sId, serviceStatus);
		}
		JSONObject object = this.createJSONResult(0, bool);
		this.writeJSON(object.toJSONString());
	}
	
	@RequestMapping("/agreegoods")
	public void agreegoods(String sId) {
		int isAgree=CommonKey.service_status_agree;
		boolean bool = refundService.agreegoods(sId,isAgree);
		JSONObject object = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(object.toJSONString());
	}
	/**
	 * 查看图片
	 * 
	 * @param id
	 */
	@RequestMapping("/checkImg")
	public ModelAndView checkImg(String id) {
		ModelAndView model = new ModelAndView("manager/service_img");
		String[] images = refundService.getImgName(id).split(";");
		model.addObject("images", images);
		return model;
	}

	@RequestMapping("queryLogById")
	public ModelAndView queryLogById(String id) {
		ModelAndView model = new ModelAndView("manager/service_show");
		Logistics log = logService.queryLogById(id);
		model.addObject("log", log);
		return model;
	}

}
