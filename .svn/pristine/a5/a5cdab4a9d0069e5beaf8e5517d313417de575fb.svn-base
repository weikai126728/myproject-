package com.abbot.schimneylife.dao.user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserOperationLogDao {

	/**
	 * 新增操作日志
	 * @param userId
	 * @param msg
	 * @param type
	 * @param targetId
	 * @param targetName
	 * @throws Exception
	 */
	void insert(@Param("userId")Integer userId,@Param("msg")String msg,@Param("type")Integer type,
			@Param("targetId")String targetId,@Param("targetName")String targetName)throws Exception;
}
