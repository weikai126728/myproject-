package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.MallHomeBanner;

/**
 * 首页轮播图
 * @author Administrator
 *
 */
@Repository
public interface IMallHomeBannerDao {

	void insert(MallHomeBanner banner)throws Exception;
	/**
	 * id=1移动
	 * @param id
	 * @param images
	 * @throws Exception
	 */
	void updateImage(@Param("id")String id,@Param("images")String images)throws Exception;
	
	void updatePath(@Param("id")String id,@Param("path")String path)throws Exception;
	MallHomeBanner fetchById(@Param("id")String id)throws Exception;
	List<MallHomeBanner> findByType(Integer type)throws Exception;
	void delete(@Param("id")String id)throws Exception;
}
