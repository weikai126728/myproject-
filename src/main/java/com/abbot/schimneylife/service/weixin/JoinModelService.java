package com.abbot.schimneylife.service.weixin;

import java.util.List;

import com.abbot.schimneylife.pojo.weixin.JoinModel;

public interface JoinModelService {
	
	/**
	 * 新增加盟方式
	 * @param model
	 * @return
	 * @throws Exception
	 */
	boolean insert(JoinModel model);
	/**
	 * 修改加盟方式
	 * @param model
	 * @return
	 * @throws Exception
	 */
	boolean update(JoinModel model);
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean delete(Integer id);
	/**
	 * 查询所有
	 * @return
	 * @throws Exception
	 */
	List<JoinModel> findAll();
}
