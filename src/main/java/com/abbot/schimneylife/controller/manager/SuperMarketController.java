package com.abbot.schimneylife.controller.manager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.Appointment;
import com.abbot.schimneylife.pojo.shopping.Customer;
import com.abbot.schimneylife.pojo.shopping.MarketProductInfo;
import com.abbot.schimneylife.pojo.shopping.Recharge;
import com.abbot.schimneylife.pojo.shopping.SmarketProductInfo;
import com.abbot.schimneylife.pojo.shopping.SproductParameter;
import com.abbot.schimneylife.pojo.shopping.StoreClass;
import com.abbot.schimneylife.pojo.shopping.SupermarketActivity;
import com.abbot.schimneylife.pojo.shopping.SupermarketAddress;
import com.abbot.schimneylife.pojo.shopping.SupermarketInfo;
import com.abbot.schimneylife.service.shopping.SupermarketActivityService;
import com.abbot.schimneylife.service.shopping.SupermarketInfoService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.ImageUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.spatial4j.core.io.GeohashUtils;

@RequestMapping("/manager/market")
@Controller
public class SuperMarketController extends BaseController {
	private static final Logger logger = Logger.getLogger(SuperMarketController.class);
	@Resource
	private SupermarketInfoService marketService;
	@Resource
	private SupermarketActivityService activityService;

	/**
	 * 超市列表
	 * 
	 * @return
	 */
	@RequestMapping("/marketList")
	public ModelAndView selectMarket() {
		ModelAndView model = new ModelAndView("manager/market_list");
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
	
	@RequestMapping("/marketProList")
	public ModelAndView marketProList() {
			ModelAndView model = new ModelAndView("manager/marketpro_list");
			List<MarketProductInfo> ProList = marketService.findListPro();
			int count = ProList.size();
			model.addObject("count", count);
			model.addObject("ProList", ProList);
			return model;
	}
	
	
	@RequestMapping("/marketProiList")
	public ModelAndView marketProiList() {
			ModelAndView model = new ModelAndView("manager/marketproi_list");
			List<MarketProductInfo> ProList = marketService.findListProi();
			int count = ProList.size();
			model.addObject("count", count);
			model.addObject("ProList", ProList);
			return model;
	}
	
	@RequestMapping("/marketShareList")
	public ModelAndView marketShareList() {
			ModelAndView model = new ModelAndView("manager/marketShare_list");
			List<MarketProductInfo> ProList = marketService.findListShare();
			int count = ProList.size();
			model.addObject("count", count);
			model.addObject("ProList", ProList);
			return model;
	}
	/**
	 * 超市详情
	 * 
	 * @param marketId
	 * @return
	 */
	@RequestMapping("/marketShow")
	public ModelAndView queryMarketById(Integer id) {
		ModelAndView model = new ModelAndView("manager/market_show");
		SupermarketInfo market = marketService.fetchById(id);
		model.addObject("market", market);
		return model;
	}
	/**
	 *添加超市
	 * @return
	 */
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/marketPro_add");
		SupermarketInfo supermarketInfo=marketService.fetchById(marketId);
		model.addObject("supermarketInfo", supermarketInfo);
		return model;
	}
	/**
	 *添加超市
	 * @return
	 */
	@RequestMapping("/addproi")
	public ModelAndView addproi(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/marketProi_add");
		SupermarketInfo supermarketInfo=marketService.fetchById(marketId);
		model.addObject("supermarketInfo", supermarketInfo);
		return model;
	}
	/**
	 *添加超市广告
	 * @return
	 */
	@RequestMapping("/toAddShare")
	public ModelAndView toAddShare(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/marketShare_add");
		SupermarketInfo supermarketInfo=marketService.fetchById(marketId);
		model.addObject("supermarketInfo", supermarketInfo);
		return model;
	}
//	@RequestMapping("/upload")
//	public void upload(@RequestParam("files")MultipartFile files[],@RequestParam("banners")MultipartFile banners[],@RequestParam("imgSmall")MultipartFile imgSmall
//			,String productName,String productDetails,@RequestParam("marketid")Integer  marketid
//			) {
//		String smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());
//		System.out.println(smallPath);
//		
//		MarketProductInfo info = new MarketProductInfo();
//		StringBuffer sb1 = new StringBuffer();
//		String b1 = "";
//		for(MultipartFile file:banners) {
//			sb1.append(b1);
//			b1=";";
//			sb1.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
//			
//			
//		}
//		StringBuffer sb = new StringBuffer();
//		String b = "";
//		for(MultipartFile file:files) {
//			sb.append(b);
//			b=";";
//			sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
//		}
//		info.setBanners(sb1.toString());
//		info.setImgname(sb.toString());
//		info.setMarketid(marketid);
//		info.setProductDetails(productDetails);
//		info.setProductName(productName);
//		info.setImg_small(smallPath);
//		try {
//			
//			marketService.addmarketPro(info);
//			response.setHeader("Access-Control-Allow-Origin", "*");
//			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
//		} catch (Exception e) {
//			logger.error("新增商品异常！",e);
//			response.setHeader("Access-Control-Allow-Origin", "*");
//			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
//		}
//		
//	}
	
	@RequestMapping("/uploadShare")
	public void uploadShare(@RequestParam("files")MultipartFile files[],@RequestParam("banners")MultipartFile banners[],@RequestParam("imgSmall")MultipartFile imgSmall
			,String productName,String productDetails,String productNumber,String productSpec,Integer marketid,Integer productRadio,String productUrl,
			@RequestParam(value="videofile",required=false)MultipartFile videofile,String productUrlName,String productButton
			,@RequestParam(value="imgSmall1",required=false)MultipartFile imgSmall1
			,@RequestParam(value="mp3file",required=false)MultipartFile mp3file
			,@RequestParam(value="imgSmall2",required=false)MultipartFile imgSmall2) {
		String smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());
		String video =null;
		if(videofile!=null) {
			video = ImageUtil.writeFile(videofile, ConfigureUtil.PRODUCT_IMAGE.toString());
			
		}
		String mp3 =null;
		if(mp3file!=null) {
			mp3 = ImageUtil.writeFile(mp3file, ConfigureUtil.PRODUCT_IMAGE.toString());
			
		}
		String smallPath1 = null;
		if(imgSmall1!=null) {
			 smallPath1 = ImageUtil.writeFile(imgSmall1, ConfigureUtil.PRODUCT_IMAGE.toString());
		}
		String smallPath2 = null;
		if(imgSmall1!=null) {
			 smallPath2 = ImageUtil.writeFile(imgSmall2, ConfigureUtil.PRODUCT_IMAGE.toString());
		}
		MarketProductInfo product = new MarketProductInfo();
		StringBuffer sb = new StringBuffer();
		String b = "";
		for(MultipartFile file:files) {
			sb.append(b);
			b=";";
			sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		StringBuffer sb1 = new StringBuffer();
		String b1 = "";
		for(MultipartFile file:banners) {
			sb1.append(b1);
			b1=";";
			sb1.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		product.setVideoImg(smallPath1);
		product.setGapImg(smallPath2);
		product.setBanners(sb1.toString());
		product.setImgname(sb.toString());
		product.setMarketid(marketid);
		product.setProductDetails(productDetails);
		product.setProductName(productName);
		product.setImg_small(smallPath);
		product.setMp3(mp3);
		if(!"".equals(productUrl)) {
			product.setUrl(productUrl);
		}
		if(!"".equals(productUrlName)) {
			product.setUrlname(productUrlName);
		}
		if(!"".equals(productButton)) {
			product.setPbutton(productButton);;
		}
		product.setProductRadio(productRadio);
		product.setVideofile(video);
		
		try {
			marketService.addProductShare(product);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("新增商品异常！",e);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
		
	}
	@RequestMapping("/upload")
	public void upload(@RequestParam("files")MultipartFile files[],@RequestParam("imgSmall")MultipartFile imgSmall
			,String productName,String productDetails,String productSpec,Integer marketid,@RequestParam(value="mp3file",required=false)MultipartFile mp3file
			,Integer productIntegral,Integer comm,@RequestParam(value="imgSmall2",required=false)MultipartFile imgSmall2
			,@RequestParam(value="imgSmall3",required=false)MultipartFile imgSmall3,@RequestParam(value="imgSmall1",required=false)MultipartFile imgSmall1
			,Integer dis,@RequestParam("banners")MultipartFile banners[],@RequestParam(value="videofile",required=false)MultipartFile videofile
			,String productUrl,String productUrlName,String user_date,String pbutton) {
		String smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());
		String smallPath2=null;
		if(imgSmall2!=null) {
			smallPath2= ImageUtil.writeFile(imgSmall2, ConfigureUtil.PRODUCT_IMAGE.toString());
		}
		String smallPath1=null;
		if(imgSmall1!=null) {
			smallPath1= ImageUtil.writeFile(imgSmall1, ConfigureUtil.PRODUCT_IMAGE.toString());
		}String smallPath3=null;
		if(imgSmall3!=null) {
			smallPath3= ImageUtil.writeFile(imgSmall3, ConfigureUtil.PRODUCT_IMAGE.toString());
		}
		String video =null;
		if(videofile!=null) {
			video = ImageUtil.writeFile(videofile, ConfigureUtil.PRODUCT_IMAGE.toString());
		}
		String mp3 =null;
		if(mp3file!=null) {
			mp3 = ImageUtil.writeFile(mp3file, ConfigureUtil.PRODUCT_IMAGE.toString());
		}
		List<SproductParameter> paramList = new ArrayList<>();
		JSONArray specs = JSONArray.parseArray(productSpec);
		for(int i=0;i<specs.size();i++) {
			JSONObject group = specs.getJSONObject(i);
			SproductParameter param = new SproductParameter();
			param.setCur_price(group.getBigDecimal("current"));
			param.setOriginal(group.getBigDecimal("original"));
			param.setRepertory(group.getInteger("repertory"));
			paramList.add(param);
		}
		if(paramList.size()==0) {
			SproductParameter param = new SproductParameter();
			param.setCur_price(BigDecimal.valueOf(0));
			param.setOriginal(BigDecimal.valueOf(0));
			param.setRepertory(0);
			paramList.add(param);
		}
		MarketProductInfo product = new MarketProductInfo();
		StringBuffer sb = new StringBuffer();
		String b = "";
		for(MultipartFile file:files) {
			sb.append(b);
			b=";";
			sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		StringBuffer sb1 = new StringBuffer();
		String b1 = "";
		for(MultipartFile file1:banners) {
			sb1.append(b1);
			b1=";";
			sb1.append(ImageUtil.writeFile(file1, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		product.setPosters(smallPath2);
		product.setImgname(sb.toString());
		product.setBanners(sb1.toString());
		product.setMarketid(marketid);
		product.setProductDetails(productDetails);
		product.setProductName(productName);
		product.setImg_small(smallPath);
		product.setProductIntegral(productIntegral);
		product.setComm(comm);
		product.setDis(dis);
		product.setGapImg(smallPath3);
		product.setVideoImg(smallPath1);
		product.setVideofile(video);
		product.setUrl(productUrl);
		product.setUrlname(productUrlName);
		product.setCountdown(user_date);
		product.setPbutton(pbutton);
		product.setMp3(mp3);
		try {
			marketService.addProduct(product, paramList);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("新增商品异常！",e);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
		
	}
	@RequestMapping("/uploadi")
	public void uploadi(@RequestParam("files")MultipartFile files[],@RequestParam("imgSmall")MultipartFile imgSmall
			,String productName, Integer marketid
			,Integer productIntegral,BigDecimal current) {
		String smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());
		
		MarketProductInfo product = new MarketProductInfo();
		StringBuffer sb = new StringBuffer();
		String b = "";
		for(MultipartFile file:files) {
			sb.append(b);
			b=";";
			sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
//		product.setImgname(sb1.toString());
		product.setImgname(sb.toString());
		product.setMarketid(marketid);
		product.setProductName(productName);
		product.setImg_small(smallPath);
		product.setProductIntegral(productIntegral);
		product.setCur_price(current);
		try {
			marketService.addProducti(product);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("新增商品异常！",e);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
		
	}
	/**
	 * 搜索查询
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/selectByName")
	public ModelAndView selectByName(String name) {
		ModelAndView model = new ModelAndView("manager/market_list");
		List<SupermarketInfo> marketList=marketService.findByName(name);
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
		boolean bool = marketService.disable(marketId);
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
		boolean bool = marketService.enable(marketId);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	
	@RequestMapping("/startPro")
	public void enablePro(Integer proid) {
		boolean bool = marketService.enablePro(proid);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/prostop")
	public void disablePro(Integer proid) {
		boolean bool = marketService.disablePro(proid);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/startPromote")
	public void startPromote(Integer proid) {
		boolean bool = marketService.enablePromote(proid);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/stopPromote")
	public void stopPromote(Integer proid) {
		boolean bool = marketService.disablePromote(proid);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	
	@RequestMapping("/startProi")
	public void enableProi(Integer proid) {
		boolean bool = marketService.enableProi(proid);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/proistop")
	public void disableProi(Integer proid) {
		boolean bool = marketService.disableProi(proid);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	
	
	
	@RequestMapping("/startShare")
	public void startShare(Integer proid) {
		boolean bool = marketService.enableShare(proid);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/stopShare")
	public void stopShare(Integer proid) {
		boolean bool = marketService.disableShare(proid);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	/**
	 * 删除
	 * 
	 * @param marketId
	 */
	@RequestMapping("/deleteMarket")
	public void deleteMarket(Integer marketId) {
		boolean bool = marketService.deleteMarket(marketId);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/deleteMarketPro")
	public void deleteMarketPro(Integer marketId) {
		boolean bool = marketService.deleteMarketPro(marketId);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/deleteMarketProi")
	public void deleteMarketProi(Integer marketId) {
		boolean bool = marketService.deleteMarketProi(marketId);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/deleteMarketShare")
	public void deleteMarketShare(Integer marketId) {
		boolean bool = marketService.deleteMarketShare(marketId);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/goAdd")
	public ModelAndView goAdd() {
		ModelAndView model = new ModelAndView("manager/market_add");
		
		return model;
	}
	@RequestMapping("/goEdit")
	public ModelAndView goEdit(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/market_edit");
		SupermarketInfo market = marketService.fetchById(marketId);
		model.addObject("market",market);
		return model;
	}
	
	@RequestMapping("/goEditPro")
	public ModelAndView goEditPro(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/marketPro_edit");
		System.out.println(marketId);
		MarketProductInfo market = marketService.fetchProById(marketId);
		SupermarketInfo  info=	marketService.fetchById(market.getMarketid());
		market.setName(info.getName());
		model.addObject("market",market);
		return model;
	}
	
	@RequestMapping("/goEditProi")
	public ModelAndView goEditProi(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/marketProi_edit");
		System.out.println(marketId);
		MarketProductInfo market = marketService.fetchProiById(marketId);
		SupermarketInfo  info=	marketService.fetchById(market.getMarketid());
		market.setName(info.getName());
		model.addObject("market",market);
		return model;
	}
	
	@RequestMapping("/goEditShare")
	public ModelAndView goEditShare(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/marketShare_edit");
		MarketProductInfo market = marketService.fetchShareById(marketId);
	
		model.addObject("market",market);
		return model;
	}
	
	@RequestMapping("/save")
	public void save(String openid,String address,String addre,String contactUser,String productTime,String products,String distribution
			,@RequestParam("imgSmall")MultipartFile imgSmall,@RequestParam("information")MultipartFile[] information
			,String productDetails,BigDecimal lat,BigDecimal lng,String name,String phone,String product_id
			,Integer recommendation,String text,String route,Integer mclass) {
		
		
		String smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());
		StringBuffer sb1 = new StringBuffer();
		String g1 = "";
		for(MultipartFile file:information) {
			String path = ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString());
			sb1.append(g1);
			sb1.append(path);
			g1 = ";";
		}
		SupermarketInfo market = new SupermarketInfo();
		market.setOpenid(openid);
		market.setProducts(products);
		market.setProductTime(productTime);
		market.setContactUser(contactUser);
		market.setDetails(productDetails);
		market.setHtml(text);
		market.setImgSmall(smallPath);
		market.setInformation(sb1.toString());
		market.setName(name);
		market.setPhone(phone);
		market.setTel(product_id);
		market.setDistribution(distribution);
		market.setMclass(mclass);
		market.setAddre(addre);
		market.setRecommendation(recommendation==null?0:recommendation);
		market.setStatus(CommonKey.DISABLE_FLAG);
		SupermarketAddress sa = new SupermarketAddress();
		sa.setBusRoute(route);
		sa.setDetail(address);
		sa.setLatitude(lat);
		sa.setLongitude(lng);
		String geocode = GeohashUtils.encodeLatLon(lat.doubleValue(), lng.doubleValue(), 4);
		sa.setGeoCode(geocode);
		market.setAddress(sa);
		boolean res = false;
		try {
			marketService.addSupermarket(market);
			res = true;
		} catch (Exception e) {
			logger.error("",e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/edit")
	public void edit(String openid,String address,String addre,String contactUser,String details,String productTime,String products,String distribution
			,@RequestParam(value="imgSmall",required=false)MultipartFile imgSmall,@RequestParam("information")MultipartFile[] information
			,String info,BigDecimal lat,BigDecimal lng,String name,String phone,String text,String route,Integer recommendation
			,Integer supermarketId,String supermarketAddressId,String oriInformation,Integer mclass) {
		String smallPath = null;
		if(imgSmall!=null) {
			smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		
		StringBuffer sb1 = new StringBuffer();
		String g1 = "";
		if(information!=null) {
			for(MultipartFile file:information) {
				String path = ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString());
				sb1.append(g1);
				sb1.append(path);
				g1= ";";
			}			
		}
		SupermarketInfo market = new SupermarketInfo();
		
		market.setMclass(mclass);
		market.setOpenid(openid);
		market.setId(supermarketId);
		market.setInformation(oriInformation+";"+sb1.toString());
		market.setContactUser(contactUser);
		market.setDetails(details);
		market.setHtml(text);
		market.setImgSmall(smallPath);
		market.setName(name);
		market.setPhone(phone);
		market.setProducts(products);
		market.setProductTime(productTime);
		market.setRecommendation(recommendation);
		market.setAddre(addre);
		market.setStatus(CommonKey.DISABLE_FLAG);
		market.setDistribution(distribution);
		SupermarketAddress sa = new SupermarketAddress();
		sa.setId(supermarketAddressId);
		sa.setBusRoute(route);
		sa.setDetail(address);
		sa.setLatitude(lat);
		sa.setLongitude(lng);
		String geocode = null;
		if(lat!=null&&lng!=null) {
			geocode = GeohashUtils.encodeLatLon(lat.doubleValue(), lng.doubleValue(), 4);			
		}
		sa.setGeoCode(geocode);
		market.setAddress(sa);
		
		boolean res = false;
		try {
			marketService.update(market);
			res = true;
		} catch (Exception e) {
			logger.error("",e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/editpro")
	public void editpro(@RequestParam(value="files",required=false)MultipartFile files[],@RequestParam("banners")MultipartFile banners[],@RequestParam(value="imgSmall",required=false)MultipartFile imgSmall
			,String productName,String productDetails,Integer  marketid,Integer id,String orimg,String oribanner,Integer productIntegral,String productSpec,String user_date,Integer comm
			,@RequestParam(value="imgSmall1",required=false)MultipartFile imgSmall1,String productUrl,String productUrlName,@RequestParam(value="mp3file",required=false)MultipartFile mp3file
			,@RequestParam(value="imgSmall2",required=false)MultipartFile imgSmall2,@RequestParam(value="videofile",required=false)MultipartFile videofile
			,@RequestParam(value="imgSmall3",required=false)MultipartFile imgSmall3,Integer dis,String pbutton) {
		String smallPath = null;
		String smallPath1 = null;
		String smallPath2 = null;
		String smallPath3 = null;
		if(imgSmall!=null) {
			smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		if(imgSmall1!=null) {
			smallPath1 = ImageUtil.writeFile(imgSmall1, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		
		if(imgSmall2!=null) {
			smallPath2 = ImageUtil.writeFile(imgSmall2, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		if(imgSmall3!=null) {
			smallPath3 = ImageUtil.writeFile(imgSmall3, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		List<SproductParameter> paramList = new ArrayList<>();
		JSONArray specs = JSONArray.parseArray(productSpec);
		for(int i=0;i<specs.size();i++) {
			JSONObject group = specs.getJSONObject(i);
			SproductParameter param = new SproductParameter();
			param.setCur_price(group.getBigDecimal("current"));
			param.setOriginal(group.getBigDecimal("original"));
			param.setRepertory(group.getInteger("repertory"));
			paramList.add(param);
		}
		if(paramList.size()==0) {
			SproductParameter param = new SproductParameter();
			param.setCur_price(BigDecimal.valueOf(0));
			param.setOriginal(BigDecimal.valueOf(0));
			param.setRepertory(0);
			paramList.add(param);
		}
		String video = null;
		if(videofile!=null) {
			video = ImageUtil.writeFile(videofile, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		String mp3 =null;
		if(mp3file!=null) {
			mp3 = ImageUtil.writeFile(mp3file, ConfigureUtil.PRODUCT_IMAGE.toString());
		}
		MarketProductInfo info = new MarketProductInfo();
		StringBuffer sb1 = new StringBuffer();
		String b1 = "";
		if(banners!=null) {
		for(MultipartFile file:banners) {
			sb1.append(b1);
			b1=";";
			sb1.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		}
		StringBuffer sb = new StringBuffer();
		String b = "";
		if(files!=null) {
		for(MultipartFile file:files) {
			sb.append(b);
			b=";";
			sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		}
		info.setBanners(oribanner+";"+sb1.toString());
		info.setImgname(orimg+";"+sb.toString());
		info.setMarketid(marketid);
		info.setProductDetails(productDetails);
		info.setProductName(productName);
		info.setImg_small(smallPath);
		info.setPosters(smallPath2);
		info.setGapImg(smallPath3);
		info.setVideoImg(smallPath1);
		info.setProductIntegral(productIntegral);
		info.setComm(comm);
		info.setCountdown(user_date);
		info.setId(id);
		info.setDis(dis);
		info.setVideofile(video);
		info.setUrl(productUrl);
		info.setUrlname(productUrlName);
		info.setPbutton(pbutton);
		info.setMp3(mp3);
		boolean res = false;
		try {
			marketService.updatePro(info,paramList.get(0));
			res = true;
		} catch (Exception e) {
			logger.error("",e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	
	@RequestMapping("/editproi")
	public void editproi(@RequestParam(value="files",required=false)MultipartFile files[],@RequestParam(value="imgSmall",required=false)MultipartFile imgSmall
			,String productName,Integer  marketid,Integer id,String orimg,Integer productIntegral,BigDecimal current) {
		String smallPath = null;
		if(imgSmall!=null) {
			smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		
		MarketProductInfo info = new MarketProductInfo();
		StringBuffer sb = new StringBuffer();
		String b = "";
		if(files!=null) {
		for(MultipartFile file:files) {
			sb.append(b);
			b=";";
			sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		}
		info.setImgname(orimg+";"+sb.toString());
		info.setMarketid(marketid);
		info.setProductName(productName);
		info.setImg_small(smallPath);
		info.setProductIntegral(productIntegral);
		info.setCur_price(current);
		info.setId(id);
		boolean res = false;
		try {
			marketService.updateProi(info);
			res = true;
		} catch (Exception e) {
			logger.error("",e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	
	
	
	
	
	
	@RequestMapping("/editShare")
	public void editShare(@RequestParam("files")MultipartFile files[],@RequestParam("banners")MultipartFile banners[],@RequestParam(value="imgSmall",required=false)MultipartFile imgSmall
			,String productName,String productDetails,Integer  marketid,Integer id,String orimg,String oribanner,String productUrl,Integer productRadio
			,@RequestParam(value="videofile",required=false)MultipartFile videofile,String productUrlName,String productButton,
			@RequestParam(value="imgSmall1",required=false)MultipartFile imgSmall1,@RequestParam(value="imgSmall2",required=false)MultipartFile imgSmall2
			,@RequestParam(value="mp3file",required=false)MultipartFile mp3file
			) {
		String smallPath = null;
		if(imgSmall!=null) {
			smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		String smallPath1 = null;
		if(imgSmall1!=null) {
			smallPath1 = ImageUtil.writeFile(imgSmall1, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		String smallPath2 = null;
		if(imgSmall2!=null) {
			smallPath2 = ImageUtil.writeFile(imgSmall2, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		String video = null;
		if(videofile!=null) {
			video = ImageUtil.writeFile(videofile, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		String mp3 = null;
		if(mp3file!=null) {
			mp3 = ImageUtil.writeFile(mp3file, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		MarketProductInfo info = new MarketProductInfo();
		StringBuffer sb1 = new StringBuffer();
		String b1 = "";
		if(banners!=null) {
		for(MultipartFile file:banners) {
			sb1.append(b1);
			b1=";";
			sb1.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		}
		StringBuffer sb = new StringBuffer();
		String b = "";
		if(files!=null) {
		for(MultipartFile file:files) {
			sb.append(b);
			b=";";
			sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		}
		System.out.println(oribanner+"    "+orimg);
		info.setBanners(oribanner+";"+sb1.toString());
		info.setImgname(orimg+";"+sb.toString());
		info.setMarketid(marketid);
		info.setProductDetails(productDetails);
		info.setProductName(productName);
		info.setImg_small(smallPath);
		info.setVideoImg(smallPath1);
		info.setGapImg(smallPath2);
		info.setMp3(mp3);
		if(!"".equals(productUrl)) {
			info.setUrl(productUrl);
		}
		if(!"".equals(productUrlName)) {
			info.setUrlname(productUrlName);
		}
		if(!"".equals(productButton)) {
			info.setPbutton(productButton);
		}
		info.setProductRadio(productRadio);
		info.setVideofile(video);
		info.setId(id);
		boolean res = false;
		try {
			marketService.updateShare(info);
			res = true;
		} catch (Exception e) {
			logger.error("",e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	
	
	
	
	
	@RequestMapping("/addgold")
	public ModelAndView addgold(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/market_activity2");
		SupermarketInfo  info=marketService.fetchById(marketId);
		String msg=null;
		if(info!=null) {
			if(info.getOpenid()==null||("").equals(info.getOpenid())) {
				msg="请先添加门店openid";
			}
			model.addObject("info", info);
		}
		
		model.addObject("msg", msg);
		return model;
	}
	
	
	@RequestMapping("/addshareGold")
	public ModelAndView addshareGold(String openid,Double amount) {
		int payment=BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).intValue();
		Recharge r=	marketService.findBalance(openid);
		if(r==null) {
			Recharge re =new Recharge();
			re.setRecharge(payment);
			re.setBalance(payment);
			re.setConsume(0);
			re.setMopenid(openid);
			marketService.addRecharge(re);
		}else {
			Recharge re =new Recharge();
			re.setRecharge(payment+r.getRecharge());
			re.setBalance(payment+r.getBalance());
			re.setConsume(r.getConsume());
			re.setMopenid(openid);
			marketService.updateRecharge(re);
		}
		ModelAndView model=new ModelAndView("redirect:/manager/market/marketList.do");
		
		return model;
	}
	
	
	
	@RequestMapping("/activity")
	public ModelAndView activity(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/market_activity");
		List<SupermarketActivity> list = activityService.findActivityByMarketId(marketId);
		model.addObject("activityList",list);
		model.addObject("marketId",marketId);
		return model;
	}
	@RequestMapping("/addAct")
	public void addAct(SupermarketActivity activity) {
		boolean res = activityService.insert(activity);
		JSONObject obj = this.createJSONResult(CommonKey.SUCCESS_CODE, res);
		obj.put("id", activity.getId());
		this.writeJSON(obj.toJSONString());
	}
	@RequestMapping("/updateAct")
	public void updateAct(SupermarketActivity activity) {
		boolean res = activityService.update(activity);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/deleteAct")
	public void deleteAct(String id) {
		boolean res = activityService.delete(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/marketOrderList")
	public ModelAndView marketOrderList() {
		ModelAndView model = new ModelAndView("manager/marketOrder_list");
		List<Customer> list = marketService.findListOrder();
		for (Customer customer : list) {
			SupermarketInfo  minfo=	marketService.fetchById(customer.getMarketId());
			MarketProductInfo  pinfo=marketService.fetchProById(customer.getProId());
			if(pinfo!=null) {
				
				System.out.println(pinfo.getId());
				customer.setStorename(minfo.getName());
				customer.setProductname(pinfo.getProductName());
			}
		}
		int count = list.size();
		model.addObject("count", count);
		model.addObject("list", list);
		return model;
	}
	/**
	 * 预约信息管理
	 */
	
	@RequestMapping("/marketAppointment")
	public ModelAndView marketAppointment() {
		ModelAndView model = new ModelAndView("manager/marketAppointment_list");
		List<Appointment> list = marketService.findListAppointment();
		for (Appointment appointment : list) {
			MarketProductInfo pinfo=	marketService.findProductByid(appointment.getGid());
			SupermarketInfo  info=	marketService.fetchById(pinfo.getMarketid());
			appointment.setStorename(info.getName());
		}
		int count = list.size();
		model.addObject("count", count);
		model.addObject("list", list);
		return model;
	}
	/**
	 * 首页动态信息管理
	 */
	@RequestMapping("/addVipcn")
	public ModelAndView addVipcn(Integer marketId) {
		ModelAndView model=new ModelAndView("manager/market_addVipcn");
		SupermarketInfo  info=	marketService.fetchById(marketId);
		model.addObject("supermarketInfo",info);
		return model;
	}
	@RequestMapping("/uploadVipcn")
	public void uploadShare(@RequestParam("imgSmall")MultipartFile imgSmall
			,String productName,String productUrl,Integer marketid
			) {
		String smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());
		MarketProductInfo product = new MarketProductInfo();
		product.setMarketid(marketid);
		product.setProductName(productName);
		product.setImg_small(smallPath);
		product.setUrl(productUrl);
		try {
			marketService.addProductVipcn(product);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("新增商品异常！",e);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}
	
	@RequestMapping("/findListVipcn")
	public ModelAndView findListVipcn() {
			ModelAndView model = new ModelAndView("manager/marketVipcn_list");
			List<MarketProductInfo> ProList = marketService.findListVipcn();
			int count = ProList.size();
			model.addObject("count", count);
			model.addObject("ProList", ProList);
			return model;
	}
	
	@RequestMapping("/deleteMarketVipcn")
	public void deleteMarketVipcn(Integer marketId) {
		boolean bool = marketService.deleteMarketVipcn(marketId);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/startVipcn")
	public void startVipcn(Integer proid) {
		boolean bool = marketService.enableVipcn(proid);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/stopVipcn")
	public void stopVipcn(Integer proid) {
		boolean bool = marketService.disableVipcn(proid);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/goEditVipcn")
	public ModelAndView goEditVipcn(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/marketVipcn_edit");
		MarketProductInfo market = marketService.fetchVipcnById(marketId);
		model.addObject("market",market);
		return model;
	}
	
	@RequestMapping("/editVipcn")
	public void editVipcn(@RequestParam(value="imgSmall",required=false)MultipartFile imgSmall
			,String productName,Integer  id,String productUrl) {
		String smallPath = null;
		if(imgSmall!=null) {
			smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		
		MarketProductInfo info = new MarketProductInfo();
		info.setId(id);
		info.setProductName(productName);
		info.setImg_small(smallPath);
		info.setUrl(productUrl);
		boolean res = false;
		try {
			marketService.updateVipcn(info);
			res = true;
		} catch (Exception e) {
			logger.error("",e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	
	
	@RequestMapping("/findListAttract")
	public ModelAndView findListAttract() {
			ModelAndView model = new ModelAndView("manager/marketAttract_list");
			List<Appointment> ProList = marketService.findListAttract();
			int count = ProList.size();
			model.addObject("count", count);
			model.addObject("ProList", ProList);
			return model;
	}
	
	
	@RequestMapping("/deleteAttract")
	public void deleteAttract(Integer proid) {
		boolean bool = marketService.deleteAttract(proid);
		JSONObject json = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(json.toJSONString());
	}
	/**
	 * 便民信息管理
	 */
	
	@RequestMapping("/secondProiList")
	public ModelAndView secondProiList() {
			ModelAndView model = new ModelAndView("manager/marketSecondProiList");
			List<SmarketProductInfo> ProList = marketService.secondProiList();
			int count = ProList.size();
			model.addObject("count", count);
			model.addObject("ProList", ProList);
			return model;
	}
	
	@RequestMapping("/secondStop")
	public void secondStop(Integer proid) {
		boolean res = marketService.secondStop(proid);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/secondStart")
	public void secondStart(Integer proid) {
		boolean res = marketService.secondStart(proid);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/deleteSecond")
	public void deleteSecond(Integer id) {
		boolean res = marketService.deleteSecond(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	
	@RequestMapping("/goEditSecond")
	public ModelAndView goEditSecond(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/marketSecondPro_edit");
		SmarketProductInfo market = marketService.SecondProByid(marketId);
		model.addObject("market", market);
		return model;
	}
	
	@RequestMapping("/editSecond")
	public void editSecond(@RequestParam(value="banners",required=false)MultipartFile banners[]
			,String productName,Integer id,String oribanner,String phone
			) {
	
		SmarketProductInfo info = new SmarketProductInfo();
		StringBuffer sb = new StringBuffer();
		String b = "";
		if(banners!=null) {
		for(MultipartFile file:banners) {
			sb.append(b);
			b=";";
			sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		}
		info.setImgname(oribanner+";"+sb.toString());
		info.setProductName(productName);
		info.setPhone(phone);
		info.setId(id);
		boolean res = false;
		try {
			marketService.updateSecond(info);
			res = true;
		} catch (Exception e) {
			logger.error("",e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	
	/**
	 * 福利管理
	 */
	
	@RequestMapping("/storeProiList")
	public ModelAndView storeProiList() {
			ModelAndView model = new ModelAndView("manager/marketStoreProiList");
			List<MarketProductInfo> ProList = marketService.storeProiList();
			int count = ProList.size();
			model.addObject("count", count);
			model.addObject("ProList", ProList);
			return model;
	}
	@RequestMapping("/storeStop")
	public void storeStop(Integer proid) {
		boolean res = marketService.storeStop(proid);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/storeStart")
	public void storeStart(Integer proid) {
		boolean res = marketService.storeStart(proid);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/deleteStore")
	public void deleteStore(Integer id) {
		boolean res = marketService.deleteStore(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/goEditStore")
	public ModelAndView goEditStore(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/marketStorePro_edit");
		MarketProductInfo market = marketService.storeProByid(marketId);
		List<StoreClass> listClass = marketService.findStoreClass();
		model.addObject("market", market);
		model.addObject("listClass", listClass);
		return model;
	}
	
	@RequestMapping("/editStore")
	public void editStore(@RequestParam(value="files",required=false)MultipartFile files[],@RequestParam(value="imgSmall",required=false)MultipartFile imgSmall
			,String productName,Integer  marketid,Integer id,String orimg
			) {
		String smallPath = null;
		if(imgSmall!=null) {
			smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());			
		}
		MarketProductInfo info = new MarketProductInfo();
		StringBuffer sb = new StringBuffer();
		String b = "";
		if(files!=null) {
		for(MultipartFile file:files) {
			sb.append(b);
			b=";";
			sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		}
		info.setImgname(orimg+";"+sb.toString());
		info.setMarketid(marketid);
		info.setProductName(productName);
		info.setImg_small(smallPath);
		info.setId(id);
		boolean res = false;
		try {
			marketService.updateStore(info);
			res = true;
		} catch (Exception e) {
			logger.error("",e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/addstorePro")
	public ModelAndView addstorePro(Integer marketId) {
		ModelAndView model = new ModelAndView("manager/market_addstorePro");
		SupermarketInfo supermarketInfo=marketService.fetchById(marketId);
		model.addObject("supermarketInfo", supermarketInfo);
		List<StoreClass> listClass = marketService.findStoreClass();
		model.addObject("listClass", listClass);
		return model;
	}
	@RequestMapping("/uploadStore")
	public void upload(@RequestParam("files")MultipartFile files[],@RequestParam("imgSmall")MultipartFile imgSmall
			,String productName,Integer bmclass,Integer marketid,String price,String countdown 
			) {
		String smallPath = ImageUtil.writeFile(imgSmall, ConfigureUtil.PRODUCT_IMAGE.toString());
		MarketProductInfo product = new MarketProductInfo();
		StringBuffer sb = new StringBuffer();
		String b = "";
		for(MultipartFile file:files) {
			sb.append(b);
			b=";";
			sb.append(ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString()));
		}
		product.setImgname(sb.toString());
		product.setMclass(bmclass);
		product.setProductName(productName);
		product.setMarketid(marketid);
		product.setPrice(price);
		product.setCountdown(countdown);
		product.setImg_small(smallPath);
		try {
			marketService.addStoreProduct(product);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
		} catch (Exception e) {
			logger.error("新增商品异常！",e);
			response.setHeader("Access-Control-Allow-Origin", "*");
			this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, false).toJSONString());
		}
	}
	
	
}
