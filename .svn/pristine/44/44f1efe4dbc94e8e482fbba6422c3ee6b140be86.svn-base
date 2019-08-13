package com.abbot.schimneylife.dao.weixin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.weixin.Alliance;

@Repository
public interface IAllianceDao {

	List<Alliance> findByPage(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize
			,@Param("like")String like,@Param("column")String column,@Param("sort")String sort,@Param("createTime")String createTime)throws Exception;
	Integer countTotal(@Param("like")String like,@Param("createTime")String createTime)throws Exception;
	List<Integer> findIdsByUserId(@Param("userId")Integer userId)throws Exception;
	void deleteRelByUserId(@Param("userId")Integer userId)throws Exception;
	void insertRel(@Param("userId")Integer userId,@Param("alid")Integer alid)throws Exception;
	Alliance fetchByNumber(@Param("product_id")String product_id)throws Exception;
	Alliance fetchByOpenId(@Param("openId")String openId)throws Exception;
	/**
	 * 查找指定角色等级没有分配的加盟商超列表
	 * @param userId
	 * @param level
	 * @return
	 * @throws Exception
	 */
	List<Alliance> findAllNotAllocation(@Param("userId")Integer userId,@Param("level")Integer level)throws Exception;
	/**
	 * 查询商户推广的会员数量
	 */
	Integer countUser(@Param("product_id")String product_id)throws Exception;
	
	void updatefz(@Param("product_id")String product_id)throws Exception;
	void updatefzOff(@Param("product_id")String product_id)throws Exception;
}
