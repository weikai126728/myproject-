package com.abbot.schimneylife.service.weixin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.abbot.schimneylife.pojo.weixin.Activities;
import com.abbot.schimneylife.pojo.weixin.FzVorUser;
import com.abbot.schimneylife.pojo.weixin.OrderMerchantPayment;
import com.abbot.schimneylife.pojo.weixin.OrderMerchantRedpack;
import com.abbot.schimneylife.pojo.weixin.Probability_fz;
import com.abbot.schimneylife.pojo.weixin.Voucher;

public interface RedpackService {

	boolean updateRedpackGailv(Probability_fz probability_fz);

	int countTotal();

	List<Probability_fz> queryRedgailvList(String like, String order, String sort, String typeId, Integer firstResult,
			Integer pageSize);

	Probability_fz queryRedgailvByzipcode(Probability_fz probability_fz);

	List<Probability_fz> queryLikeRedpackGailv(String merername, String like, String order, String sort, String typeId,
			Integer firstResult, Integer pageSize);

	int queryLikeRedpackGailvCuont(Probability_fz probability_fz);

	int queryBufaRedCount();

	List<OrderMerchantRedpack> queryBufaRedlist(String like, String order, String sort, String typeId, Integer firstResult,
			Integer pageSize);

	boolean redBufaUpdate(OrderMerchantRedpack orderMerchantRedpack);

	boolean addRedpackFafang(OrderMerchantRedpack orderMerchantRedpack);

	boolean addMerchantPayment(OrderMerchantPayment orderMerchantPayment);

	boolean addVoucher(Voucher voucher);

	int queryVoucherCount(String sendTime);

	List<Voucher> queryVoucherlist(String sendTime, String like, String order, String sort, String typeId,
			Integer firstResult, Integer pageSize);
	boolean addUserVoucher(Activities activities);
	
	List<Voucher> getSendCoupon_stock_id(Voucher vouchers);
	
	List<Activities> getActivitiesList(String date3,String like, String order, String sort, String typeId, Integer firstResult,
			Integer pageSize);
	int getActivitiesCountList(Activities activity);
	
	int getActivitiesCountLikeList(String activitsName);
	List<Activities> getActivitiesLikeList(String activitsName,String like, String order, String sort, String typeId, Integer firstResult,
			Integer pageSize);
	
	int queryOverdueVouchersCountBytime();
	List<Activities> queryOverdueVouchersBytime(String like, String order, String sort, String typeId,
			Integer firstResult, Integer pageSize);
	
	boolean addNoGetVouchers(Activities activity);
	int queryFzvoruserCount();
	List<FzVorUser> queryFzvoruserList(String like, String order, String sort, String typeId,
			Integer firstResult, Integer pageSize);
	
	boolean updatePromoney(Probability_fz probability_fz);
	List<Probability_fz> queryPromoneyByzipcode(Probability_fz probability_fz);
	/**
	 * 佣金结算
	 * @param orderMerchantPayment
	 * @throws Exception
	 */
	boolean addCommissionSettlement(OrderMerchantPayment orderMerchantPayment);
	
}
