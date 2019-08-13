package com.abbot.schimneylife.controller.manager;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.MallProduct;
import com.abbot.schimneylife.pojo.shopping.Tidings;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.service.shopping.MallProductService;
import com.abbot.schimneylife.service.shopping.TidingsService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.HttpRequestUtil;
import com.abbot.schimneylife.util.ImageUtil;
import com.abbot.schimneylife.util.SessionManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/manager/tidings")
@Controller
public class TidingsManagerController extends BaseController{
	private static final Logger logger = Logger.getLogger(TidingsManagerController.class);
	
	@Resource
	private TidingsService tidingsService;
	@Resource
	private MallProductService proService;
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("manager/tidings_list");
		return model;
	}
	@RequestMapping("/findByPage")
	public void findByPage(Integer draw,Integer start,Integer length) {
		String search = request.getParameter("search[value]");
		String order = request.getParameter("order[0][dir]");
		List<Tidings> list = tidingsService.findByPage(start, length, search, order);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(list));
		Integer totalResult = tidingsService.coutTotal(null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = tidingsService.coutTotal(search);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/disable")
	public void disable(String id) {
		Tidings tidings = tidingsService.findById(id);
		if(tidings.getId()!=null&&tidings.getFlag()==CommonKey.ENABLE_FLAG) {
			JSONObject message = new JSONObject();
			message.put("type", CommonKey.EVENT_TYPE_TIDINGS);
			message.put("handle", "DEL");
			JSONObject ti = new JSONObject();
			ti.put("id", tidings.getId());
			JSONArray array = new JSONArray();
			array.add(ti);
			message.put("content", array);
			try {
				HttpRequestUtil.sendMessage(message.toJSONString());
			} catch (Exception e) {
				logger.error("发送消息异常",e);
			}
//				MyWebSocketHandler.sendMessage(message.toJSONString());
		}
		boolean res = tidingsService.disable(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/enable")
	public void enable(String id) {
		Tidings tidings = tidingsService.findById(id);
		if(tidings!=null&&tidings.getId()!=null) {
			JSONObject message = new JSONObject();
			message.put("type", CommonKey.EVENT_TYPE_TIDINGS);
			message.put("handle", "ADD");
			JSONObject ti = new JSONObject();
			ti.put("id", tidings.getId());
			ti.put("name", tidings.getName());
			ti.put("details", tidings.getDetails());
			ti.put("image", tidings.getImage());
			ti.put("time", tidings.getUpdateTime());
			ti.put("productId", tidings.getProductId());
			message.put("content", ti);
			try {
				HttpRequestUtil.sendMessage(message.toJSONString());
			} catch (Exception e) {
				logger.error(e);
			}
		}
		boolean res = tidingsService.enable(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/delete")
	public void delete(String id) {
		Tidings tidings = tidingsService.findById(id);
		if(tidings.getId()!=null&&tidings.getFlag()==CommonKey.ENABLE_FLAG) {
			JSONObject message = new JSONObject();
			message.put("type", CommonKey.EVENT_TYPE_TIDINGS);
			message.put("handle", "DEL");
			JSONObject ti = new JSONObject();
			ti.put("id", tidings.getId());
			JSONArray array = new JSONArray();
			array.add(ti);
			message.put("content", array);
			try {
				HttpRequestUtil.sendMessage(message.toJSONString());
			} catch (Exception e) {
				logger.error(e);
			}
		}
		boolean res = tidingsService.delete(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(String paramId) {
//		MallProduct product = proService.fetchByParamId(paramId);
		MallProduct product = proService.findById(paramId);
		ModelAndView model = new ModelAndView("manager/tidings_add");
		model.addObject("proId",product.getId());
		return model;
	}
	@RequestMapping("/add")
	public ModelAndView add(Tidings tidings,@RequestParam("file")MultipartFile file) {
		String image = "";
		if(file!=null&&!file.isEmpty()) {
			image = ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString());
		}
		tidings.setImage(image);
		tidings.setFlag(CommonKey.DISABLE_FLAG);
		User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		tidings.setAuthor(user.getRealName());
		boolean res = tidingsService.add(tidings);
		ModelAndView model = new ModelAndView("manager/tips");
		String msg = res?"添加成功！":"添加失败！";
		model.addObject("msg",msg);
		return model;
	}
	@RequestMapping("/to/update")
	public ModelAndView toUpdate(String id) {
		ModelAndView model = new ModelAndView("manager/tidings_edit");
		Tidings tidings = tidingsService.findById(id);
		model.addObject("tidings",tidings);
		return model;
	}
	@RequestMapping("/update")
	public ModelAndView update(Tidings tidings,@RequestParam(value="file",required=false)MultipartFile file) {
		String image = "";
		if(file!=null&&!file.isEmpty()) {
			image = ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString());
		}
		tidings.setImage(image);
		tidings.setFlag(CommonKey.DISABLE_FLAG);
		boolean res = tidingsService.update(tidings);
		ModelAndView model = new ModelAndView("manager/tips");
		String msg = res?"修改成功！":"修改失败！";
		model.addObject("msg",msg);
		return model;
	}
	@RequestMapping("/batchDelete")
	public void batchDelete(String ids) {
		if(ids==null) {
			ids = "";
		}
		String[] idss = ids.split(",");
		JSONObject message = new JSONObject();
		message.put("type", CommonKey.EVENT_TYPE_TIDINGS);
		JSONArray array = new JSONArray();
		for(String id:idss) {
			Tidings tidings = tidingsService.findById(id);
			if(tidings.getFlag()==CommonKey.ENABLE_FLAG) {
				JSONObject json = new JSONObject();
				json.put("id", tidings.getId());
				array.add(json);
			}
		}
		message.put("result", array);
		message.put("handle", "DEL");
		try {
			if(array.size()>0) {
				HttpRequestUtil.sendMessage(message.toJSONString());				
			}
		} catch (Exception e1) {
			logger.error(e1);
		}
		try {
			tidingsService.batchDelete(idss);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("批量删除",e);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}
}
