package com.abbot.schimneylife.dao.shopping;

import org.apache.ibatis.annotations.Param;

import com.abbot.schimneylife.pojo.shopping.MallProductAlibaba;

public interface IMallProductAlibabaDao {

	/**
	 * 添加阿里关联数据
	 * @param productID
	 * @param specId
	 * @param parameterId
	 */
	void insert(@Param("productID")String productID,@Param("specId")String specId
			,@Param("parameterId")String parameterId)throws Exception;
	/**
	 * 删除阿里关联数据
	 * @param parameterId
	 * @throws Exception
	 */
	void delete(@Param("parameterId")String parameterId)throws Exception;
	/**
	 * 根据parameterId修改数据
	 * @param parameterId
	 * @param productID
	 * @param specId
	 * @throws Exception
	 */
	void update(@Param("parameterId")String parameterId,@Param("productID")String productID,@Param("specId")String specId)throws Exception;
	/**
	 * 根据paramId 查找对应数据
	 * @param paramId
	 * @return
	 * @throws Exception
	 */
	MallProductAlibaba fetchByParamId(@Param("paramId")String paramId)throws Exception;
	/**
	 *根据商品id和规格id查找
	 * @param productID
	 * @param specId
	 * @return
	 * @throws Exception
	 */
	MallProductAlibaba fetchByProductIDAndSpecID(@Param("productID")String productID,@Param("specId")String specId)throws Exception;
}
