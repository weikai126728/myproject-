package com.abbot.schimneylife.dao.weixin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.weixin.Activities;
import com.abbot.schimneylife.pojo.weixin.Faile_redp;
import com.abbot.schimneylife.pojo.weixin.FzVorUser;
import com.abbot.schimneylife.pojo.weixin.OrderMerchantPayment;
import com.abbot.schimneylife.pojo.weixin.OrderMerchantRedpack;
import com.abbot.schimneylife.pojo.weixin.Probability_fz;
import com.abbot.schimneylife.pojo.weixin.Voucher;

@Repository
public interface RedpackDao {

	void updateRedpackGailv(Probability_fz probability_fz) throws Exception;

	/**
	 * 省市级联
	 */
	
	 /* List<GenneraCode> queryProvinceByLevelType(GenneraCode genneraCode);
	  List<GenneraCode> queryCityCodeByParentid(GenneraCode genneraCode);*/
	 

	int countTotal() throws Exception;

	List<Probability_fz> queryRedgailvList(@Param("like") String like, @Param("order") String order,
			@Param("sort") String sort, @Param("typeId") String typeId, @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize) throws Exception;

	Probability_fz queryRedgailvByzipcode(Probability_fz probability_fz) throws Exception;
	List<Probability_fz> queryLikeRedpackGailv(@Param("merername") String merername,@Param("like") String like, @Param("order") String order,
			@Param("sort") String sort, @Param("typeId") String typeId, @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize) throws Exception;
	int queryLikeRedpackGailvCuont(Probability_fz probability_fz) throws Exception;
	int queryBufaRedCount()throws Exception;
	List<OrderMerchantRedpack> queryBufaRedlist(@Param("like") String like, @Param("order") String order,
			@Param("sort") String sort, @Param("typeId") String typeId, @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize)throws Exception;
	void redBufaUpdate(Faile_redp faile_redp) throws Exception;
	void addRedpackFafang(Faile_redp faile_redp) throws Exception;
	void addMerchantPayment(OrderMerchantPayment orderMerchantPayment) throws Exception;
	void addVoucher(Voucher voucher)throws Exception;
	
	int queryVoucherCount(@Param("sendTime") String sendTime)throws Exception;
	List<Voucher> queryVoucherlist(@Param("sendTime") String sendTime,@Param("like") String like, @Param("order") String order,
			@Param("sort") String sort, @Param("typeId") String typeId, @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize)throws Exception;
	void addUserRedPack(OrderMerchantRedpack orderMerchantRedpack)throws Exception;
	void updateUserRedPack(OrderMerchantRedpack orderMerchantRedpack)throws Exception;
	void addUserVoucher(Activities activities)throws Exception;
	
	List<Voucher> getSendCoupon_stock_id(Voucher vouchers)throws Exception;
	
	List<Activities> getActivitiesList(@Param("date3")String date3,@Param("like") String like, @Param("order") String order,
			@Param("sort") String sort, @Param("typeId") String typeId, @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize)throws Exception;
	int getActivitiesCountList(Activities activity)throws Exception;
	
	int getActivitiesCountLikeList(@Param("activitsName")String activitsName)throws Exception;
	List<Activities> getActivitiesLikeList(@Param("activitsName")String activitsName,@Param("like") String like, @Param("order") String order,
			@Param("sort") String sort, @Param("typeId") String typeId, @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize)throws Exception;
	
	int queryOverdueVouchersCountBytime()throws Exception;
	List<Activities> queryOverdueVouchersBytime(@Param("like") String like, @Param("order") String order,
			@Param("sort") String sort, @Param("typeId") String typeId, @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize)throws Exception;
	
	void addNoGetVouchers(Activities activity)throws Exception;
	
	int queryFzvoruserCount()throws Exception;
	List<FzVorUser> queryFzvoruserList(@Param("like") String like, @Param("order") String order,
			@Param("sort") String sort, @Param("typeId") String typeId, @Param("firstResult") Integer firstResult,
			@Param("pageSize") Integer pageSize)throws Exception;
	
	void updatePromoney(Probability_fz probability_fz) throws Exception;
	List<Probability_fz> queryPromoneyByzipcode(Probability_fz probability_fz) throws Exception;
	/**
	 * 佣金结算
	 * @param orderMerchantPayment
	 * @throws Exception
	 */
	void addCommissionSettlement(OrderMerchantPayment orderMerchantPayment) throws Exception;
	
}
