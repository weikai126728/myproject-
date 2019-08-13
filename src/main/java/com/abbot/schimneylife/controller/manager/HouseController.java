package com.abbot.schimneylife.controller.manager;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.HouseInfo;
import com.abbot.schimneylife.pojo.shopping.Recharge;
import com.abbot.schimneylife.pojo.shopping.SupermarketInfo;
import com.abbot.schimneylife.service.shopping.HouseSerivce;
import com.abbot.schimneylife.service.shopping.SupermarketInfoService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.ImageUtil;

@Controller
@RequestMapping("/manager/house")
public class HouseController extends BaseController{
	private static final Logger logger = Logger.getLogger(HouseController.class);
	@Resource
	private SupermarketInfoService marketService;
	
	@Resource
	private HouseSerivce houseSerivce;
	
	@RequestMapping("/marketList")
	public ModelAndView selectMarket() {
		ModelAndView model = new ModelAndView("manager/house_list");
		List<SupermarketInfo> marketList = marketService.selectMarket();
		for (SupermarketInfo supermarketInfo : marketList) {
			if(supermarketInfo.getOpenid()==null) {
				supermarketInfo.setBalance(0);
				supermarketInfo.setConsume(0);
			}else {
				Recharge r=	marketService.findBalance(supermarketInfo.getOpenid());
				if(r==null) {
					supermarketInfo.setBalance(0);
					supermarketInfo.setConsume(0);
				}else {
					supermarketInfo.setBalance(r.getBalance());
					supermarketInfo.setConsume(r.getConsume());
				}
			}
		}
		
		int count = marketList.size();
		model.addObject("count", count);
		model.addObject("marketList", marketList);
		return model;
	}
	@RequestMapping("/toAdd")
	public ModelAndView toAddHouse() {
		ModelAndView model = new ModelAndView("manager/house_rentadd");
		return model;
	}
	
	@RequestMapping("/upload")
	public void upload(@RequestParam("banners")MultipartFile banners[],Integer mclass,Integer rent,int[] facility
			,String name,String address,String phone,String area,String openid,BigDecimal lat,BigDecimal lng
			,String houseType) {
		HouseInfo product = new HouseInfo();
		StringBuffer sb = new StringBuffer();
		String b = "";
		for(MultipartFile file:banners) {
			sb.append(b);
			b=";";
			sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		StringBuffer sb1 = new StringBuffer();
		String b1 = "";
		for(Integer f:facility) {
			sb1.append(b1);
			b1=";";
			sb1.append(f);
		}
		product.setBanners(sb.toString());
		product.setName(name);
		product.setArea(area);
		product.setAddress(address);
		product.setFacility(sb1.toString());
		product.setHouseType(houseType);
		product.setRent(rent);
		product.setMclass(mclass);
		product.setLatitude(lat);
		product.setLongitude(lng);
		product.setPhone(phone);
		product.setOpenid(openid);
		try {
			houseSerivce.addHosue(product);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("新增商品异常！",e);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
		
	}
}
