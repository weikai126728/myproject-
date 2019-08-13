package com.abbot.schimneylife.dao.fenxiao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.fenxiao.FinancialDistribution;
import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;

@Repository
public interface IFinancialDistributionDao {

	List<FinancialDistribution> selectFinancial() throws Exception;

	List<FinancialDistribution> selectFinancialBy(@Param("name") String name) throws Exception;

	Integer totalCount() throws Exception;

 	List<FinancialDistribution> findByPageAndType( @Param("order") String order,
			@Param("sort") String sort,  @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize) throws Exception;
}