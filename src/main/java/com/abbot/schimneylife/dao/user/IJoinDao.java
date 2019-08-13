package com.abbot.schimneylife.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.user.Join;
import com.abbot.schimneylife.pojo.user.Opinion;

@Repository
public interface IJoinDao {
	Integer insert(Join join) throws Exception;

	List<Join> checkJoin() throws Exception;

	void deleteById(@Param("id") Integer id) throws Exception;

	Integer totalCount() throws Exception;

	List<Join> findByPageAndType(@Param("order") String order, @Param("sort") String sort,
			 @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize) throws Exception;

}
