package com.abbot.schimneylife.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.user.Role;

@Repository
public interface IRoleDao {

	/**
	 * 指定角色范围分组统计用户数
	 * @param level
	 * @return
	 * @throws Exception
	 */
	List<Role> groupByRoleLessThan(@Param("level")Integer level)throws Exception;
	/**
	 * 根据level查找角色
	 * @param level
	 * @return
	 * @throws Exception
	 */
	List<Role> findByLevelLessThan(@Param("level")Integer level)throws Exception;
	/**
	 * 根据level查找角色
	 * @param level
	 * @return
	 * @throws Exception
	 */
	List<Role> findByLevelGreaterThan(@Param("level")Integer level)throws Exception;
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Role> findAll()throws Exception;
	/**
	 * 新增角色
	 * @param role
	 * @throws Exception
	 */
	void insert(Role role)throws Exception;
	/**
	 * 修改角色
	 * @param role
	 * @throws Exception
	 */
	void update(Role role)throws Exception;
	/**
	 * 删除角色
	 * @param roleId
	 * @throws Exception
	 */
	void delete(Integer roleId)throws Exception;
	/**
	 * 查询除了商超管理员和会员
	 * @return
	 * @throws Exception
	 */
	List<Role> groupByNoMarketAndMember()throws Exception;
	/**
	 *  查询除了商超管理员和会员
	 * @return
	 * @throws Exception
	 */
	List<Role> findByNoMarketAndMember()throws Exception;
}
