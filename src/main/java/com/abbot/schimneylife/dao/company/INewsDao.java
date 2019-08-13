package com.abbot.schimneylife.dao.company;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.company.news;

@Repository
public interface INewsDao {

	Integer totalCount() throws Exception;

	List<news> findByPage(@Param("order") String order, @Param("sort") String sort,
			@Param("firstResult") Integer firstResult, @Param("pageSize") Integer pageSize) throws Exception;
	news findById(@Param("id") String id) throws Exception;
	
	void add(news news)throws Exception;
	
	void edit(news news)throws Exception;

	void deleteById(@Param("id")String id)throws Exception;
}
