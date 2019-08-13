package com.abbot.schimneylife.dao.user;

import org.apache.ibatis.annotations.Param;

public interface IUserToRoleDao {
	/**
	 * 添加角色
	 * 
	 * @param id
	 * @throws Exception
	 */
 

	void addRelation(@Param("userId") Integer userId, @Param("roleId") Integer roleId) throws Exception;

	void delete(@Param("userId") Integer userId) throws Exception;

	void update(@Param("userId") Integer userId, @Param("roleId") Integer roleId) throws Exception;
	Integer countByRoleId(Integer roleId)throws Exception;
}
