package com.abbot.schimneylife.service.user;

import java.util.List;

import com.abbot.schimneylife.pojo.user.Role;

public interface RoleService {

	/**
	 * 指定角色范围分组统计用户数
	 * @param level
	 * @return
	 * @throws Exception
	 */
	List<Role> groupByRoleLessThan(Integer level);
	/**
	 * 根据level查找角色
	 * @param level
	 * @return
	 */
	List<Role> findByLevelLessThan(Integer level);
	/**
	 * 根据level查找角色
	 * @param level
	 * @return
	 */
	List<Role> findByLevelGreaterThan(Integer level);
	/**
	 * 查询所有角色
	 * @return
	 */
	List<Role> findAll();
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	boolean addRole(Role role);
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	boolean updateRole(Role role);
	/**
	 *统计指定角色下的用户数量
	 * @param roleId
	 * @return
	 */
	Integer counUserByRoleId(Integer roleId);
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	boolean delete(Integer roleId);
	/**
	 * 查询除了商超管理员和会员
	 * @return
	 */
	List<Role> groupByNoMarketAndMember();
	/**
	 * 查询除了商超管理员和会员
	 * @return
	 */
	List<Role> findByNoMarketAndMember();
}
