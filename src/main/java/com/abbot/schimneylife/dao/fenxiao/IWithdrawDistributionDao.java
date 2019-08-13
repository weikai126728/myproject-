package com.abbot.schimneylife.dao.fenxiao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.fenxiao.WithdrawDistribution;

@Repository
public interface IWithdrawDistributionDao {

	List<WithdrawDistribution> selectWithdraw() throws Exception;

	List<WithdrawDistribution> selectWithdrawBy(@Param("name") String name) throws Exception;

	boolean update(@Param("id") Integer id) throws Exception;

	boolean delete(@Param("id") Integer id) throws Exception;

	Integer totalCount() throws Exception;

	Integer countByType(@Param("like") String like, @Param("typeId") String typeId) throws Exception;

	List<WithdrawDistribution> findByPageAndType( @Param("order") String order,
			@Param("sort") String sort,  @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize) throws Exception;
}