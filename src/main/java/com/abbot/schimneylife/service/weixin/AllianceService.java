package com.abbot.schimneylife.service.weixin;

import java.util.List;

import com.abbot.schimneylife.pojo.weixin.Alliance;

public interface AllianceService {

	List<Alliance> findByPage(Integer firstResult,Integer pageSize,String like,String column,String sort,String createTime);
	Integer countTotal(String like,String createTime);
	List<Integer> findIdsByUserId(Integer userId);
	void updateRel(Integer[] alids,Integer userId)throws Exception;
	Alliance fetchByNumber(String product_id);
	/**
	 * 查找指定角色等级没有分配的加盟商超列表
	 * @param userId
	 * @param level
	 * @return
	 */
	List<Alliance> findAllNotAllocation(Integer userId,Integer level);
	Integer countUser(String product_id);
	boolean updatefzoff(String product_id);
}
