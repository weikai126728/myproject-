package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.MallOrder;
import com.abbot.schimneylife.pojo.shopping.Refund;
import com.abbot.schimneylife.pojo.user.User;

public interface RefundService {
	/**
	 * 查询用户申请
	 * 
	 * @param customerid
	 * @return
	 */
	List<Refund> selectAll(Integer customerid);

	/**
	 * 添加申请
	 * 
	 * @param refund
	 * @return
	 */
	boolean add(Refund refund);

	Refund selectMsg(String mallOrderId);

	/**
	 * 取消申请
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(String id);

	/**
	 * 查询所有申请
	 * 
	 * @return
	 */
	List<Refund> selectAllRefund();

	List<Refund> findByPageAndType(String order, String sort, Integer firstResult, Integer pageSize);

	Integer selectCount();

	/**
	 * 审批
	 * 
	 * @param id
	 * @param serviceStatus
	 * @return
	 */
	boolean agreeRefund(String id, Integer serviceStatus);

	boolean agreegoods(String id, Integer isAgree);

	boolean addReason(String id, String refuseReason);

	String getImgName(String id);

	/**
	 * 查询申请状态
	 * 
	 * @param id
	 * @return
	 */
	Refund checkMsg(String id);

	void updateSub(Integer sub, String serviceId);
}
