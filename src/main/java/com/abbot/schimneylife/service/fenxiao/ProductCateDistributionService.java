package com.abbot.schimneylife.service.fenxiao;

import java.util.List;

import com.abbot.schimneylife.pojo.fenxiao.ProductCateDistribution;

public interface ProductCateDistributionService {

	List<ProductCateDistribution> selectProCate();
	
	ProductCateDistribution fetchById(Integer id);
	
	boolean addPro(ProductCateDistribution pro);
	
	boolean delete(Integer id);
	
	boolean updatePro(String name,Integer id);
}
