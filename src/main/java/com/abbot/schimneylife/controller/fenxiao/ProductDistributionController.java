package com.abbot.schimneylife.controller.fenxiao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.fenxiao.ProductCateDistribution;
import com.abbot.schimneylife.pojo.fenxiao.ProductDistribution;
import com.abbot.schimneylife.pojo.shopping.MallProduct;
import com.abbot.schimneylife.pojo.shopping.MallProductType;
import com.abbot.schimneylife.service.fenxiao.ProductCateDistributionService;
import com.abbot.schimneylife.service.fenxiao.ProductDistributionService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.ImageUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/distribution/product")
@Controller
public class ProductDistributionController extends BaseController {

	@Resource
	private ProductDistributionService proService;
	@Resource
	private ProductCateDistributionService proCateService;

	@RequestMapping("/hasmore")
	public void hasmore(Integer proId) {
		boolean bool;
		List<ProductDistribution> list = proService.hasmore(proId);
		if ( list.size() > 0) {
			bool = true;
		} else {
			bool = false;
		}
		JSONObject object = this.createJSONResult(0, bool);
		this.writeJSON(object.toJSONString());
	}
	
	@RequestMapping("/index")
	public ModelAndView index(String typeId) {
		ModelAndView model=new ModelAndView("manager/distribution_proHome");
		model.addObject("array", this.getTypeList());
		Integer totalCount=proService.totalCount();
		model.addObject("totalCount",totalCount);//商品总数量
		if(typeId!=null&&!typeId.isEmpty()) {
			model.addObject("typeIde",typeId);
		}
		return model;
	}
	
	@RequestMapping("/findByType")
	public void findByType(Integer draw,String typeId,Integer start,Integer length) {
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "pro.id";
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
		List<ProductDistribution> proList = proService.findByPageAndType(search, column, "asc".equals(order)?"asc":"desc", typeId==null||typeId.trim().isEmpty()?null:typeId, start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(proList));
		json.put("draw", draw);
		Integer totalResult = proService.countByType(null, typeId==null||typeId.trim().isEmpty()?null:typeId);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = proService.countByType(search, typeId==null||typeId.trim().isEmpty()?null:typeId);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	
	@RequestMapping("/toAdd")
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("manager/distribution_proAdd");
		List<ProductCateDistribution> proCateList = proCateService.selectProCate();
		model.addObject("proCateList", proCateList);
		model.addObject("array",this.getTypeList());
		return model;
	}
	
	@RequestMapping("/upload")
	public ModelAndView upload(@RequestParam("file") MultipartFile file,
			String content, String productName,Integer productCate,
			Double bills,Double money,int inventory,Double rateA,Double rateB,Double rateC) {
		ModelAndView model = new ModelAndView("manager/tips");
		ProductDistribution pro=new ProductDistribution();
		if (file != null && file.getSize() != 0) {
			String fileName = ImageUtil.writeDistributionFile(file,ConfigureUtil.PRODUCT_IMAGE.toString());
			pro.setPicture(fileName);
		}
		pro.setContent(content);
		pro.setBills(bills);
		pro.setDeleted(0);
		pro.setInventory(inventory);
		pro.setMoney(money);
		pro.setRateA(rateA);
		pro.setRateB(rateB);
		pro.setRateC(rateC);
		pro.setProductCateId(productCate);
		pro.setTitle(productName);
		pro.setVersion(0);
		boolean bool=proService.upload(pro);
		model.addObject("msg","操作成功！");
		model.addObject("result", bool);
		model.addObject("path", "distribution/product/index.do");
		return model;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam("file") MultipartFile file, String productName,
			Integer productCate,Double bills,Double money,int inventory,String files,
			int id,String content,Double rateA,Double rateB,Double rateC) {
		ModelAndView model = new ModelAndView("manager/tips");
		ProductDistribution pro=new ProductDistribution();
		if (file != null && file.getSize() != 0) {
			String fileName = ImageUtil.writeDistributionFile(file, ConfigureUtil.PRODUCT_IMAGE.toString());
			pro.setPicture(fileName);
		}else {
			pro.setPicture(files);
		}
		pro.setContent(content);
		pro.setId(id);
		pro.setBills(bills);
		pro.setInventory(inventory);
		pro.setMoney(money);
		pro.setRateA(rateA);
		pro.setRateB(rateB);
		pro.setRateC(rateC);
		pro.setProductCateId(productCate);
		pro.setTitle(productName);
		boolean bool=proService.update(pro);
		model.addObject("msg","操作成功！");
		model.addObject("result", bool);
		model.addObject("path", "distribution/product/index.do");
		return model;
	}
	
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(Integer proId) {
		ModelAndView model=new ModelAndView("manager/distribution_proEdit");
		List<ProductCateDistribution> proCateList = proCateService.selectProCate();
		ProductDistribution pro=proService.toEdit(proId);
		model.addObject("proCateList", proCateList);
		model.addObject("pro", pro);
		return model;
	}
	
	@RequestMapping("/delete")
	public void delete(Integer proId) {
		boolean bool =	proService.delete(proId);
		JSONObject object = this.createJSONResult(0, bool);
		this.writeJSON(object.toJSONString());
	}
	
	private String getTypeList() {
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
		return array.toJSONString();
	}
}