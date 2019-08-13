package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.CustomerEvaluate;

public interface CustomerEvaluateService {

	/**
	 * 分页查询商品评价
	 * @param proId
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<CustomerEvaluate> findByProduct(String proId,Integer firstResult,Integer pageSize,String type);
	/**
	 * 统计商品的评价总数量
	 * @param proId
	 * @return
	 */
	Integer countByProduct(String proId,String type);
	/**
	 * 获取指定商品的好评度
	 * @param proId
	 * @return
	 */
	String getPraise(String proId);
	/**
	 * 分页查询
	 * @param like
	 * @param sort
	 * @param type
	 * @param status
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<CustomerEvaluate> findByPage(String createTime,String like,String sort,Integer type,Integer status,Integer firstResult,Integer pageSize);
	/**
	 * 统计数量
	 * @param like
	 * @param type
	 * @param status
	 * @return
	 */
	Integer countTotal(String createTime,String like,Integer type,Integer status);
	/**
	 * 回复评价
	 * @param reply
	 * @param author
	 * @param id
	 * @return
	 */
	boolean reply(String reply,String author,String id);
	/**
	 * 修改状态
	 * @param status
	 * @param id
	 * @return
	 */
	boolean updateStatus(Integer status,String id);
	boolean delete(String id);
	boolean insert(CustomerEvaluate evaluate);
	void insertBatch(List<CustomerEvaluate> evaluateList)throws Exception;
}
