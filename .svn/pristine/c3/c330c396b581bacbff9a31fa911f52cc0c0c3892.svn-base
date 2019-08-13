package com.abbot.schimneylife.controller.company;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.company.compOpinion;
import com.abbot.schimneylife.pojo.company.news;
import com.abbot.schimneylife.pojo.fenxiao.ProductDistribution;
import com.abbot.schimneylife.service.company.NewsService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.ImageUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/company/news")
public class NewsController extends BaseController {

	@Resource
	NewsService newService;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("manager/company_news");
		Integer totalCount = newService.totalCount();
		model.addObject("count", totalCount);// 商品总数量
		return model;
	}

	@RequestMapping("/findByType")
	public void findByType(Integer draw, Integer start, Integer length) {
		String order = request.getParameter("order[0][dir]");
		String column = "create_time";
		List<news> newsList = newService.findByPage(column, "asc".equals(order) ? "asc" : "desc", start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(newsList));
		json.put("draw", draw);
		Integer totalResult = newService.totalCount();
		json.put("recordsTotal", totalResult);
		json.put("recordsFiltered", totalResult);
		this.writeJSON(json.toJSONString());
	}

	@RequestMapping("/findById")
	public ModelAndView findById(String id) {
		ModelAndView model = new ModelAndView("manager/company_newsDetails");
		news news = newService.findById(id);
		model.addObject("news", news);
		return model;
	}
	
	@RequestMapping("/editById")
	public ModelAndView editById(String id) {
		ModelAndView model = new ModelAndView("manager/company_newsEdit");
		news news = newService.findById(id);
		model.addObject("news", news);
		return model;
	}

	@RequestMapping("/add")
	public ModelAndView upload(@RequestParam("file") MultipartFile file, String title, String abs, Integer degree,
			int type, String details,@RequestParam("file") MultipartFile smallImg) {
		ModelAndView model = new ModelAndView("manager/tips");
		news news = new news();
		if (file != null && file.getSize() != 0) {
			String fileName = ImageUtil.writeDistributionFile(file, ConfigureUtil.COMPANY_IMAGE.toString());
			news.setImg(fileName);
		}
		if (smallImg != null && smallImg.getSize() != 0) {
			String fileName = ImageUtil.writeDistributionFile(smallImg, ConfigureUtil.COMPANY_IMAGE.toString());
			news.setSmallImg(fileName);
		}
		news.setAbs(abs);
		news.setDegree(degree);
		news.setDetails(details);
		news.setTitle(title);
		news.setType(type);
		boolean bool = newService.add(news);
		model.addObject("msg", "操作成功！");
		model.addObject("result", bool);
		model.addObject("path", "company/news/index.do");
		return model;
	}
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam("file") MultipartFile file,@RequestParam("file") MultipartFile smallImg, 
			String title, String abs, Integer degree,int type, String details,String id,String imgs,String smallImgs) {
		ModelAndView model = new ModelAndView("manager/tips");
		news news = new news();
		if (file != null && file.getSize() != 0) {
			String fileName = ImageUtil.writeDistributionFile(file, ConfigureUtil.COMPANY_IMAGE.toString());
			news.setImg(fileName);
		}else {
			news.setImg(imgs);
		}
		if (smallImg != null && smallImg.getSize() != 0) {
			String fileName = ImageUtil.writeDistributionFile(smallImg, ConfigureUtil.COMPANY_IMAGE.toString());
			news.setSmallImg(fileName);
		}else {
			news.setSmallImg(smallImgs);
		}
		news.setId(id);
		news.setAbs(abs);
		news.setDegree(degree);
		news.setDetails(details);
		news.setTitle(title);
		news.setType(type);
		boolean bool = newService.edit(news);
		model.addObject("msg", "操作成功！");
		model.addObject("result", bool);
		model.addObject("path", "company/news/index.do");
		return model;
	}
	
	@RequestMapping("/deleteById")
	public void deleteById(String id) {
		boolean bool=newService.deleteById(id);
		JSONObject obj=this.createJSONResult(CommonKey.SUCCESS_CODE, bool);
		this.writeJSON(obj.toJSONString());
	}
}
