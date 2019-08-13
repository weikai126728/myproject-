package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.Tidings;

public interface TidingsService {

	void findByUserId(Integer userId);
	/**
	 * 添加
	 * @param tidings
	 * @return
	 */
	boolean add(Tidings tidings);
	/**
	 * 修改
	 * @param tidings
	 * @return
	 */
	boolean update(Tidings tidings);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	boolean delete(String id);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Tidings findById(String id);
	/**
	 * 分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param like
	 * @param order
	 * @return
	 */
	List<Tidings> findByPage(Integer firstResult,Integer pageSize, String like,String order);
	/**
	 * 统计总数
	 * @param like
	 * @return
	 */
	Integer coutTotal(String like);
	/**
	 * 批量删除
	 * @param ids
	 * @throws Exception
	 */
	void batchDelete(String[] ids)throws Exception;
	/**
	 * 禁用消息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean disable(String id);
	/**
	 * 启用消息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean enable(String id);
	/**
	 * 查询所有可展示消息
	 * @return
	 */
	List<Tidings> findAllShow();
	/**
	 * 统计所有可展示消息数量
	 * @return
	 */
	Integer countAllShow();
	/**
	 * 查询指定时间后的消息
	 * @param time
	 * @return
	 */
	List<Tidings> findAfter(String time);
	/**
	 * 统计指定时间后的消息数量
	 * @param time
	 * @return
	 */
	Integer countAfter(String time);
}
