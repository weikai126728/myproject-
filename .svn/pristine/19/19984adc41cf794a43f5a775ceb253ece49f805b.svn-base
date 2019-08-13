package com.abbot.schimneylife.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.user.Opinion;
 

@Repository
public interface IOpinionDao {
	
	Integer insert(Opinion op) throws Exception;
	
	List<Opinion> checkOpinion() throws Exception;
	
	void deleteById(@Param("id") Integer id)throws Exception;
	
	Integer totalCount()throws Exception;
	  
	List<Opinion> findByPageAndType( @Param("order") String order,
			@Param("sort") String sort,  @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize) throws Exception;

}
