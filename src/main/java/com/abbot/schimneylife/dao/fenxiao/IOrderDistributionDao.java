package com.abbot.schimneylife.dao.fenxiao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.fenxiao.ProductCateDistribution;
import com.abbot.schimneylife.pojo.fenxiao.ProductDistribution;

@Repository
public interface IOrderDistributionDao {

	void deleteById(@Param("id") Integer id) throws Exception;

	List<OrdersDistribution> selectOrder() throws Exception;

	List<OrdersDistribution> selectOrderBy(@Param("name") String name) throws Exception;

	Integer totalCount() throws Exception;
	  
	List<OrdersDistribution> findByPageAndType( @Param("order") String order,
			@Param("sort") String sort,  @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize) throws Exception;

}