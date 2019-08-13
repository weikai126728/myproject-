package com.abbot.schimneylife.dao.weixin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.weixin.AllianceCommission;

@Repository
public interface IAllianceCommissionDao {

	/**
	 * 根据商家编号查询数据
	 * @param product_id
	 * @return
	 * @throws Exception
	 */
	List<AllianceCommission> findByProductId(@Param("product_id")String product_id)throws Exception;
	/**
	 * 根据商品编号删除数据
	 * @param product_id
	 * @throws Exception
	 */
	void deleteByProductId(@Param("product_id")String product_id)throws Exception;
	/**
	 * 新增数据
	 * @param ac
	 * @throws Exception
	 */
	void insert(AllianceCommission ac)throws Exception;
}
