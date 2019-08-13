package com.abbot.schimneylife.dao.media;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.media.Media;

@Repository
public interface IMediaDao {

	/**
	 * 新增素材
	 * @param media
	 * @throws Exception
	 */
	void insert(Media media)throws Exception;
	/**
	 * 根据id删除
	 * @param id
	 * @throws Exception
	 */
	void delete(@Param("id")Integer id)throws Exception;
	/**
	 * 分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	List<Media> findByPage(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize
			,@Param("startTime")String startTime,@Param("endTime")String endTime)throws Exception;
	/**
	 * 统计总数量
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(@Param("startTime")String startTime,@Param("endTime")String endTime)throws Exception;
	/**
	 * 根据id查找数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Media fetchById(@Param("id")Integer id)throws Exception;
}
