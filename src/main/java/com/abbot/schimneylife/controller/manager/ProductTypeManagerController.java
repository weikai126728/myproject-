package com.abbot.schimneylife.controller.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.MallProductType;
import com.abbot.schimneylife.service.shopping.MallProductTypeService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.ImageUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/manager/protype")
@Controller
public class ProductTypeManagerController extends BaseController{

	@Resource
	private MallProductTypeService typeService;
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("manager/pro_type");
		List<MallProductType> typeList = typeService.firstType();
		JSONArray array = new JSONArray();
		JSONObject json = new JSONObject();
		json.put("id", 0);
		json.put("pId", "0");
		json.put("name", "商城分类列表");
		json.put("open:true", true);
		array.add(json);
		for(MallProductType type:typeList) {
			json = new JSONObject();
			json.put("id", type.getId());
			json.put("pId", type.getPid());
			json.put("name", type.getTypeName());
			array.add(json);
		}
		model.addObject("array",array.toJSONString());
		return model;
	}
	@RequestMapping("/to/handle")
	public ModelAndView tohandle(Integer id) {
		ModelAndView model =new ModelAndView("manager/pro_typeHandle");
		if(id==null) {
			
		}else {
			model.addObject("type",typeService.fetchById(id));
		}
		return model;
	}
	@RequestMapping("/handle")
	public ModelAndView handle(MallProductType type,@RequestParam("img_Small")MultipartFile img_Small) {
		ModelAndView model = new ModelAndView("manager/tips");
		String smallPath=null;
		if(img_Small.getOriginalFilename()!=null&&!img_Small.getOriginalFilename().equals("")) {
			smallPath = ImageUtil.writeFile(img_Small, ConfigureUtil.PRODUCT_IMAGE.toString());
		}
		type.setImgSmall(smallPath);
		boolean res = false;
		if(type.getId()==null) {
			res = typeService.insert(type);
		}else {
			res = typeService.update(type);
		}
		model.addObject("msg","操作成功！");
		model.addObject("result",res);
		return model;
	}
	@RequestMapping("/hasmore")
	public void hasMore(String id) {
		Integer size = typeService.products(id);
		boolean res = false;
		if(size>0) {
			res = true;
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/disable")
	public void disable(Integer id) {
		MallProductType type = new MallProductType();
		type.setId(id);
		type.setStatus(0);
		boolean res = typeService.update(type);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/enable")
	public void enable(Integer id) {
		MallProductType type = new MallProductType();
		type.setId(id);
		type.setStatus(1);
		boolean res = typeService.update(type);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/delete")
	public void delete(Integer id) {
		boolean res = typeService.delete(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
}
