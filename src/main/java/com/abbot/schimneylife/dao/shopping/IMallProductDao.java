package com.abbot.schimneylife.dao.shopping;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.MallProduct;

/**
 * 在线商城商品
 * @author Administrator
 *
 */
@Repository
public interface IMallProductDao {

	/**
	 * 根据分类分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param typeId 商品分类id
	 * @return
	 * @throws Exception
	 */
	List<MallProduct> findByPageAndType(@Param("like")String like,@Param("order")String order,@Param("sort")String sort
			,@Param("typeId")String typeId,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 根据分类统计数量
	 * @param like
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	Integer countByType(@Param("like")String like,@Param("typeId")String typeId)throws Exception;
	/**
	 * 添加商品
	 * @param product
	 * @throws Exception
	 */
	void insert(MallProduct product)throws Exception;
	/**
	 * 分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param like 模糊查询
	 * @param order 排序规则
	 * @param up 0降序  1升序
	 * @return
	 * @throws Exception
	 */
	List<MallProduct> findByPage(Map<String,Object> map)throws Exception;
	/**
	 * 统计总数
	 * @param like
	 * @return
	 * @throws Exception
	 */
	Integer totalCount(Map<String,Object> map)throws Exception;
	/**
	 * 根据销量分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param order 0 asc 1 desc
	 * @return
	 * @throws Exception
	 */
	List<MallProduct> selectBySale(Map<String,Object> map)throws Exception;
	/**
	 * 查找指定购物车下的所有商品
	 * @param shoppingCartId 购物车id
	 * @return
	 * @throws Exception
	 */
	List<MallProduct> selectAllByCartId(@Param("shoppingCartId")String shoppingCartId)throws Exception;
	/**
	 * 根据id查找商品信息
	 * @param gid
	 * @return
	 * @throws Exception
	 */
	MallProduct fetchById(@Param("gid")String gid)throws Exception;
	MallProduct fetchByParamId(@Param("paramId")String gid)throws Exception;
	/**
	 * 筛选出省份
	 * @return
	 * @throws Exception
	 */
	List<String> findProvince()throws Exception;
	/**
	 * 根据省份分页查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<MallProduct> findByProvince(Map<String,Object> map)throws Exception;
	Integer countByProvince(Map<String,Object> map)throws Exception;
	/**
	 * 根据paramId修改商品状态
	 * @param status
	 * @param paramId
	 * @throws Exception
	 */
	void updateStatusByParamId(@Param("status")Integer status,@Param("paramId")String paramId)throws Exception;
	/**
	 * 删除数据，只能删除禁用状态下的
	 * @param id
	 * @throws Exception
	 */
	void deleteById(@Param("id")String id)throws Exception;
	void update(MallProduct product)throws Exception;
	/**
	 * 根据推荐度分页查找
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<MallProduct> findByRecom(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 统计推荐商品数量
	 * @return
	 * @throws Exception
	 */
	Integer totalCountByRecom()throws Exception;
	/**
	 * 根据商品编号查询商品
	 * @param number
	 * @return
	 * @throws Exception
	 */
	MallProduct findByNumber(@Param("number")String number)throws Exception;
}
