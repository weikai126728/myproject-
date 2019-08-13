package com.abbot.schimneylife.dao.shopping;

import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.SupermarketAddress;

@Repository
public interface ISupermarketAddressDao {

	void insert(SupermarketAddress address)throws Exception;
	void update(SupermarketAddress address)throws Exception;
}
