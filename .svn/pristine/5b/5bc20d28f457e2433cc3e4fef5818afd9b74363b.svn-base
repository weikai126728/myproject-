package com.abbot.schimneylife.serviceImpl.shopping;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.IAlibabaOrderDao;
import com.abbot.schimneylife.pojo.shopping.AlibabaOrder;
import com.abbot.schimneylife.service.shopping.AlibabaOrderService;
@Service
public class AlibabaOrderServiceImpl implements AlibabaOrderService {

	private static final Logger logger = Logger.getLogger(AlibabaOrderServiceImpl.class);
	@Resource
	private IAlibabaOrderDao alibabaOrderDao;
	@Override
	public AlibabaOrder fetchByCustomerOrderId(String customerOrderId) {
		try {
			return alibabaOrderDao.fetchByCustomerOrderId(customerOrderId);
		} catch (Exception e) {
			logger.error("根据customerorderId 查找数据",e);
			return null;
		}
	}

}
