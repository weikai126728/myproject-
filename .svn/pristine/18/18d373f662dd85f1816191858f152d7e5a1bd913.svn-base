package com.abbot.schimneylife.serviceImpl.user;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.user.IRoleDao;
import com.abbot.schimneylife.dao.user.IUserToRoleDao;
import com.abbot.schimneylife.pojo.user.Role;
import com.abbot.schimneylife.service.user.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	
	private static final Logger logger = Logger.getLogger(RoleServiceImpl.class);
	
	@Resource
	private IRoleDao roleDao;
	@Resource
	private IUserToRoleDao toDao;
	@Override
	public List<Role> groupByRoleLessThan(Integer level) {
		List<Role> roleList = Collections.emptyList();
		try {
			roleList = roleDao.groupByRoleLessThan(level);
		} catch (Exception e) {
			logger.error("指定角色范围分组统计用户数",e);
		}
		return roleList;
	}
	@Override
	public List<Role> findByLevelLessThan(Integer level) {
		List<Role> roleList = Collections.emptyList();
		try {
			roleList = roleDao.findByLevelLessThan(level);
		} catch (Exception e) {
			logger.error("根据level查找角色",e);
		}
		return roleList;
	}
	@Override
	public List<Role> findByLevelGreaterThan(Integer level) {
		List<Role> roleList = Collections.emptyList();
		try {
			roleList = roleDao.findByLevelGreaterThan(level);
		} catch (Exception e) {
			logger.error("根据level查找角色",e);
		}
		return roleList;
	}
	@Override
	public List<Role> findAll() {
		List<Role> roleList = Collections.emptyList();
		try {
			roleList = roleDao.findAll();
		} catch (Exception e) {
			logger.error("查询所有角色",e);
		}
		return roleList;
	}
	@Override
	public boolean addRole(Role role) {
		try {
			roleDao.insert(role);
			return true;
		} catch (Exception e) {
			logger.error("新增角色",e);
			return false;
		}
	}
	@Override
	public boolean updateRole(Role role) {
		try {
			roleDao.update(role);
			return true;
		} catch (Exception e) {
			logger.error("修改角色异常",e);
			return false;
		}
	}
	@Override
	public Integer counUserByRoleId(Integer roleId) {
		try {
			return toDao.countByRoleId(roleId);
		} catch (Exception e) {
			logger.error("统计指定角色下的用户数量",e);
			return 0;
		}
	}
	@Override
	public boolean delete(Integer roleId) {
		try {
			roleDao.delete(roleId);
			return true;
		} catch (Exception e) {
			logger.error("删除角色",e);
			return false;
		}
	}
	@Override
	public List<Role> groupByNoMarketAndMember() {
		List<Role> roleList = Collections.emptyList();
		try {
			roleList = roleDao.groupByNoMarketAndMember();
		} catch (Exception e) {
			logger.error("查询除了商超管理员和会员",e);
		}
		return roleList;
	}
	@Override
	public List<Role> findByNoMarketAndMember() {
		List<Role> roleList = Collections.emptyList();
		try {
			roleList = roleDao.findByNoMarketAndMember();
		} catch (Exception e) {
			logger.error("查询除了商超管理员和会员",e);
		}
		return roleList;
	}

	
}
