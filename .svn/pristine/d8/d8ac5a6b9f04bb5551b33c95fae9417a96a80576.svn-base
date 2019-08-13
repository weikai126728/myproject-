package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.Tidings;

@Repository
public interface ITidingsDao {

	/**
	 * 添加消息
	 * @param tidings
	 * @throws Exception
	 */
	void insert(Tidings tidings)throws Exception;
	/**
	 * 修改
	 * @param tidings
	 * @throws Exception
	 */
	void update(Tidings tidings)throws Exception;
	/**
	 * 根据id删除
	 * @param id
	 * @throws Exception
	 */
	void delete(@Param("id")String id)throws Exception;
	/**
	 * 分页查找
	 * @param firstResult
	 * @param pageSize
	 * @param like
	 * @param order
	 * @return
	 * @throws Exception
	 */
	List<Tidings> findByPage(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize
			,@Param("like")String like,@Param("order")String order)throws Exception;
	/**
	 * 统计数量
	 * @param like
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(@Param("like")String like)throws Exception;
	/**
	 * 根据id查找消息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Tidings findById(@Param("id")String id)throws Exception;
	/**
	 * 查找所有可展示消息
	 * @return
	 * @throws Exception
	 */
	List<Tidings> findAllShow()throws Exception;
	/**
	 * 查找指定时间后的消息
	 */
	List<Tidings> findAfter(@Param("time")String time)throws Exception;
	/**
	 * 统计所有可展示消息的数量
	 * @return
	 * @throws Exception
	 */
	Integer countAllShow()throws Exception;
	/**
	 * 统计指定时间后消息的数量
	 * @param time
	 * @return
	 * @throws Exception
	 */
	Integer countAfter(@Param("time")String time)throws Exception;
}
