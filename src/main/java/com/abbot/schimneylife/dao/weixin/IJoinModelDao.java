package com.abbot.schimneylife.dao.weixin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.weixin.JoinModel;

@Repository
public interface IJoinModelDao {
	
	/**
	 * 新增加盟方式
	 * @param model
	 * @throws Exception
	 */
	void insert(JoinModel model)throws Exception;
	/**
	 * 修改加盟方式
	 * @param model
	 * @throws Exception
	 */
	void update(JoinModel model)throws Exception;
	/**
	 * 根据id删除
	 * @param id
	 * @throws Exception
	 */
	void delete(Integer id)throws Exception;
	/**
	 * 查询所有
	 * @return
	 * @throws Exception
	 */
	List<JoinModel> findAll()throws Exception;
}
