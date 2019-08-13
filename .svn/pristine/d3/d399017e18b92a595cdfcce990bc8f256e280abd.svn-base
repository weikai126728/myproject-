package com.abbot.schimneylife.dao.shopping;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.MallProductInfo;

@Repository
public interface IMallProductInfoDao {

	/**
	 * 添加详情图片
	 * @param proInfo
	 * @throws Exception
	 */
	void insert(MallProductInfo proInfo)throws Exception;
	/**
	 * 根据商品id查找详情图片
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	MallProductInfo fetchByProId(@Param("proId")String proId)throws Exception;
	/**
	 * 根据商品id删除数据
	 * @param proId
	 * @throws Exception
	 */
	void deleteByProId(@Param("proId")String proId)throws Exception;
	void update(MallProductInfo info)throws Exception;
}
