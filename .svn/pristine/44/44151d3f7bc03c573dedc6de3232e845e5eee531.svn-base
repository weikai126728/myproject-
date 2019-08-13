package com.abbot.schimneylife.dao.weixin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.abbot.schimneylife.pojo.weixin.Alliance;
import com.abbot.schimneylife.pojo.weixin.Mcars;

public interface IMembersDao {

	List<Alliance> findByPage(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize
			,@Param("like")String like,@Param("column")String column,@Param("sort")String sort,@Param("createTime")String createTime)throws Exception;

	List<Mcars> findByalopenid(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize,@Param("like")String like,@Param("alopenid")String alopenid)throws Exception;

	Integer countTotal(@Param("like")String like,@Param("alopenid")String alopenid)throws Exception;
}
