package com.abbot.schimneylife.dao.fenxiao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.fenxiao.ProductCateDistribution;

@Repository
public interface IProductCateDistributionDao {

	List<ProductCateDistribution> selectProCate() throws Exception;
	
	ProductCateDistribution fetchById(@Param("id") Integer id)throws Exception;
	
	Integer addPro(ProductCateDistribution pro)throws Exception;
	
	void delete(@Param("id")Integer id)throws Exception;
	
	Integer updatePro(@Param("id") Integer id,@Param("name")String name)throws Exception;
}
