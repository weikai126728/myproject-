package com.abbot.schimneylife.service.fenxiao;

import java.util.List;

import com.abbot.schimneylife.pojo.fenxiao.FinancialDistribution;
import com.abbot.schimneylife.pojo.fenxiao.WithdrawDistribution;

public interface FinancialDistributionService {

	List<FinancialDistribution> selectFinancial();
	List<FinancialDistribution> selectFinancialBy(String name);
	Integer totalCount(); 

	List<FinancialDistribution> findByPageAndType( String order, String sort,
			Integer firstResult, Integer pageSize);
 
}
