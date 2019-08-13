package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.Refund;
import com.abbot.schimneylife.pojo.user.User;

@Repository
public interface IRefundDao {

	List<Refund> selectAll(@Param("id") Integer id) throws Exception;

	List<Refund> findByPageAndType(@Param("order") String order, @Param("sort") String sort,
			@Param("firstResult") Integer firstResult, @Param("pageSize") Integer pageSize) throws Exception;

	Integer selectCount() throws Exception;

	void add(Refund refund) throws Exception;

	void delete(@Param("id") String id) throws Exception;

	List<Refund> selectAllRefund() throws Exception;

	void agreeRefund(@Param("id") String id, @Param("serviceStatus") Integer serviceStatus) throws Exception;

	void agreegoods(@Param("id") String id, @Param("isAgree") Integer isAgree) throws Exception;

	String getImgName(@Param("id") String id) throws Exception;

	Refund selectMsg(@Param("mId") String mallOrderId) throws Exception;

	Refund checkMsg(@Param("id") String id) throws Exception;

	void updateSub(@Param("sub") Integer sub, @Param("id") String serviceId) throws Exception;

	Integer addReason(@Param("id") String id, @Param("refuseReason") String refuseReason) throws Exception;
}
