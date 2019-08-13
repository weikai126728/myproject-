package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.MallProductParameter;

@Repository
public interface IMallProductParameterDao {
	/**
	 * 新建规格
	 * @param param
	 * @throws Exception
	 */
	void insert(MallProductParameter param)throws Exception;
	/**
	 * 查找制定商品的最低现价参数
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	MallProductParameter fetchLowerPriceByProId(@Param("proId")String proId)throws Exception;
	/**
	 * 根据商品id对规格进行分组
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	List<String> groupBySecondParam(@Param("proId")String proId)throws Exception;
	/**
	 * 根据商品id对口味进行分组
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	List<String> groupByFirstParam(@Param("proId")String proId)throws Exception;
	/**
	 * 查找指定商品的所有参数
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	List<MallProductParameter> findByProductId(@Param("productId")String productId)throws Exception;
	/**
	 * 设置状态
	 * @param status
	 * @param paramId
	 * @throws Exception
	 */
	void updateStatus(@Param("status")Integer status,@Param("paramId")String paramId)throws Exception;
	/**
	 * 查找同级参数
	 * @param paramId
	 * @return
	 * @throws Exception
	 */
	List<MallProductParameter> findSameLevel(@Param("paramId")String paramId)throws Exception;
	/**
	 * 根据id删除数据，只能删除禁用状态下的数据
	 * @param paramId
	 * @throws Exception
	 */
	void deleteById(@Param("paramId")String paramId)throws Exception;
	MallProductParameter fetchById(@Param("paramId")String paramId)throws Exception;
	void update(MallProductParameter param)throws Exception;
	List<MallProductParameter> findAll()throws Exception;
}
