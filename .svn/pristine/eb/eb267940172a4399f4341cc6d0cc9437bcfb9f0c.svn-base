package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.CustomerOrderWarn;

public interface CustomerOrderWarnService {

	List<CustomerOrderWarn> findByPage(String like,String createTime,String sort,Integer firstResult,Integer pageSize);
	Integer countTotal(String like,String createTime);
	boolean insert(Integer customerId,String orderId);
}
