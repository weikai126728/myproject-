package com.abbot.schimneylife.service.fenxiao;

import java.util.List;

import com.abbot.schimneylife.pojo.fenxiao.CommissionDistribution;
import com.abbot.schimneylife.pojo.fenxiao.FinancialDistribution;

public interface CommissionDistributionService {

	List<CommissionDistribution> selectCommission();

	List<CommissionDistribution> selectCommissionBy(String name);
	Integer totalCount(); 

	List<CommissionDistribution> findByPageAndType( String order, String sort,
			Integer firstResult, Integer pageSize);

	Integer countByType(String like, String typeId);
}
