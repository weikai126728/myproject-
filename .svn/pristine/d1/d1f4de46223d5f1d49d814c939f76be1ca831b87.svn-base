package com.abbot.schimneylife.dao.shopping;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.MallProductBanner;

@Repository
public interface IMallProductBannerDao {

	/**
	 * 查找指定商品的轮播图
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	List<MallProductBanner> findByProId(@Param("proId")String proId)throws Exception;
	/**
	 * 新增轮播图
	 * @param banner
	 * @throws Exception
	 */
	void insert(MallProductBanner banner)throws Exception;
	/**
	 * 根据商品id删除数据
	 * @param proId
	 * @throws Exception
	 */
	void deleteByProId(@Param("proId")String proId)throws Exception;
	void deleteNotInImages(Map<String,Object> map)throws Exception;
}
