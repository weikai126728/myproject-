package com.abbot.schimneylife.service.weixin;

import java.util.List;

import com.abbot.schimneylife.pojo.weixin.Alliance;
import com.abbot.schimneylife.pojo.weixin.Mcars;

public interface MembersService {
	List<Alliance> findByPage(Integer firstResult,Integer pageSize,String like,String column,String sort,String createTime);

	List<Mcars> findByalopenid(Integer firstResult,Integer pageSize,String search,String alopenid);
	Integer countTotal(String like,String startTime,String endTime,String alopenid);
}
