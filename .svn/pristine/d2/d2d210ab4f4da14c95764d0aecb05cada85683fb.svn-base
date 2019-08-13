package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.MallProductType;

/**
 * 商品分类
 * @author Administrator
 *
 */
@Repository
public interface IMallProductTypeDao {

	/**
	 * 新建分类
	 * @param type
	 * @throws Exception
	 */
	void insert(MallProductType type)throws Exception;
	/**
	 * 查询一级分类
	 * @return
	 * @throws Exception
	 */
	List<MallProductType> firstType()throws Exception;
	/**
	 * 查询子分类
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	List<MallProductType> childType(@Param("pid")String pid)throws Exception;
	/**
	 * 修改分类信息
	 * @param type
	 * @throws Exception
	 */
	void update(MallProductType type)throws Exception;
	/**
	 * 根据id查找分类信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	MallProductType fetchById(@Param("id")Integer id)throws Exception;
	/**
	 * 统计分类下商品数量
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Integer countProByTypeId(@Param("id")String id)throws Exception;
	/**
	 * 删除分类
	 * @param id
	 * @throws Exception
	 */
	void delete(@Param("id")int id)throws Exception;
}
