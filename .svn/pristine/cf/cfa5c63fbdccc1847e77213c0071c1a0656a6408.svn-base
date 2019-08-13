package com.abbot.schimneylife.controller.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.CustomerEvaluate;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.service.shopping.CustomerEvaluateService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.SessionManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@RequestMapping("/manager/evaluate")
@Controller
public class CustomerEvaluateManagerController extends BaseController{

	@Resource
	private CustomerEvaluateService evaluateService;
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("manager/evaluate_home");
		return model;
	}
	@RequestMapping("/findByPage")
	public void findByPage(Integer draw,String createTime,Integer start,Integer length) {
			String search = request.getParameter("search[value]");
			if(search==null||search.isEmpty()) {
				search = null;
			}
			if("".equals(createTime)) {
				createTime = null;
			}
			String order = request.getParameter("order[0][dir]");
			List<CustomerEvaluate> list = evaluateService.findByPage(createTime, search, order, CommonKey.EvaluateType.MALL.getType(), null, start, length);
			JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(list));
			json.put("draw", draw);
			Integer totalResult = evaluateService.countTotal(null, null, CommonKey.EvaluateType.MALL.getType(),null);
			json.put("recordsTotal", totalResult);
			Integer totalFilterResult = evaluateService.countTotal(createTime, search, CommonKey.EvaluateType.MALL.getType(), null);
			json.put("recordsFiltered", totalFilterResult);
			this.writeJSON(json.toJSONString());
	}
	/**
	 * 回复
	 * @param reply
	 * @param id
	 */
	@RequestMapping("/reply")
	public void reply(String reply,String id) {
		User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		boolean res = evaluateService.reply(reply, user.getNickName(), id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	/**
	 * 审核通过
	 * @param id
	 */
	@RequestMapping("/pass")
	public void pass(String id) {
		boolean res = evaluateService.updateStatus(CommonKey.EvaluateStatus.ENABLE_AUDITINGED.getStatus(), id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/recovery")
	public void recovery(String id) {
		boolean res = evaluateService.updateStatus(CommonKey.EvaluateStatus.ENABLE_NO_AUDITING.getStatus(), id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	/**
	 * 放入垃圾箱
	 * @param id
	 */
	@RequestMapping("/delete")
	public void delete(String id) {
		boolean res = evaluateService.updateStatus(CommonKey.EvaluateStatus.DISABLE.getStatus(), id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	/**
	 * 查询垃圾箱
	 * @return
	 */
	@RequestMapping("/dustbin")
	public ModelAndView dustbin() {
		ModelAndView model = new ModelAndView("manager/evaluate_dustbin");
		
		return model;
	}
	@RequestMapping("/dustbinList")
	public void dustbinList(Integer draw,String createTime,Integer start,Integer length) {
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
		if("".equals(createTime)) {
			createTime = null;
		}
		String order = request.getParameter("order[0][dir]");
		List<CustomerEvaluate> list = evaluateService.findByPage(createTime, search, order, CommonKey.EvaluateType.MALL.getType(), CommonKey.EvaluateStatus.DISABLE.getStatus(), start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(list));
		json.put("draw", draw);
		Integer totalResult = evaluateService.countTotal(null, null, CommonKey.EvaluateType.MALL.getType(),CommonKey.EvaluateStatus.DISABLE.getStatus());
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = evaluateService.countTotal(createTime, search, CommonKey.EvaluateType.MALL.getType(), CommonKey.EvaluateStatus.DISABLE.getStatus());
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/del")
	public void del(String id) {
		boolean res = evaluateService.delete(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
}
