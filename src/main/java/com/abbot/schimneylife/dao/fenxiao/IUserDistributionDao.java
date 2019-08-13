package com.abbot.schimneylife.dao.fenxiao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.fenxiao.UserDistribution;

@Repository
public interface IUserDistributionDao {

	List<UserDistribution> selectUser() throws Exception;

	void stop(@Param("id") Integer id) throws Exception;

	void start(@Param("id") Integer id) throws Exception;

	void deleteById(@Param("id") Integer id) throws Exception;

	List<UserDistribution> selectUserBy(UserDistribution user) throws Exception;

	Integer totalCount() throws Exception;

	List<UserDistribution> findByPageAndType( @Param("order") String order,
			@Param("sort") String sort, @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize) throws Exception;
}
