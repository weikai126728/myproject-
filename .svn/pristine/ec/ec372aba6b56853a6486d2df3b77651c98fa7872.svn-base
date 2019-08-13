package com.abbot.schimneylife.dao.weixin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.weixin.Bonus;

@Repository
public interface IBonusDao {

	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	List<Bonus> findByPage(String product_id,String startTime,String endTime,String search,Integer firstResult,Integer pageSize)throws Exception;
	
	/**
	 * 统计数量
	 * @return
	 * @throws Exception
	 */
	Integer totalCount(String product_id,String startTime,String endTime,String search)throws Exception;
}
