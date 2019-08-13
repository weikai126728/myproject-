package com.abbot.schimneylife.controller.manager;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.Radio;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.service.shopping.RadioService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.HttpRequestUtil;
import com.abbot.schimneylife.util.SessionManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/manager/radio")
@Controller
public class RadioManagerController extends BaseController{
	private static final Logger logger = Logger.getLogger(RadioManagerController.class);

	@Resource
	private RadioService radioService;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("manager/radio_list");
		return model;
	}
	@RequestMapping("/findByPage")
	public void findByPage(Integer draw, Integer start,Integer length) {
		String search = request.getParameter("search[value]");
		String order = request.getParameter("order[0][dir]");
		List<Radio> radioList = radioService.findByPage(search, order, start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(radioList));
		Integer totalResult = radioService.countTotal(null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = radioService.countTotal(search);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/disable")
	public void disable(String id) {
		Radio radio = radioService.findById(id);
		JSONObject content = new JSONObject();
		content.put("id", radio.getId());
		content.put("details", radio.getDetails());
		JSONObject message = new JSONObject();
		message.put("type", CommonKey.EVENT_TYPE_RADIO);
		message.put("content", content);
		message.put("handle", "DEL");
		try {
			HttpRequestUtil.sendMessage(message.toJSONString());
		} catch (Exception e) {
			logger.error(e);
		}
		boolean res = radioService.disable(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/enable")
	public void enable(String id) {
		Radio radio = radioService.findById(id);
		JSONObject content = new JSONObject();
		content.put("id", radio.getId());
		content.put("details", radio.getDetails());
		JSONObject message = new JSONObject();
		message.put("type", CommonKey.EVENT_TYPE_RADIO);
		message.put("content", content);
		message.put("handle", "ADD");
		try {
			HttpRequestUtil.sendMessage(message.toJSONString());
		} catch (Exception e) {
			logger.error(e);
		}
		boolean res = radioService.enable(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/delete")
	public void delete(String id) {
		Radio radio = radioService.findById(id);
		JSONObject content = new JSONObject();
		content.put("id", radio.getId());
		content.put("details", radio.getDetails());
		JSONObject message = new JSONObject();
		message.put("type", CommonKey.EVENT_TYPE_RADIO);
		message.put("content", content);
		message.put("handle", "DEL");
		try {
			HttpRequestUtil.sendMessage(message.toJSONString());
		} catch (Exception e) {
			logger.error(e);
		}
		boolean res = radioService.delete(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/add")
	public void add(Radio radio) {
		User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		radio.setAuthor(user.getRealName());
		radio.setFlag(CommonKey.DISABLE_FLAG);
		boolean res = radioService.insert(radio);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/toUpdate")
	public ModelAndView toUpdate(String id) {
		ModelAndView model = new ModelAndView("manager/radio_edit");
		Radio radio = radioService.findById(id);
		model.addObject("radio",radio);
		return model;
	}
	@RequestMapping("/update")
	public void update(Radio radio) {
		boolean res = radioService.update(radio);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	@RequestMapping("/batchDelete")
	public void batchDelete(String ids) {
		if(ids==null) {
			ids = "";
		}
		try {
			radioService.batchDelete(ids.split(","));
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("批量删除",e);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}
}
