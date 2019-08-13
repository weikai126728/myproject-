package com.abbot.schimneylife.service.shopping;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.abbot.schimneylife.pojo.shopping.Appointment;
import com.abbot.schimneylife.pojo.shopping.Customer;
import com.abbot.schimneylife.pojo.shopping.MarketProductInfo;
import com.abbot.schimneylife.pojo.shopping.Recharge;
import com.abbot.schimneylife.pojo.shopping.SmarketProductInfo;
import com.abbot.schimneylife.pojo.shopping.SproductParameter;
import com.abbot.schimneylife.pojo.shopping.StoreClass;
import com.abbot.schimneylife.pojo.shopping.SupermarketInfo;
import com.abbot.schimneylife.util.CommonKey;

public interface SupermarketInfoService {

	/**
	 * 分页查询根据距离排序
	 * 
	 * @param firstResult
	 * @param pageSize
	 * @param lng
	 * @param lat
	 * @return
	 */
	List<SupermarketInfo> findByPageOrderDis(Integer firstResult, Integer pageSize, BigDecimal lng, BigDecimal lat);

	/**
	 * 查询总数量
	 * 
	 * @return
	 */
	Integer totalCount();

	/**
	 * 新增超市
	 * 
	 * @param market
	 * @return
	 */
	void addSupermarket(SupermarketInfo market)throws Exception;

	/**
	 * 根据超市id查找超市信息
	 * 
	 * @param gid
	 *            超市id
	 * @return
	 */
	SupermarketInfo fetchById(Integer gid);

	List<SupermarketInfo> findByPageBetweenRadius(Integer firstResult, Integer pageSize, String minlng, String maxlng,
			String minlat, String maxlat);

	/**
	 * 超市列表展示信息
	 * 
	 * @return
	 */
	List<SupermarketInfo> selectMarket();

	/**
	 * 搜索查询
	 * 
	 * @param name
	 * @return
	 */
	List<SupermarketInfo> findByName(String name);

	/**
	 * 禁用
	 * 
	 * @param marketId
	 * @return
	 */
	boolean disable(Integer marketId);

	/**
	 * 启用
	 * 
	 * @param marketId
	 * @return
	 */
	boolean enable(Integer marketId);

	/**
	 * 删除
	 * 
	 * @param marketId
	 * @return
	 */
	boolean deleteMarket(Integer marketId);
	void update(SupermarketInfo market)throws Exception;
	void addmarketPro(MarketProductInfo info);
	List<MarketProductInfo> findListPro();
	boolean deleteMarketPro(Integer marketId);
	MarketProductInfo fetchProById(Integer gId);
	void updatePro( MarketProductInfo info,SproductParameter paramList);
	void addProduct(MarketProductInfo info,List<SproductParameter> SproductParameter);
	boolean disablePro(Integer proid);
	boolean enablePro(Integer proid);
	
	SupermarketInfo fetchBygId(Integer proid);
	/**
	 * 推广开关
	 * @param info
	 */
	boolean disablePromote(Integer proid);
	boolean enablePromote(Integer proid);
	
	
	void addProductShare(MarketProductInfo info);
	List<MarketProductInfo> findListShare();
	boolean disableShare(Integer proid);
	boolean enableShare(Integer proid);
	MarketProductInfo fetchShareById(Integer marketId);
	void updateShare(MarketProductInfo info);
	boolean deleteMarketShare(Integer marketId);
	/**
	 * 公告金
	 */
	Recharge findBalance(String openid);
	void addRecharge(Recharge re);
	void updateRecharge(Recharge re);
	
	/**
	 * 订单
	 */
	List<Customer>  findListOrder();
	/**
	 * 预约信息
	 */
	List<Appointment> findListAppointment();
	MarketProductInfo findProductByid(Integer gid);
	
	
	void addProductVipcn(MarketProductInfo product);
	List<MarketProductInfo>  findListVipcn();
	boolean deleteMarketVipcn(Integer marketId);
	boolean enableVipcn(Integer proid);
	boolean disableVipcn(Integer proid);
	MarketProductInfo fetchVipcnById(Integer marketId);
	void updateVipcn(MarketProductInfo info);
	
/**
 * 招商
 */
	List<Appointment> findListAttract();
	boolean deleteAttract(Integer proid);
	
	/**
	 * 积分商品
	 */
	List<MarketProductInfo> findListProi();
	boolean disableProi(Integer proid);
	boolean enableProi(Integer proid);
	boolean deleteMarketProi(Integer marketId);
	void addProducti(MarketProductInfo info);
	MarketProductInfo fetchProiById(Integer gId);
	void updateProi( MarketProductInfo info);
	/**
	 * 便民信息
	 */
	
	List<SmarketProductInfo> secondProiList();
	boolean secondStop(Integer proid);
	boolean secondStart(Integer proid);
	boolean deleteSecond(Integer proid);
	SmarketProductInfo  SecondProByid(Integer marketId);
	void updateSecond(SmarketProductInfo info);
	/**
	 * 福利管理
	 */
	List<MarketProductInfo> storeProiList();
	boolean storeStop(Integer proid);
	boolean storeStart(Integer proid);
	boolean deleteStore(Integer proid);
	MarketProductInfo storeProByid(Integer proid);
	List<StoreClass> findStoreClass();
	void updateStore(MarketProductInfo info);
	void addStoreProduct(MarketProductInfo product);
}
