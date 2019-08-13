package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.vo.MallProductVO;

@Repository
public interface IMallProductVODao {
	/**
	 * 分页查询商品VO
	 * @param typeId
	 * @param name
	 * @param sort
	 * @param order
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<MallProductVO> findProductVOByPage(@Param("typeId")String typeId,@Param("name")String name,@Param("sort")String sort,@Param("order")String order,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 统计商品VO数量
	 * @param typeId
	 * @param name
	 * @return
	 * @throws Exception
	 */
	Integer countTotalVO(@Param("typeId")String typeId,@Param("name")String name)throws Exception;
	/**
	 * 查找指定分类的所有VO
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	List<MallProductVO> findAllVO(@Param("typeId")String typeId)throws Exception;
	/**
	 * 查找商品的启用、禁用状态
	 * @param paramId
	 * @return
	 * @throws Exception
	 */
	Integer fetchProStatusByParamId(@Param("paramId")String paramId)throws Exception;
}
