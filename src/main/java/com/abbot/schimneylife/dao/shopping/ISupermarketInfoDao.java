package com.abbot.schimneylife.dao.shopping;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.Appointment;
import com.abbot.schimneylife.pojo.shopping.Customer;
import com.abbot.schimneylife.pojo.shopping.MarketProductInfo;
import com.abbot.schimneylife.pojo.shopping.Recharge;
import com.abbot.schimneylife.pojo.shopping.SmarketProductInfo;
import com.abbot.schimneylife.pojo.shopping.SproductParameter;
import com.abbot.schimneylife.pojo.shopping.StoreClass;
import com.abbot.schimneylife.pojo.shopping.SupermarketInfo;

@Repository
public interface ISupermarketInfoDao {

	/**
	 * 分页查询超市列表
	 * 
	 * @param firstResult
	 * @param pageSize
	 * @param lng
	 * @param lat
	 * @return
	 * @throws Exception
	 */
	List<SupermarketInfo> selectByPageAndDis(@Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize, @Param("lng") BigDecimal lng, @Param("lat") BigDecimal lat)
			throws Exception;

	/**
	 * 查询总数量
	 * 
	 * @return
	 * @throws Exception
	 */
	Integer totalCount() throws Exception;

	/**
	 * 新增超市信息
	 * 
	 * @param market
	 * @throws Exception
	 */
	void insert(SupermarketInfo market) throws Exception;

	/**
	 * 根据超市id查找超市信息
	 * 
	 * @param gid
	 *            超市id
	 * @return
	 * @throws Exception
	 */
	SupermarketInfo fetchById(@Param("gid") Integer gid) throws Exception;

	/**
	 * 超市列表展示信息
	 * 
	 * @return
	 * @throws Exception
	 */
	List<SupermarketInfo> selectMarket() throws Exception;

	/**
	 * 搜索查询
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	List<SupermarketInfo> findByName(@Param("name") String name) throws Exception;

	/**
	 * 删除
	 * 
	 * @param marketId
	 */
	void deleteMarket(@Param("id") Integer marketId);

	/**
	 * 禁用
	 * 
	 * @param marketId
	 */
	void disable(@Param("id") Integer marketId);

	/**
	 * 启用
	 * 
	 * @param marketId
	 */
	void enable(@Param("id") Integer marketId);
	void update(SupermarketInfo market)throws Exception;
	void addmarketPro(MarketProductInfo info)throws Exception;
	List<MarketProductInfo> findListPro()throws Exception;
	/**
	 * 删除
	 * 
	 * @param marketId
	 */
	void deleteMarketPro(@Param("id") Integer marketId);
	MarketProductInfo fetchProById(@Param("id")Integer marketId)throws Exception;
	void updatePro(MarketProductInfo info)throws Exception;
	void updateParameter(SproductParameter paramList)throws Exception;
	void insertParameter(SproductParameter param)throws Exception;
	void disablePro(@Param("id")Integer proid)throws Exception;
	void enablePro(@Param("id")Integer proid)throws Exception;
	void disablePromote(@Param("id")Integer proid)throws Exception;
	void enablePromote(@Param("id")Integer proid)throws Exception;
	
	
	void addmarketShare(MarketProductInfo info)throws Exception;
	List<MarketProductInfo> findListShare()throws Exception;
	void disableShare(@Param("id")Integer proid)throws Exception;
	void enableShare(@Param("id")Integer proid)throws Exception;
	MarketProductInfo fetchShareById(@Param("id")Integer marketId)throws Exception;
	void updateShare(MarketProductInfo info)throws Exception;
	void deleteMarketShare(@Param("id") Integer marketId);
	/**
	 * 广告金
	 */
	Recharge findBalance(@Param("openid")String openid)throws Exception;
	void addRecharge(Recharge re)throws Exception;
	void updateRecharge(Recharge re) throws Exception;
	
	
	
	
	SupermarketInfo fetchBygId(@Param("id")Integer proid)throws Exception;
	
	/**
	 * 订单
	 */
	List<Customer>  findListOrder()throws Exception;
	/**
	 * 预约信息
	 */
	List<Appointment> findListAppointment()throws Exception;
	MarketProductInfo findProductByid(@Param("id")Integer gid)throws Exception;
	
	/**
	 *首页动态活动
	 * @param product
	 */
	void addProductVipcn(MarketProductInfo product)throws Exception;
	List<MarketProductInfo>  findListVipcn()throws Exception;
	void deleteMarketVipcn(@Param("id")Integer marketId)throws Exception;
	void enableVipcn(@Param("id")Integer proid)throws Exception;
	void disableVipcn(@Param("id")Integer proid)throws Exception;
	MarketProductInfo fetchVipcnById(@Param("id")Integer marketId)throws Exception;
	void updateVipcn(MarketProductInfo info)throws Exception;
	
	
	/**
	 * 招商
	 */
	List<Appointment> findListAttract()throws Exception;
	void deleteAttract(@Param("id")Integer proid);
	/**
	 * 积分商品
	 */
	List<MarketProductInfo> findListProi()throws Exception;
	void disableProi(@Param("id")Integer proid)throws Exception;
	void enableProi(@Param("id")Integer proid)throws Exception;
	void deleteMarketProi(@Param("id") Integer marketId)throws Exception;
	void addProducti(MarketProductInfo info)throws Exception;
	MarketProductInfo fetchProiById(@Param("id")Integer marketId)throws Exception;
	void updateProi( MarketProductInfo info)throws Exception;
	/**
	 * 便民信息
	 */
	List<SmarketProductInfo> secondProiList()throws Exception;
	boolean secondStop(@Param("id")Integer proid)throws Exception;
	boolean secondStart(@Param("id")Integer proid)throws Exception;
	boolean deleteSecond(@Param("id")Integer proid)throws Exception;
	SmarketProductInfo  SecondProByid(@Param("id")Integer marketId)throws Exception;
	void updateSecond(SmarketProductInfo info)throws Exception;
	/**
	 * 福利管理
	 */
	List<MarketProductInfo> storeProiList();
	boolean storeStop(@Param("id")Integer proid)throws Exception;
	boolean storeStart(@Param("id")Integer proid)throws Exception;
	boolean deleteStore(@Param("id")Integer proid)throws Exception;
	MarketProductInfo storeProByid(@Param("id")Integer proid)throws Exception;
	List<StoreClass> findStoreClass()throws Exception;
	void updateStore(MarketProductInfo info)throws Exception;
	void addStoreProduct(MarketProductInfo product)throws Exception;
}
