package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.shopping.IRadioDao;
import com.abbot.schimneylife.pojo.shopping.Radio;
import com.abbot.schimneylife.service.shopping.RadioService;
import com.abbot.schimneylife.util.CommonKey;
@Service
public class RadioServiceImpl implements RadioService {
	private static final Logger logger = Logger.getLogger(RadioServiceImpl.class);
	
	@Resource
	private IRadioDao radioDao;
	@Override
	public boolean update(Radio radio) {
		try {
			radioDao.update(radio);
			return true;
		} catch (Exception e) {
			logger.error("修改广播消息",e);
			return false;
		}
		
	}

	@Override
	public boolean insert(Radio radio) {
		try {
			radioDao.insert(radio);
			return true;
		} catch (Exception e) {
			logger.error("新增广播消息",e);
			return false;
		}
	}

	@Override
	public List<Radio> findAllShow() {
		List<Radio> radioList = Collections.emptyList();
		try {
			radioList = radioDao.findAllShow();
		} catch (Exception e) {
			logger.error("查找所有可展示信息",e);
		}
		return radioList;
	}

	@Override
	public List<Radio> findByPage(String like, String order, Integer firstResult, Integer pageSize) {
		List<Radio> radioList = Collections.emptyList();
		try {
			radioList = radioDao.findByPage(like, order, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据条件分页查询",e);
		}
		return radioList;
	}

	@Override
	public Integer countTotal(String like){
		try {
			return radioDao.countTotal(like);
		} catch (Exception e) {
			logger.error("根据条件统计数量",e);
			return 0;
		}
	}

	@Override
	public boolean disable(String id) {
		Radio radio = new Radio();
		radio.setId(id);
		radio.setFlag(CommonKey.DISABLE_FLAG);
		try {
			radioDao.update(radio);
			return true;
		} catch (Exception e) {
			logger.error("禁用消息",e);
			return false;
		}
	}

	@Override
	public boolean enable(String id) {
		Radio radio = new Radio();
		radio.setId(id);
		radio.setFlag(CommonKey.ENABLE_FLAG);
		try {
			radioDao.update(radio);
			return true;
		} catch (Exception e) {
			logger.error("启用消息 ",e);
			return false;
		}
	}

	@Override
	public boolean delete(String id) {
		try {
			radioDao.delete(id);
			return true;
		} catch (Exception e) {
			logger.error("删除消息",e);
			return false;
		}
	}

	@Override
	public Radio findById(String id) {
		try {
			return radioDao.findById(id);
		} catch (Exception e) {
			logger.error("",e);
			return new Radio();
		}
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void batchDelete(String[] ids) throws Exception {
		for(String id:ids) {
			radioDao.delete(id);
		}
	}

}
