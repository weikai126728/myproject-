package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.CustomerEvaluate;

@Repository
public interface ICustomerEvaluateDao {

	/**
	 * 分页查询商品的评价
	 * @param proId
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<CustomerEvaluate> findByProduct(@Param("proId")String proId,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 计算商品评价总数量
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	Integer countByProduct(@Param("proId")String proId)throws Exception;
	/**
	 * 计算好评度
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	String getPraise(@Param("proId")String proId)throws Exception;
	/**
	 * 分页查询商品的好评
	 * @param proId
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<CustomerEvaluate> findGoodByProduct(@Param("proId")String proId,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 统计商品好评数量
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	Integer countGoodByProduct(String proId)throws Exception;
	/**
	 * 分页查询商品的差评
	 * @param proId
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<CustomerEvaluate> findBadByProduct(@Param("proId")String  proId,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 统计商品差评数量
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	Integer countBadByProduct(@Param("proId")String proId)throws Exception;
	/**
	 * 分页查询
	 * @param like
	 * @param type
	 * @param status
	 * @param sort
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<CustomerEvaluate> findByPage(@Param("createTime")String createTime,@Param("like")String like,@Param("type")Integer type,@Param("status")Integer status,
			@Param("sort")String sort,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 统计数量
	 * @param like
	 * @param type
	 * @param status
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(@Param("createTime")String createTime,@Param("like")String like,@Param("type")Integer type,@Param("status")Integer status)throws Exception;
	/**
	 * 回复评价
	 * @param reply
	 * @param author
	 * @param id
	 * @throws Exception
	 */
	void updateReply(@Param("reply")String reply,@Param("author")String author,@Param("id")String id)throws Exception;
	/**
	 * 修改状态
	 * @param status
	 * @param id
	 * @throws Exception
	 */
	void updateStatus(@Param("status")Integer status,@Param("id")String id)throws Exception;
	/**
	 * 根据id删除
	 * @param id
	 * @throws Exception
	 */
	void delete(String id)throws Exception;
	void insert(CustomerEvaluate evaluate)throws Exception;
}
