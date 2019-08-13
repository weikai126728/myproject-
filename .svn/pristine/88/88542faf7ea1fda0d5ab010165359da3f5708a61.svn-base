package com.abbot.schimneylife.service.user;

import java.util.List;

import com.abbot.schimneylife.pojo.user.Join;
import com.abbot.schimneylife.pojo.user.Opinion;

public interface JoinService {
	Integer insert(Join join);

	List<Join> checkJoin();

	boolean deleteById(Integer id);

	Integer totalCount();// 商品总数量

	/**
	 * 根据分类分页查询商品
	 * 
	 * @param typeId
	 *            商品分类id
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<Join> findByPageAndType( String order, String sort, Integer firstResult,
			Integer pageSize);
}
