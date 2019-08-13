package com.abbot.schimneylife.service.fenxiao;

import java.util.List;

import com.abbot.schimneylife.pojo.fenxiao.ProductCateDistribution;
import com.abbot.schimneylife.pojo.fenxiao.ProductDistribution;
import com.abbot.schimneylife.pojo.shopping.MallProduct;

public interface ProductDistributionService {

	List<ProductDistribution> hasmore(Integer proCateId);

	Integer totalCount();// 商品总数量

	boolean delete(Integer proId);
	
	boolean upload(ProductDistribution pro);
	
	boolean update(ProductDistribution pro);
	
	ProductDistribution toEdit(Integer proId);
	/**
	 * 根据分类分页查询商品
	 * 
	 * @param typeId
	 *            商品分类id
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<ProductDistribution> findByPageAndType(String like, String order, String sort, String typeId, Integer firstResult,
			Integer pageSize);
	
	/**
	 * 根据分类统计数量
	 * @param like
	 * @param typeId
	 * @return
	 */
	Integer countByType(String like,String typeId);
}
