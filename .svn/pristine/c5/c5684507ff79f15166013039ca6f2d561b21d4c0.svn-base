package com.abbot.schimneylife.service.fenxiao;

import java.util.List;

import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.fenxiao.WithdrawDistribution;

public interface WithdrawDistributionService {

	List<WithdrawDistribution> selectWithdraw();

	List<WithdrawDistribution> selectWithdrawBy(String name);

	boolean update(Integer id);

	boolean delete(Integer id);

	Integer totalCount(); 

	List<WithdrawDistribution> findByPageAndType( String order, String sort,
			Integer firstResult, Integer pageSize);

	Integer countByType(String like, String typeId);
}
