package com.abbot.schimneylife.service.media;

import java.util.List;

import com.abbot.schimneylife.pojo.media.Media;

public interface MediaService {

	/**
	 * 插入
	 * @param media
	 * @return
	 */
	boolean insert(Media media);
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);
	/**
	 * 分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<Media> findByPage(Integer firstResult,Integer pageSize,String startTime,String endTime);
	/**
	 * 统计数量
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Integer countTotal(String startTime,String endTime);
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	Media fetchById(Integer id);
}
