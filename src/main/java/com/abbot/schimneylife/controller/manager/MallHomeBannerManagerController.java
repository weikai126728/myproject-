package com.abbot.schimneylife.controller.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.MallHomeBanner;
import com.abbot.schimneylife.pojo.shopping.MallProduct;
import com.abbot.schimneylife.service.shopping.MallHomeBannerService;
import com.abbot.schimneylife.service.shopping.MallProductService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.ImageUtil;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/manager/banner")
@Controller
public class MallHomeBannerManagerController extends BaseController{

	@Resource
	private MallHomeBannerService bannerService;
	@Resource
	private MallProductService productService;
	/**
	 * 移动商城
	 * @return
	 */
	@RequestMapping("/mhome")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("manager/banner_mhome");
		List<MallHomeBanner> banners = bannerService.findByType(CommonKey.BannerType.MOBILE.getType());
		model.addObject("banners",banners);
		return model;
	}
	@RequestMapping("/toSave")
	public ModelAndView toSave() {
		ModelAndView model = new ModelAndView("manager/banner_add");
		return model;
	}
	@RequestMapping("/save")
	public ModelAndView save(@RequestParam("file")MultipartFile file,String path) {
		ModelAndView model = new ModelAndView("manager/tips");
		String image = ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString());
		MallHomeBanner banner = new MallHomeBanner();
		banner.setImage_path(path);
		banner.setImages(image);
		banner.setType(CommonKey.BannerType.MOBILE.getType());
		if(bannerService.insert(banner)) {
			model.addObject("msg","添加轮播图成功！");			
		}else {
			model.addObject("msg","添加轮播图失败！");
		}
		return model;
	}
	@RequestMapping("/delete")
	public void delete(String id) {
		boolean res = bannerService.delete(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/findPro")
	public void findPro(String number) {
		if(number==null) {
			number = "";
		}
		number = number.trim();
		MallProduct product = productService.findByNumber(number);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, JSONObject.toJSON(product)).toJSONString());
	}
	@RequestMapping("/mhome1")
	public ModelAndView home1() {
		ModelAndView model = new ModelAndView("manager/banner_mhome1");
		List<MallHomeBanner> banners = bannerService.findByType(CommonKey.BannerType.POBILE.getType());
		model.addObject("banners",banners);
		return model;
	}
	@RequestMapping("/toSave1")
	public ModelAndView toSave1() {
		ModelAndView model = new ModelAndView("manager/banner_add1");
		return model;
	}
	@RequestMapping("/save1")
	public ModelAndView save1(@RequestParam("file")MultipartFile file,String path) {
		ModelAndView model = new ModelAndView("manager/tips");
		String image = ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString());
		MallHomeBanner banner = new MallHomeBanner();
		banner.setImage_path(path);
		banner.setImages(image);
		banner.setType(CommonKey.BannerType.POBILE.getType());
		if(bannerService.insert(banner)) {
			model.addObject("msg","添加轮播图成功！");			
		}else {
			model.addObject("msg","添加轮播图失败！");
		}
		return model;
	}
	@RequestMapping("/delete1")
	public void delete1(String id) {
		boolean res = bannerService.delete(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/findPro1")
	public void findPro1(String number) {
		if(number==null) {
			number = "";
		}
		number = number.trim();
		MallProduct product = productService.findByNumber(number);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, JSONObject.toJSON(product)).toJSONString());
	}
}

