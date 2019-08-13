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
import com.abbot.schimneylife.pojo.shopping.MarketProductInfo;
import com.abbot.schimneylife.pojo.shopping.StoreClass;
import com.abbot.schimneylife.pojo.shopping.SupermarketInfo;
import com.abbot.schimneylife.service.shopping.BenefitService;
import com.abbot.schimneylife.service.shopping.SupermarketActivityService;
import com.abbot.schimneylife.service.shopping.SupermarketInfoService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.ImageUtil;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/manager/benefit")
@Controller
public class BenefitController extends BaseController {
	private static final Logger logger = Logger.getLogger(BenefitController.class);
	@Resource
	private SupermarketInfoService marketService;
	@Resource
	private SupermarketActivityService activityService;
	@Resource
	private BenefitService BenefitService;
	
	@RequestMapping("/findCoalition")
	public ModelAndView findCoalition() {
		ModelAndView model = new ModelAndView("manager/coalition_list");
		List<SupermarketInfo> marketList = BenefitService.findCoalition();
		int count = marketList.size();
		model.addObject("count", count);
		model.addObject("marketList", marketList);
		return model;
	}
	/**
	 * 停用
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/stop")
	public void disable(Integer marketId) {
		boolean bool = BenefitService.disable(marketId);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	
	/**
	 * 启用
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/start")
	public void enable(Integer marketId) {
		boolean bool = BenefitService.enable(marketId);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/findBenefit")
	public ModelAndView findBenefit() {
		ModelAndView model = new ModelAndView("manager/benefit_list");
		List<MarketProductInfo> ProList = BenefitService.findAllBenefit();
		int count = ProList.size();
		model.addObject("count", count);
		model.addObject("ProList", ProList);
		return model;
	}
	
	
	/**
	 * 停用
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/benefitstop")
	public void benefitstop(Integer proid) {
		boolean bool = BenefitService.benefitstop(proid);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	/**
	 * 启用
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/benefitstart")
	public void benefitstart(Integer proid) {
		boolean bool = BenefitService.benefitstart(proid);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/goAdd")
	public ModelAndView goAdd() {
		ModelAndView model = new ModelAndView("manager/coalition_add");
		return model;
	}
	@RequestMapping("/upload")
	public void upload(@RequestParam("imgSmall")MultipartFile imgSmall,@RequestParam("imgSmall1")MultipartFile imgSmall1,String productName
		,String productDetails,Integer marketid,String hopenid,String name,String addre,String phone
		,@RequestParam(value="mp3file",required=false)MultipartFile mp3file ) {
		logger.info("productName："+productName+"productDetails："+productDetails+"marketid："+marketid);
		String mp3 = null;
		if(mp3file!=null) {
			mp3 = ImageUtil.writeFile(mp3file, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		SupermarketInfo product = new SupermarketInfo();
		String smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());
		String smallPath1 = ImageUtil.writeFile(imgSmall1, ConfigureUtil.PRODUCT_IMAGE.toString());
		product.setOpenid(hopenid);
		product.setAddre(addre);
		product.setName(productName);	
		product.setContactUser(name);
		product.setImgSmall(smallPath);
		product.setPhone(phone);
		product.setMp3(mp3);
		product.setImgLarge(smallPath1);
		try {
			BenefitService.addProduct(product);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("新增商品异常！",e);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}
	@RequestMapping("/goEdit")
	public ModelAndView goEdit(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/coalition_edit");
		SupermarketInfo market = BenefitService.fetchById(marketId);
		model.addObject("market",market);
		return model;
	}
	@RequestMapping("/edit")
	public void edit(@RequestParam(value="imgSmall",required=false)MultipartFile imgSmall,@RequestParam(value="imgSmall1",required=false)MultipartFile imgSmall1
			,String name,String productDetails,Integer marketid,String openid,String contactUser,String addre,String phone
			,@RequestParam(value="mp3file",required=false)MultipartFile mp3file,Integer id ) {
		String mp3 = null;
		if(mp3file!=null) {
			mp3 = ImageUtil.writeFile(mp3file, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		SupermarketInfo product = new SupermarketInfo();
		String smallPath = null;
		if(imgSmall!=null) {
			smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());
		}
		String smallPath1 = null;
		if(imgSmall1!=null) {
			smallPath1 = ImageUtil.writeFile(imgSmall1, ConfigureUtil.PRODUCT_IMAGE.toString());
		}
		product.setId(id);
		product.setOpenid(openid);
		product.setAddre(addre);
		product.setName(name);	
		product.setContactUser(contactUser);
		product.setImgSmall(smallPath);
		product.setPhone(phone);
		product.setMp3(mp3);
		product.setImgLarge(smallPath1);
		try {
			BenefitService.updateProduct(product);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("新增商品异常！",e);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}
	
	@RequestMapping("/editBenefit")
	public void uploadb(@RequestParam(value="files",required=false)MultipartFile[] files,Integer hopenid
		,String productDetails,String user_date,String orimg,Integer id,String activityValue
		) {
		logger.info("productDetails："+productDetails);
		MarketProductInfo product = new MarketProductInfo();
		StringBuffer sb = new StringBuffer();
		String b = "";
		if(files!=null) {
			for(MultipartFile file:files) {
				sb.append(b);
				b=";";
				sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
			}	
		}
		logger.info("productDetails："+productDetails+sb.toString());
		product.setId(id);
		product.setHopenid(hopenid);
		product.setProductDetails(productDetails);
		product.setImgname(orimg+";"+sb.toString());
		product.setCountdown(user_date);
		product.setHtml(activityValue);
		try {
			BenefitService.updateBenefit(product);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("新增商品异常！",e);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}
	@RequestMapping("/addbenefitPro")
	public ModelAndView addbenefitPro(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/benefit_add");
		model.addObject("marketid", marketId);
		return model;
	}
	@RequestMapping("/goEditPro")
	public ModelAndView goEditPro(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/benefit_edit");
		MarketProductInfo Pro = BenefitService.findBenefitByid(marketId);
		model.addObject("info", Pro);
		return model;
	}
	
	@RequestMapping("/uploadBenefit")
	public void editBenefit(@RequestParam("files")MultipartFile[] files,Integer hopenid
		,String productDetails,Integer marketid,String user_date,String activityValue
		) {
		logger.info("productDetails："+productDetails+"marketid："+marketid);
		MarketProductInfo product = new MarketProductInfo();
		StringBuffer sb = new StringBuffer();
		String b = "";
		for(MultipartFile file:files) {
			sb.append(b);
			b=";";
			sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		logger.info("productDetails："+productDetails+"marketid："+marketid+sb.toString());
		product.setMarketid(marketid);
		product.setHopenid(hopenid);
		product.setProductDetails(productDetails);
		product.setImgname(sb.toString());
		product.setCountdown(user_date);
		product.setHtml(activityValue);
		try {
			BenefitService.addBenefit(product);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("新增商品异常！",e);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}
	
	
	@RequestMapping("/deletecon")
	public void deletecon(Integer marketId) {
		boolean bool = BenefitService.deletecon(marketId);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/deletebit")
	public void deletebit(Integer marketId) {
		boolean bool = BenefitService.deletebit(marketId);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	
}
