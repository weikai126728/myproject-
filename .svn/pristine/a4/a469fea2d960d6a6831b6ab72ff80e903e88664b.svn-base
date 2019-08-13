package com.abbot.schimneylife.dao.weixin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.weixin.Commission;

@Repository
public interface ICommissionDao {

	/**
	 * 新增佣金比例数据
	 * @param commission
	 * @throws Exception
	 */
	void insert(Commission commission)throws Exception;
	/**
	 *根据id删除佣金比例数据 
	 * @param id
	 * @throws Exception
	 */
	void delete(@Param("id")Integer id)throws Exception;
	/**
	 * 修改佣金比例数据
	 * @param commission
	 * @throws Exception
	 */
	void update(Commission commission)throws Exception;
	/**
	 * 根据条件分页查询
	 * @param search
	 * @param typeId
	 * @param modelId
	 * @param order
	 * @param sort
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<Commission> findByPage(@Param("search")String search,@Param("typeId")Integer typeId
			,@Param("modelId")Integer modelId,@Param("order")String order,@Param("sort")String sort,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 根据类型id和加盟方式id查找佣金比例
	 * @param typeId
	 * @param modelId
	 * @return
	 * @throws Exception
	 */
	Commission fetchByTypeAndModel(@Param("typeId")Integer typeId,@Param("modelId")Integer modelId)throws Exception;
	/**
	 * 根据条件统计数量
	 * @param search
	 * @param typeId
	 * @param modelId
	 * @return
	 * @throws Exception
	 */
	Integer totalCount(@Param("search")String search,@Param("typeId")Integer typeId
			,@Param("modelId")Integer modelId)throws Exception;
	/**
	 * 根据条件查询佣金比例
	 * @param typeId
	 * @param modelId
	 * @param zipcode
	 * @return
	 * @throws Exception
	 */
	Integer fetchByCondition(@Param("typeId")Integer typeId,@Param("modelId")Integer modelId,@Param("zipcode")String zipcode)throws Exception;
	/**
	 * 根据条件查询私有可执行佣金比例
	 * @param typeId
	 * @param product_id
	 * @return
	 * @throws Exception
	 */
	Integer fetchPriByCondition(@Param("typeId")Integer typeId,@Param("product_id")String product_id)throws Exception;
}
