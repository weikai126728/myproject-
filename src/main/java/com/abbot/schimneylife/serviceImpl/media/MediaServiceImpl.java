package com.abbot.schimneylife.serviceImpl.media;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.media.IMediaDao;
import com.abbot.schimneylife.pojo.media.Media;
import com.abbot.schimneylife.service.media.MediaService;
@Service
public class MediaServiceImpl implements MediaService {
	private static final Logger logger = Logger.getLogger(MediaServiceImpl.class);
	
	@Resource
	private IMediaDao mediaDao;
	
	@Override
	public boolean insert(Media media) {
		try {
			mediaDao.insert(media);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			mediaDao.delete(id);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	@Override
	public List<Media> findByPage(Integer firstResult, Integer pageSize, String startTime, String endTime) {
		List<Media> list = Collections.emptyList();
		try {
			list = mediaDao.findByPage(firstResult, pageSize, startTime, endTime);
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}

	@Override
	public Integer countTotal(String startTime, String endTime) {
		Integer total = 0;
		try {
			total = mediaDao.countTotal(startTime, endTime);
		} catch (Exception e) {
			logger.error(e);
		}
		return total;
	}

	@Override
	public Media fetchById(Integer id) {
		try {
			return mediaDao.fetchById(id);
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

}
