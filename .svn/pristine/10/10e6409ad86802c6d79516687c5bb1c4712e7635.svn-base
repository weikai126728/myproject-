package com.abbot.schimneylife.dao.fenxiao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.fenxiao.CommissionDistribution;
import com.abbot.schimneylife.pojo.fenxiao.FinancialDistribution;

@Repository
public interface ICommissionDistributionDao {

	List<CommissionDistribution> selectCommission() throws Exception;

	List<CommissionDistribution> selectCommissionBy(@Param("name") String name) throws Exception;

	Integer totalCount() throws Exception;

	Integer countByType(@Param("like") String like, @Param("typeId") String typeId) throws Exception;

	List<CommissionDistribution> findByPageAndType( @Param("order") String order,
			@Param("sort") String sort,  @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize) throws Exception;
}