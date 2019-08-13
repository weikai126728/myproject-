package com.abbot.schimneylife.service.user;

import java.util.List;

import com.abbot.schimneylife.pojo.user.Authority;

public interface AuthorityService {

	boolean insert(Integer pid,String name,String describe,Integer order,String uri);
	List<Authority> findAllFather();
	/**
	 * 根据roleId查找所有关联权限的id
	 * @param roleId
	 * @return
	 */
	List<Integer> findByRoleId(Integer roleId);
	/**
	 * 重新分配角色和权限的关联关系
	 * @param roleId
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	void allocation(Integer roleId,Integer[] ids)throws Exception;
	/**
	 * 根据角色id查找关联的所有权限
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	List<Authority> findByRole(Integer roleId);
}
