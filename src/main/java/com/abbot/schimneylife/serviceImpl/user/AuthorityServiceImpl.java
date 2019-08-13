package com.abbot.schimneylife.serviceImpl.user;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.user.IAuthorityDao;
import com.abbot.schimneylife.pojo.user.Authority;
import com.abbot.schimneylife.service.user.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService {

	private static final Logger logger = Logger.getLogger(AuthorityServiceImpl.class);
	
	@Resource
	private IAuthorityDao authorityDao;
	@Override
	public boolean insert(Integer pid, String name, String describe, Integer order, String uri) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Authority> findAllFather() {
		List<Authority> list = Collections.emptyList();
		try {
			list = authorityDao.findAllFather();
		} catch (Exception e) {
			logger.error("查询所有一级功能列表异常！",e);
		}
		return list;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void allocation(Integer roleId, Integer[] ids) throws Exception {
		authorityDao.deleteRelationByRoleId(roleId);
		for(Integer id:ids) {
			authorityDao.insertRelation(roleId, id);
		}
	}

	@Override
	public List<Integer> findByRoleId(Integer roleId) {
		List<Integer> list = Collections.emptyList();
		try {
			list = authorityDao.findByRoleId(roleId);
		} catch (Exception e) {
			logger.error("根据roleId查找所有关联权限的id",e);
		}
		return list;
	}

	@Override
	public List<Authority> findByRole(Integer roleId) {
		List<Authority> list = Collections.emptyList();
		try {
			list = authorityDao.findByRole(roleId);
		} catch (Exception e) {
			logger.error("根据角色id查找关联的所有权限",e);
		}
		return list;
	}

}
