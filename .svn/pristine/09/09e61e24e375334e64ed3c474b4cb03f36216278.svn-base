package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.MallProductType;

public interface MallProductTypeService {

	/**
	 * 新增商品分类
	 * @param type
	 * @return
	 */
	boolean insert(MallProductType type);
	/**
	 * 修改分类信息
	 * @param type
	 * @return
	 */
	boolean update(MallProductType type);
	/**
	 * 查找一级分类
	 * @return
	 */
	List<MallProductType> firstType();
	/**
	 * 查找子类
	 * @param pid
	 * @return
	 */
	List<MallProductType> childType(String pid);
	/**
	 * 根据id查找分类信息
	 * @param id
	 * @return
	 */
	MallProductType fetchById(Integer id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	Integer products(String id);
	/**
	 * 删除分类
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);
}
