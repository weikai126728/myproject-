package com.abbot.schimneylife.dao.fenxiao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.fenxiao.ProductCateDistribution;
import com.abbot.schimneylife.pojo.fenxiao.ProductDistribution;
import com.abbot.schimneylife.pojo.shopping.MallProduct;

@Repository
public interface IProductDistributionDao {

	List<ProductDistribution> hasmore(@Param("proCateId") Integer proCateId) throws Exception;

	Integer totalCount() throws Exception;

	void delete(@Param("id")Integer proId) throws Exception;
	
	Integer upload(ProductDistribution pro) throws Exception;
	
	Integer update(ProductDistribution pro) throws Exception;
	
	ProductDistribution toEdit(@Param("id")Integer proId) throws Exception;
	/**
	 * 根据分类统计数量
	 * 
	 * @param like
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	Integer countByType(@Param("like") String like, @Param("typeId") String typeId) throws Exception;
	
	/**
	 * 根据分类分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param typeId 商品分类id
	 * @return
	 * @throws Exception
	 */
	List<ProductDistribution> findByPageAndType(@Param("like")String like,@Param("order")String order,@Param("sort")String sort
			,@Param("typeId")String typeId,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
}
