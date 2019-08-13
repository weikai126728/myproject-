package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.shopping.ITidingsDao;
import com.abbot.schimneylife.pojo.shopping.Tidings;
import com.abbot.schimneylife.service.shopping.TidingsService;
import com.abbot.schimneylife.util.CommonKey;

@Service
public class TidingsServiceImpl implements TidingsService{
	private static final Logger logger = Logger.getLogger(TidingsServiceImpl.class);
	
	@Resource
	private ITidingsDao tidingsDao;
	
	@Override
	public void findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		System.out.println("userId:::"+userId);
	}

	@Override
	public boolean add(Tidings tidings) {
		try {
			tidingsDao.insert(tidings);
			return true;
		} catch (Exception e) {
			logger.error("添加消息",e);
			return false;
		}
	}

	@Override
	public boolean update(Tidings tidings) {
		try {
			tidingsDao.update(tidings);
			return true;
		} catch (Exception e) {
			logger.error("修改",e);
			return false;
		}
	}

	@Override
	public boolean delete(String id) {
		try {
			tidingsDao.delete(id);
			return true;
		} catch (Exception e) {
			logger.error("删除",e);
			return false;
		}
	}

	@Override
	public Tidings findById(String id) {
		try {
			return tidingsDao.findById(id);
		} catch (Exception e) {
			logger.error("根据id查询",e);
			return new Tidings();
		}
	}

	@Override
	public List<Tidings> findByPage(Integer firstResult, Integer pageSize, String like, String order) {
		List<Tidings> list = Collections.emptyList();
		try {
			list =tidingsDao.findByPage(firstResult, pageSize, like, order);
		} catch (Exception e) {
			logger.error("分页查询",e);
		}
		return list;
	}

	@Override
	public Integer coutTotal(String like) {
		try {
			return tidingsDao.countTotal(like);
		} catch (Exception e) {
			logger.error("统计总数",e);
			return 0;
		}
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void batchDelete(String[] ids) throws Exception {
		for(String id:ids) {
			tidingsDao.delete(id);
		}
	}

	@Override
	public boolean disable(String id){
		Tidings tidings = new Tidings();
		tidings.setId(id);
		tidings.setFlag(CommonKey.DISABLE_FLAG);
		try {
			tidingsDao.update(tidings);
			return true;
		} catch (Exception e) {
			logger.error("禁用消息",e);
			return false;
		}
	}

	@Override
	public boolean enable(String id){
		Tidings tidings = new Tidings();
		tidings.setId(id);
		tidings.setFlag(CommonKey.ENABLE_FLAG);
		try {
			tidingsDao.update(tidings);
			return true;
		} catch (Exception e) {
			logger.error("启用消息",e);
			return false;
		}
	}

	@Override
	public List<Tidings> findAllShow() {
		List<Tidings> list = Collections.emptyList();
		try {
			list = tidingsDao.findAllShow();
		} catch (Exception e) {
			logger.error("查询所有可展示消息",e);
		}
		return list;
	}

	@Override
	public Integer countAllShow() {
		try {
			return tidingsDao.countAllShow();
		} catch (Exception e) {
			logger.error("统计所有可展示消息数量",e);
			return 0;
		}
	}

	@Override
	public List<Tidings> findAfter(String time) {
		List<Tidings> list = Collections.emptyList();
		try {
			list = tidingsDao.findAfter(time);
		} catch (Exception e) {
			logger.error("查询指定时间后的消息",e);
		}
		return list;
	}

	@Override
	public Integer countAfter(String time) {
		try {
			return tidingsDao.countAfter(time);
		} catch (Exception e) {
			logger.error("统计指定时间后的消息数量",e);
			return 0;
		}
	}

	
}
