package com.abbot.schimneylife.controller.fenxiao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.fenxiao.ProductCateDistribution;
import com.abbot.schimneylife.pojo.shopping.MallProductType;
import com.abbot.schimneylife.service.fenxiao.ProductCateDistributionService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/distribution/productCate")
@Controller
public class ProductCateDistributionController extends BaseController {

	@Resource
	private ProductCateDistributionService proCateService;

	/*
	 * @RequestMapping("/proCateList") public ModelAndView selectProCate() {
	 * ModelAndView model = new ModelAndView("manager/distribution_proCate");
	 * model.addObject("proCateList", ""); return model; }
	 */

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("manager/distribution_proCate");
		List<ProductCateDistribution> proCateList = proCateService.selectProCate();
		JSONArray array = new JSONArray();
		JSONObject json = new JSONObject();
		json.put("id", "0");
		json.put("pId", "0");
		json.put("name", "分销分类列表");
		json.put("open:true", true);
		array.add(json);
		for (ProductCateDistribution type : proCateList) {
			json = new JSONObject();
			json.put("id", type.getId());
			json.put("pId", "0");
			json.put("name", type.getName());
			array.add(json);
		}
		model.addObject("array", array.toJSONString());
		return model;
	}

	@RequestMapping("/to/handle")
	public ModelAndView tohandle(Integer id) {
		ModelAndView model = new ModelAndView("manager/distribution_proTypeHandle");
		if (id == null || "".equals(id) || "0".equals(id)) {

		} else {
			model.addObject("type", proCateService.fetchById(id));
		}
		return model;
	}

	@RequestMapping("/addPro")
	public ModelAndView addPro(String name,Integer id) {
		boolean bool = false;
		ModelAndView model = new ModelAndView("manager/tips");
		ProductCateDistribution pro = new ProductCateDistribution();
		pro.setName(name);
		pro.setDeleted(0);
		pro.setVersion(2);
		pro.setFatherId(0);
		if(id==null) {
			bool = proCateService.addPro(pro);
		}else {
			bool = proCateService.updatePro(name,id);
		}
		model.addObject("msg","操作成功！");
		model.addObject("result", bool);
		return model;
	}
	 
	
	@RequestMapping("/delete")
	public void delete(Integer id) {
		boolean bool = proCateService.delete(id);
		JSONObject object = this.createJSONResult(0, bool);
		this.writeJSON(object.toJSONString());
	}

}