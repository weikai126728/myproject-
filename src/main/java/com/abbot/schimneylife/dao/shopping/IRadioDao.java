package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.Radio;

@Repository
public interface IRadioDao {

	/**
	 * 新增广播消息
	 * @param radio
	 * @throws Exception
	 */
	void insert(Radio radio)throws Exception;
	/**
	 * 修改广播消息
	 * @param radio
	 * @throws Exception
	 */
	void update(Radio radio)throws Exception;
	/**
	 * 查找所有可展示信息
	 * @return
	 * @throws Exception
	 */
	List<Radio> findAllShow()throws Exception;
	/**
	 * 根据条件分页查询
	 * @param like
	 * @param order
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<Radio> findByPage(@Param("like")String like,@Param("order")String order,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 根据条件统计数量
	 * @param like
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(@Param("like")String like)throws Exception;
	/**
	 * 删除
	 */
	void delete(@Param("id")String id)throws Exception;
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Radio findById(@Param("id")String id)throws Exception;
}

