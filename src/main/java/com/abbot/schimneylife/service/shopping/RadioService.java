package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.Radio;

public interface RadioService {

	/**
	 * 修改广播消息
	 * @param radio
	 * @return
	 */
	boolean update(Radio radio);
	/**
	 * 新增广播消息
	 * @param radio
	 * @return
	 */
	boolean insert(Radio radio);
	/**
	 * 查找所有可展示信息
	 * @return
	 */
	List<Radio> findAllShow();
	/**
	 * 根据条件分页查询
	 * @param like
	 * @param order
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<Radio> findByPage(String like,String order,Integer firstResult,Integer pageSize);
	/**
	 * 根据条件统计数量
	 * @param like
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(String like);
	/**
	 * 禁用消息
	 * @param id
	 * @return
	 */
	boolean disable(String id);
	/**
	 *启用消息 
	 * @param id
	 * @return
	 */
	boolean enable(String id);
	/**
	 * 删除消息
	 * @param id
	 * @return
	 */
	boolean delete(String id);
	void batchDelete(String[] ids)throws Exception;
	Radio findById(String id);
}
