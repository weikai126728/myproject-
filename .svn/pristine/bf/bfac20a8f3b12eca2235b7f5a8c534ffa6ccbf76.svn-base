package com.abbot.schimneylife.dao.company;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.company.compOpinion;

@Repository
public interface ICompOpinionDao {
	
	Integer totalCount() throws Exception;

	List<compOpinion> findByPage(@Param("order") String order, @Param("sort") String sort,
			@Param("firstResult") Integer firstResult, @Param("pageSize") Integer pageSize) throws Exception;
	
	void deleteById(@Param("id")String id)throws Exception;
}
