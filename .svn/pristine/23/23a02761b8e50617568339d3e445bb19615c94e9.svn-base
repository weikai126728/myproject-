package com.abbot.schimneylife.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.user.Authority;

@Repository
public interface IAuthorityDao {

	/**
	 * 新增权限
	 * @param pid
	 * @param name
	 * @param descript
	 * @param order
	 * @param uri
	 * @param author
	 * @param createTime
	 * @throws Exception
	 */
	void insert(@Param("pid")Integer pid,@Param("name")String name,@Param("describe")String describe
			,@Param("order")Integer order,@Param("uri")String uri,@Param("author")String author
			,@Param("createTime")String createTime)throws Exception;
	/**
	 * 修改权限
	 * @param authority
	 * @throws Exception
	 */
	void update(Authority authority)throws Exception;
	/**
	 * 删除
	 * @param id
	 * @param pid
	 * @throws Exception
	 */
	void delete(@Param("id")Integer id,@Param("pid")Integer pid)throws Exception;
	/**
	 * 分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param author
	 * @return
	 * @throws Exception
	 */
	List<Authority> findByPage(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize,@Param("author")String author)throws Exception;
	/**
	 * 统计数量
	 * @param author
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(@Param("param")String author)throws Exception;
	/**
	 * 根据pid查询所有集合
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<Authority> findByPid(@Param("id")Integer id)throws Exception;
	/**
	 * 查询所有一级功能列表
	 * @return
	 * @throws Exception
	 */
	List<Authority> findAllFather()throws Exception;
	/**
	 * 根据roleId查找所有关联权限的id
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	List<Integer> findByRoleId(@Param("roleId")Integer roleId)throws Exception;
	/**
	 * 删除指定角色的关联关系
	 * @param roleId
	 * @throws Exception
	 */
	void deleteRelationByRoleId(@Param("roleId")Integer roleId)throws Exception;
	/**
	 * 新增角色和权限的关联关系
	 * @param roleId
	 * @param authorityId
	 * @throws Exception
	 */
	void insertRelation(@Param("roleId")Integer roleId,@Param("authorityId")Integer authorityId)throws Exception;
	/**
	 * 根据角色id查找关联的所有权限
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	List<Authority> findByRole(@Param("roleId")Integer roleId)throws Exception;
}
