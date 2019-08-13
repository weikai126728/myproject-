package com.abbot.schimneylife.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.media.Media;
import com.abbot.schimneylife.service.media.MediaService;
import com.abbot.schimneylife.service.shopping.WeiXinService;
import com.abbot.schimneylife.util.AccessTokenUtil;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.HttpRequestUtil;
import com.abbot.schimneylife.util.ImageUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 素材管理
 * 
 * @author Administrator
 *
 */
@RequestMapping("/manager/material")
@Controller
public class MaterialManagerController extends BaseController {

	private static final Logger logger = Logger.getLogger(MaterialManagerController.class);
	@Resource
	private MediaService mediaService;
	@Resource
	private WeiXinService wxService;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("manager/material_list");
		return model;
	}

	@RequestMapping("/toAdd")
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("manager/material_add");
		return model;
	}
	@RequestMapping("/add")
	public void add(@RequestParam("file") MultipartFile file,String author,String content,String content_source_url,String title,String type,String digest,Integer show_cover_pic) {
		String path = ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString());
		String accessToken = this.getToken();
		String action = "https://api.weixin.qq.com/cgi-bin/material/add_material?type=image&access_token=" + accessToken;// ACCESS_TOKEN是获取到的access_token
		boolean res = false;
		try {
			JSONObject json = HttpRequestUtil.sendFile(action, ConfigureUtil.PRODUCT_IMAGE.toString()+path.replace("_", "/"),"media");
			if(json.containsKey("media_id")) {
				JSONArray array = new JSONArray();
				JSONObject obj = new JSONObject();
				obj.put("title", title);
				obj.put("thumb_media_id", json.getString("media_id"));
				obj.put("digest", digest);
				obj.put("content", content);
				obj.put("show_cover_pic", show_cover_pic);
				obj.put("content_source_url", content_source_url);
				obj.put("author", author);
				array.add(obj);
				JSONObject data = new JSONObject();
				data.put("articles", array);
				String url = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=" + accessToken;
				JSONObject result = HttpRequestUtil.sendPost(url, data.toJSONString());
				if(result.containsKey("media_id")) {
					Media media = new Media();
					media.setImage_url(path);
					media.setMedia_id(result.getString("media_id"));
					media.setImage_media_id(json.getString("media_id"));
					media.setType(type);
					res = mediaService.insert(media);
				}
			}
		} catch (IOException e) {
			logger.error("",e);
		}
//		ModelAndView model = new ModelAndView("manager/tips");
//		String msg = "";
//		if(res) {
//			msg = "添加成功！";
//		}else {
//			msg = "添加失败";
//		}
//		model.addObject("msg", msg);
//		return model;
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}

	@RequestMapping("/findByPage")
	public void findByPage(Integer draw, String startTime, String endTime, Integer start, Integer length) {
		if (startTime != null && "".equals(startTime.trim())) {
			startTime = null;
		}
		if (endTime != null && "".equals(endTime.trim())) {
			endTime = null;
		}
		List<Media> list = mediaService.findByPage(start, length, startTime, endTime);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(list));
		json.put("draw", draw);
		Integer totalResult = mediaService.countTotal(null, null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = mediaService.countTotal(startTime, endTime);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	/**
	 * 删除素材
	 * @param id
	 */
	@RequestMapping("/delete")
	public void delete(Integer id) {
		boolean res = false;
		Media media = mediaService.fetchById(id);
		String token = this.getToken();
		String url = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token="+token;
		JSONObject json = new JSONObject();
		json.put("media_id", media.getMedia_id());//先删除图文素材
		JSONObject result = HttpRequestUtil.sendPost(url, json.toJSONString());
		if(result.getInteger("errcode")==0) {//删除成功进行下一步删除
			json.put("media_id", media.getImage_media_id());
			HttpRequestUtil.sendPost(url, json.toJSONString());
			res = mediaService.delete(id);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	/**
	 * 发送预览消息
	 * @param openid
	 * @param id
	 */
	@RequestMapping("/preview")
	public void preview(String openid,Integer id) {
		Media media = mediaService.fetchById(id);
		String token = this.getToken();
		String url = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token="+token;
		JSONObject json = new JSONObject();
		json.put("touser", openid);
		JSONObject m = new JSONObject();
		m.put("media_id", media.getMedia_id());
		json.put("mpnews", m);
		json.put("msgtype", "mpnews");
		JSONObject result = HttpRequestUtil.sendPost(url, json.toJSONString());
		boolean res = false;
		if("0".equals(result.getString("errcode"))) {
			res = true;
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	/**
	 * 消息群发
	 * @param id
	 */
	@RequestMapping("/sendAll")
	public void sendAll(Integer id) {
		boolean res = false;
		Media media = mediaService.fetchById(id);
		String token = this.getToken();
		String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+token;//获取用户列表
		JSONObject result = HttpRequestUtil.sendPost(url, null);
		if(result.containsKey("data")) {
			JSONObject data = result.getJSONObject("data");
			JSONArray users = data.getJSONArray("openid");
			//获取用户列表后群发
			url = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token="+token;
			JSONObject data0 = new JSONObject();
			data0.put("touser", users);
			JSONObject obj = new JSONObject();
			obj.put("media_id", media.getMedia_id());
			data0.put("mpnews", obj);
			data0.put("msgtype", "mpnews");
			data0.put("send_ignore_reprint", 1);//图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。
			result = HttpRequestUtil.sendPost(url, data0.toJSONString());
			if("0".equals(result.getString("errcode"))) {
				res = true;
			}
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	private String getToken() {
		if (AccessTokenUtil.valid()) {
		} else {
			AccessTokenUtil.setToken(wxService.getAccessToken(), System.currentTimeMillis());
		}
		return AccessTokenUtil.getToken();
	}
}
