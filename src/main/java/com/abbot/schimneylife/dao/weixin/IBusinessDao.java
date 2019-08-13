package com.abbot.schimneylife.dao.weixin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.weixin.BusinessType;

@Repository
public interface IBusinessDao {
	
	/**
	 * 新增数据
	 * @param type
	 * @throws Exception
	 */
	void insert(BusinessType type)throws Exception;
	/**
	 * 修改数据
	 * @param type
	 * @throws Exception
	 */
	void update(BusinessType type)throws Exception;
	/**
	 * 根据id删除数据
	 * @param id
	 * @throws Exception
	 */
	void delete(@Param("id")Integer id)throws Exception;
	/**
	 * 查询所有类型
	 * @return
	 * @throws Exception
	 */
	List<BusinessType> findAll()throws Exception;

}
