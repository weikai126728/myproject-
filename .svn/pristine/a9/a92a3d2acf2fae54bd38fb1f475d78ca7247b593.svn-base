package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.MallOrder;
import com.abbot.schimneylife.pojo.shopping.MallProduct;
import com.abbot.schimneylife.pojo.shopping.MallProductBanner;
import com.abbot.schimneylife.pojo.shopping.MallProductInfo;
import com.abbot.schimneylife.pojo.shopping.MallProductParameter;
import com.abbot.schimneylife.vo.MallProductVO;

public interface MallProductService {

	/**
	 * 根据分类分页查询商品
	 * @param typeId 商品分类id
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<MallProduct> findByPageAndType(String like,String order,String sort,String typeId,Integer firstResult,Integer pageSize);
	/**
	 * 根据分类统计数量
	 * @param like
	 * @param typeId
	 * @return
	 */
	Integer countByType(String like,String typeId);
	/**
	 * 新增商品
	 * @param product
	 */
	void addProduct(MallProduct product,List<MallProductParameter> paramList,List<MallProductBanner> bannerList
			,MallProductInfo proInfo) throws Exception;
	void updateProduct(MallProduct product,List<MallProductParameter> paramList,List<MallProductBanner> bannerList,String oldBanner
			,MallProductInfo proInfo,String[] delParamIds,String productID)throws Exception;
	/**
	 * 分页查询商品
	 * @param firstResult
	 * @param pageSize
	 * @param like
	 * @param order
	 * @param up 0降序 1升序
	 * @return
	 */
	List<MallProduct> findByPage(Integer firstResult,Integer pageSize,String like,String order,Integer up,String provinces);
	/**
	 * 统计总数量
	 * @param like 模糊查询
	 * @return
	 */
	Integer totalCount(String like,String provinces);
	/**
	 * 根据销量分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param order 0 asc 1 desc
	 * @return
	 */
	List<MallProduct> findBySale(Integer firstResult,Integer pageSize,String like,Integer order,String provinces);
	/**
	 * 查找指定购物车下所有商品
	 * @param shoppingCartId
	 * @return
	 */
	List<MallProduct> findAllByCart(String shoppingCartId);
	/**
	 * 查找指定商品信息
	 * @param gid
	 * @return
	 */
	MallProduct findById(String gid);
	/**
	 * 筛选省份
	 * @return
	 */
	List<String> findProvince();
	/**
	 * 根据省份模糊查询
	 * @param firstResult
	 * @param pageSize
	 * @param ids
	 * @param like
	 * @return
	 */
	List<MallProduct> findByProvince(Integer firstResult,Integer pageSize,String ids,String like);
	Integer countByProvince(String ids,String like);
	/**
	 * 根据条件分页查询VO
	 * @param typeId
	 * @param name
	 * @param sort
	 * @param order
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<MallProductVO> findVOByPage(String typeId,String name,String sort,Integer order,Integer firstResult,Integer pageSize);
	/**
	 * 统计VO数量
	 * @param typeId
	 * @param name
	 * @return
	 */
	Integer countTotalVO(String typeId,String name);
	/**
	 * 查询分类下的所有VO
	 * @param typeId
	 * @return
	 */
	List<MallProductVO> findAllVO(String typeId);
	/**
	 * 根据paramId查找对应商品的状态
	 * @param paramId
	 * @return
	 */
	Integer fetchProStatusByParamId(String paramId);
	/**
	 * 设置禁用
	 * @param paramId
	 * @return
	 */
	void disableByParamId(String paramId)throws Exception;
	/**
	 * 设置启用
	 * @param paramId
	 * @return
	 */
	void enableByParamId(String paramId)throws Exception;
	/**
	 * 根据商品id启用
	 * @param proId
	 * @throws Exception
	 */
	void enableByProId(String proId)throws Exception;
	/**
	 * 根据商品id禁用
	 * @param proId
	 * @throws Exception
	 */
	void disableByProId(String proId)throws Exception;
	void deleteByParamId(String paramId)throws Exception;
	void deleteById(String id)throws Exception;
	MallProduct fetchByParamId(String paramId);
	/**
	 * 根据推荐度分页查找
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<MallProduct> findByRecom(Integer firstResult,Integer pageSize);
	/**
	 * 统计推荐商品数量
	 * @return
	 */
	Integer totalCountByRecom();
	void test()throws Exception;
	MallProduct findByNumber(String number);
	MallOrder selectMsg(String id);
 }
