package com.abbot.schimneylife.controller.fenxiao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.fenxiao.UserDistribution;
import com.abbot.schimneylife.service.fenxiao.UserDistributionService;
import com.abbot.schimneylife.util.CommonKey;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/distribution/user")
public class UserDistributionController extends BaseController {

	@Resource
	private UserDistributionService udService;

	@RequestMapping("/selectUser")
	private ModelAndView selectUser() {
		ModelAndView model = new ModelAndView("manager/distribution_userList");
		List<UserDistribution> udList = udService.selectUser();
		int count = udList.size();
		model.addObject("udList", udList);
		model.addObject("count", count);
		return model;
	}
	@RequestMapping("/index")
	public ModelAndView index(String typeId) {
		ModelAndView model=new ModelAndView("manager/distribution_userList");
		Integer totalCount=udService.totalCount();
		model.addObject("count",totalCount);//商品总数量
		if(typeId!=null&&!typeId.isEmpty()) {
			model.addObject("typeIde",typeId);
		}
		return model;
	}
	
	@RequestMapping("/findByType")
	public void findByType(Integer draw,Integer start,Integer length) {
		
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "id";
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
		List<UserDistribution> userList = udService.findByPageAndType( column, "asc".equals(order)?"asc":"desc", start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(userList));
		json.put("draw", draw);
		Integer totalResult = udService.totalCount();
		json.put("recordsTotal", totalResult);
		json.put("recordsFiltered", totalResult);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/stop")
	private void stop(int userId) {
		boolean bool = udService.stop(userId);
		JSONObject object = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(object.toJSONString());
	}

	@RequestMapping("/start")
	private void start(int userId) {
		boolean bool = udService.start(userId);
		JSONObject object = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(object.toJSONString());
	}

	@RequestMapping("/selectUserBy")
	private ModelAndView selectUserBy(String name) {
		ModelAndView model = new ModelAndView("manager/distribution_userShow");
		UserDistribution user = new UserDistribution();
		user.setName(name);
		user.setPhone(name);
		user.setNo(name);
		List<UserDistribution> udList = udService.selectUserBy(user);
		model.addObject("udList", udList);
		model.addObject("count", udList.size());
		return model;
	}

	@RequestMapping("/deleteById")
	private void deleteById(int userId) {
		boolean bool = udService.deleteById(userId);
		JSONObject object = this.createJSONResult(0, String.valueOf(bool));
		this.writeJSON(object.toJSONString());
	}
}
