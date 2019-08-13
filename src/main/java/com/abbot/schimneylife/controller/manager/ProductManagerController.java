package com.abbot.schimneylife.controller.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.MallProduct;
import com.abbot.schimneylife.pojo.shopping.MallProductAlibaba;
import com.abbot.schimneylife.pojo.shopping.MallProductBanner;
import com.abbot.schimneylife.pojo.shopping.MallProductInfo;
import com.abbot.schimneylife.pojo.shopping.MallProductParameter;
import com.abbot.schimneylife.pojo.shopping.MallProductType;
import com.abbot.schimneylife.pojo.shopping.Radio;
import com.abbot.schimneylife.service.shopping.AlibabaService;
import com.abbot.schimneylife.service.shopping.MallProductAlibabaService;
import com.abbot.schimneylife.service.shopping.MallProductBannerService;
import com.abbot.schimneylife.service.shopping.MallProductInfoService;
import com.abbot.schimneylife.service.shopping.MallProductParameterService;
import com.abbot.schimneylife.service.shopping.MallProductService;
import com.abbot.schimneylife.service.shopping.MallProductTypeService;
import com.abbot.schimneylife.service.shopping.RadioService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.ImageUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 产品管理控制类
 * @author Administrator
 *
 */
@RequestMapping("/manager/product")
@Controller
public class ProductManagerController extends BaseController{
	private static final Logger logger = Logger.getLogger(ProductManagerController.class);
	@Resource
	private MallProductTypeService typeService;
	@Resource
	private MallProductService proService;
	@Resource
	private MallProductParameterService paramService;
	@Resource
	private MallProductBannerService bannerService;
	@Resource
	private MallProductInfoService infoService;
	@Resource
	private AlibabaService aliService;
	@Resource
	private MallProductAlibabaService aliProService;
	@Resource
	private MallProductInfoService proInfoService;
	@Resource
	private RadioService radioService;
	
	@RequestMapping("/index")
	public ModelAndView index(String typeId) {
		ModelAndView model = new ModelAndView("manager/pro_home");
		model.addObject("array",this.getTypeList());
		Integer totalCount = proService.totalCount(null,null);
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
		String column = "product_number";
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
		List<MallProduct> proList = proService.findByPageAndType(search, column, "asc".equals(order)?"asc":"desc", typeId==null||typeId.trim().isEmpty()?null:typeId, start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(proList));
		json.put("draw", draw);
		Integer totalResult = proService.countByType(null, typeId==null||typeId.trim().isEmpty()?null:typeId);
//		Integer totalResult = proService.countTotalVO(typeId==null||typeId.trim().isEmpty()?null:typeId, null);
		json.put("recordsTotal", totalResult);
//		Integer totalFilterResult = proService.countTotalVO(typeId==null||typeId.trim().isEmpty()?null:typeId,search);
		Integer totalFilterResult = proService.countByType(search, typeId==null||typeId.trim().isEmpty()?null:typeId);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/toAdd")
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("manager/pro_add");
		model.addObject("array",this.getTypeList());
		return model;
	}
	@RequestMapping("/upload")
	public void upload(@RequestParam("files")MultipartFile files[],@RequestParam("banners")MultipartFile banners[],@RequestParam("imgSmall")MultipartFile imgSmall
			,String productName,String productDetails,String productNumber,String productKeys,String productSpec,int typeId,String province,String productArea
			,Integer degree,Integer recom,Integer productSource,Integer productIntegral) {
		String smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());
		MallProduct product = new MallProduct(typeId,productName,productDetails,smallPath,"","",province,productNumber,productKeys,0,productIntegral);
		product.setProductArea(productArea);
		product.setProvince(province);
		if(productSource==null) {
			product.setSource(CommonKey.ProductSource.SELFSUPPORT.getSource());//自营
		}
		product.setSource(productSource);
		degree = degree==null?0:degree;
		recom = recom==null?0:recom;
		product.setDegree(degree);
		product.setRecommendation(recom);
		List<MallProductParameter> paramList = new ArrayList<>();
		JSONArray specs = JSONArray.parseArray(productSpec);
		for(int i=0;i<specs.size();i++) {
			JSONObject group = specs.getJSONObject(i);
			MallProductParameter param = new MallProductParameter();
			param.setCur_price(group.getBigDecimal("current"));
			param.setOriginal(group.getBigDecimal("original"));
			param.setRepertory(group.getInteger("repertory"));
			String specId = group.getString("specId");
			if(specId!=null) {
				param.setSpecId(specId);
			}
			JSONArray firstJson = group.getJSONArray("first");
			JSONArray first = new JSONArray();
			for(int f=0;f<firstJson.size();f++) {
				JSONObject o = new JSONObject();
				o.put(firstJson.getJSONObject(f).getString("key"), firstJson.getJSONObject(f).getString("value"));
				first.add(o);
			}
			param.setFirstParam(first.toJSONString());
			JSONArray secondJson = group.getJSONArray("second");
			JSONArray second = new JSONArray();
			for(int s=0;s<secondJson.size();s++) {
				JSONObject o = new JSONObject();
				o.put(secondJson.getJSONObject(s).getString("key"), secondJson.getJSONObject(s).getString("value"));
				second.add(o);
			}
			param.setSecondParam(second.toJSONString());
			String json = group.getString("json");
			param.setJson(json);
			String qualityType = group.getString("qualityType");
			switch(qualityType) {
				case "year":
					param.setQualityYear(group.getInteger("quality"));
					break;
				case "month":
					param.setQualityMonth(group.getInteger("quality"));
					break;
				case "day":
					param.setQualityDay(group.getInteger("quality"));
					break;
			}
			
			paramList.add(param);
		}
		List<MallProductBanner> bannerList = new ArrayList<>();
		for(MultipartFile file:banners) {
			String path = ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString());
			MallProductBanner banner = new MallProductBanner();
			banner.setImgName(path);
			bannerList.add(banner);
		}
		MallProductInfo info = new MallProductInfo();
		StringBuffer sb = new StringBuffer();
		String b = "";
		for(MultipartFile file:files) {
			sb.append(b);
			b=";";
			sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		info.setImgName(sb.toString());
		try {
			proService.addProduct(product,paramList, bannerList, info);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("新增商品异常！",e);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
		
	}
	
	private String getTypeList() {
		List<MallProductType> typeList = typeService.firstType();
		JSONArray array = new JSONArray();
		JSONObject json = new JSONObject();
		json.put("id", "0");
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
		return array.toJSONString();
	}
	@RequestMapping("/fetchProStatus")
	public void fetchProStatus(String paramId) {
		Integer status = proService.fetchProStatusByParamId(paramId);
		this.writeJSON(this.createJSONResult(status==null?CommonKey.ERROR_CODE:CommonKey.SUCCESS_CODE, status).toJSONString());
	}
	@RequestMapping("/disable")
	public void disable(String paramId) {
		try {
			proService.disableByProId(paramId);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("禁用商品",e);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}
	@RequestMapping("/paramdisable")
	public void paramdisable(String paramId) {
		try {
			proService.disableByParamId(paramId);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("禁用商品",e);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}
	@RequestMapping("/enable")
	public void enable(String paramId) {
		try {
			proService.enableByProId(paramId);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("启用商品",e);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}
	@RequestMapping("/paramenable")
	public void paramenable(String paramId) {
		try {
			proService.enableByParamId(paramId);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("启用商品",e);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}
	@RequestMapping("/delete")
	public void delete(String paramId) {
		try {
			proService.deleteById(paramId);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("删除商品",e);
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}
//	@RequestMapping("/delete")
//	public void delete(String paramId) {
//		try {
//			proService.deleteByParamId(paramId);
//			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
//		} catch (Exception e) {
//			logger.error("删除商品",e);
//			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
//		}
//	}
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(String paramId) {
		ModelAndView model = new ModelAndView("manager/pro_edit");
		MallProduct product = proService.findById(paramId);
		model.addObject("product",product);
		List<MallProductParameter> paramList = paramService.findByProductId(product.getId());
		if(CommonKey.ProductSource.SELFSUPPORT.getSource()!=product.getSource()) {//如果不是自营产品则把specid封装进去
			if(paramList.size()>0) {
				MallProductAlibaba aliPro = aliProService.fetchByParamId(paramList.get(0).getId());
				model.addObject("productID",aliPro.getProductID());
				paramList.get(0).setSpecId(aliPro.getSpecID());
				for(int i=1;i<paramList.size();i++) {
					aliPro = aliProService.fetchByParamId(paramList.get(i).getId());
					paramList.get(i).setSpecId(aliPro.getSpecID());
				}
			}
		}
		model.addObject("paramList",paramList);
		List<MallProductBanner> bannerList = bannerService.findByProId(product.getId());
		model.addObject("banners",bannerList);
		MallProductInfo info = infoService.fetchByProId(product.getId());
		String[] images = info.getImgName().split(";");
		model.addObject("images",images);
		model.addObject("infoId",info.getId());
		MallProductType type = typeService.fetchById(product.getProductTypeId());
		model.addObject("type",type);
		List<MallProductType> typeList = typeService.firstType();
		model.addObject("typeList",typeList);
		return model;
	}
	@RequestMapping("/edit")
	public void saveEdit(@RequestParam("files")MultipartFile files[],@RequestParam("banners")MultipartFile banners[],@RequestParam(value="imgSmall",required=false)MultipartFile imgSmall
			,String productName,String productDetails,String productNumber,String productKeys,String productSpec,Integer typeId,String province,String productArea
			,Integer degree,Integer recom,String oldBanner,String oldInfo,String infoId,String proId,String delParam,Integer productSource,String productID,Integer productIntegral) {
		String smallPath = null;
		if(imgSmall!=null&&!imgSmall.isEmpty()) {
			smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());
		}
		
		MallProduct product = new MallProduct(typeId,productName,productDetails,smallPath,"","",province,productNumber,productKeys,0,productIntegral);
		product.setId(proId);
		product.setProvince(province);
		product.setProductArea(productArea);
		if(productSource!=null) {
			product.setSource(productSource);	
		}
		product.setDegree(degree);
		product.setRecommendation(recom);
		List<MallProductParameter> paramList = new ArrayList<>();
		JSONArray specs = JSONArray.parseArray(productSpec);
		for(int i=0;i<specs.size();i++) {
			JSONObject group = specs.getJSONObject(i);
			MallProductParameter param = new MallProductParameter();
			param.setId(group.getString("id"));
			param.setProductId(proId);
			param.setCur_price(group.getBigDecimal("current"));
			param.setOriginal(group.getBigDecimal("original"));
			param.setRepertory(group.getInteger("repertory"));
			String specId = group.getString("specId");
			if(specId!=null) {
				param.setSpecId(specId);
			}
			JSONArray firstJson = group.getJSONArray("first");
			JSONArray first = new JSONArray();
			for(int f=0;f<firstJson.size();f++) {
				JSONObject o = new JSONObject();
				o.put(firstJson.getJSONObject(f).getString("key"), firstJson.getJSONObject(f).getString("value"));
				first.add(o);
			}
			param.setFirstParam(first.toJSONString());
			JSONArray secondJson = group.getJSONArray("second");
			JSONArray second = new JSONArray();
			for(int s=0;s<secondJson.size();s++) {
				JSONObject o = new JSONObject();
				o.put(secondJson.getJSONObject(s).getString("key"), secondJson.getJSONObject(s).getString("value"));
				second.add(o);
			}
			param.setSecondParam(second.toJSONString());
			String json = group.getString("json");
			param.setJson(json);
			String qualityType = group.getString("qualityType");
			param.setQualityDay(0);
			param.setQualityMonth(0);
			param.setQualityYear(0);
			switch(qualityType) {
				case "year":
					param.setQualityYear(group.getInteger("quality"));
					break;
				case "month":
					param.setQualityMonth(group.getInteger("quality"));
					break;
				case "day":
					param.setQualityDay(group.getInteger("quality"));
					break;
			}
			
			paramList.add(param);
		}
		List<MallProductBanner> bannerList = new ArrayList<>();
		for(int i=0;i<banners.length;i++) {
			String path = ImageUtil.writeFile(banners[i], ConfigureUtil.PRODUCT_IMAGE.toString());
			MallProductBanner banner = new MallProductBanner();
			banner.setImgName(path);
			bannerList.add(banner);
		}
		MallProductInfo info = new MallProductInfo();
		info.setId(infoId);
		StringBuffer sb = new StringBuffer(oldInfo);
		String b = "";
		for(int i=0;i<files.length;i++) {
			sb.append(b);
			b=";";
			sb.append(ImageUtil.writeFile(files[i], ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		info.setImgName(sb.toString());
		try {
			proService.updateProduct(product, paramList, bannerList,oldBanner, info,delParam==null?null:delParam.split(","),productID);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("修改商品异常！",e);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
		
	}
	/**
	 * 根据商品id获取阿里商品数据
	 * @param productID
	 */
	@RequestMapping("/getAliData")
	public void getAliData(String productID) {
		JSONObject result = new JSONObject();
		boolean res = false;
		try {
			result = aliService.getProduct(productID);
			res = true;
		} catch (Exception e) {
			logger.error("根据id获取阿里商品数据异常",e);
		}
		int status = res?CommonKey.SUCCESS_CODE:CommonKey.ERROR_CODE;
		this.writeJSON(this.createJSONResult(status, result).toJSONString());
	}
//	@RequestMapping("/test")
//	public void test() {
//		boolean res = false;
//		try {
//			proService.test();
//			res = true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
//	}
	@RequestMapping("/preview")
	public ModelAndView preview(String proId) {
		ModelAndView model = new ModelAndView("manager/pro_details");
		List<Radio> radios = radioService.findAllShow();
		model.addObject("radios",radios);
		MallProduct product = proService.findById(proId);
		model.addObject("product",product);
		List<MallProductBanner> banners = bannerService.findByProId(proId);
		model.addObject("banners",banners);
		//获取parameter（现价最低）
		MallProductParameter proParam = paramService.fetchLowerByProId(proId);
		model.addObject("proParam",proParam);
		//获取详页图片
		MallProductInfo proInfo = proInfoService.fetchByProId(proId);
		if(proInfo!=null&&proInfo.getImgName()!=null) {
			model.addObject("paths",proInfo.getImgName().split(";"));
		}
		//获取所有的参数
		List<MallProductParameter> params = paramService.findByProductId(proId);
		List<Map<String,Object>> spec = new ArrayList<>();
		for(MallProductParameter param:params) {
			JSONArray first = JSONArray.parseArray(param.getFirstParam());
			Map<String,Object> o = new HashMap<>();
			List<Map<String,Object>> datas = spec;
			
			for(int i=0;i<first.size();i++) {
				boolean isA = true;
				JSONObject ss = first.getJSONObject(i);
				String key = ss.keySet().iterator().next();
				for(Map<String,Object> map:datas) {
					if(map.containsKey("value")&&map.get("value").toString().equals(ss.getString(key))) {
						datas = (List<Map<String, Object>>) map.get("datas");
						isA = false;
						break;
					}
				}
				if(isA) {
					o = new HashMap<>();
					o.put("key", key);
					o.put("value", ss.getString(key));
					o.put("datas", new ArrayList<>());
					datas.add(o);
					datas = (List<Map<String, Object>>) o.get("datas");
				}
			}
			o.put("end", true);
			o.put("id", param.getId());
			o.put("price", param.getStrCurprice());
			o.put("repertory", param.getRepertory());
		}
		model.addObject("params",JSONArray.toJSON(spec));
		Integer fav = 0;
		model.addObject("fav",fav);
		//商品评价
		model.addObject("evaluateList",new ArrayList());
		model.addObject("totalResult",0);
		return model;
	}
	/**
	 * 获取保存的阿里数据
	 * @param productId
	 */
	@RequestMapping("/getAli")
	public void getAli(String productId) {
		List<MallProductParameter> params = paramService.findByProductId(productId);
		if(params!=null&&params.size()>0) {
			MallProductAlibaba ali = aliProService.fetchByParamId(params.get(0).getId());
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, JSONObject.toJSON(ali)).toJSONString());
		}else {
			this.writeJSON(this.createJSONResult(CommonKey.ERROR_CODE, false).toJSONString());
		}
	}
}
