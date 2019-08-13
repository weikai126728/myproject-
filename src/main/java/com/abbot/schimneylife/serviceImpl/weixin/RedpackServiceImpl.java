package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.weixin.RedpackDao;
import com.abbot.schimneylife.pojo.weixin.Activities;
import com.abbot.schimneylife.pojo.weixin.FzVorUser;
import com.abbot.schimneylife.pojo.weixin.OrderMerchantPayment;
import com.abbot.schimneylife.pojo.weixin.OrderMerchantRedpack;
import com.abbot.schimneylife.pojo.weixin.Probability_fz;
import com.abbot.schimneylife.pojo.weixin.Voucher;
import com.abbot.schimneylife.service.weixin.RedpackService;

@Service
public class RedpackServiceImpl implements RedpackService {
	private static final Logger logger = Logger.getLogger(RedpackServiceImpl.class);
	@Resource
	RedpackDao rd;

	@Override
	public boolean updateRedpackGailv(Probability_fz probability_fz) {
		// TODO 自动生成的方法存根
		try {
			rd.updateRedpackGailv(probability_fz);
			return true;
		} catch (Exception e) {
			logger.error("修改概率时异常", e);
			return false;
		}
	}

	/*
	 * @Override public List<GenneraCode> queryProvinceByLevelType(GenneraCode
	 * genneraCode) { // TODO 自动生成的方法存根 try { return
	 * rd.queryProvinceByLevelType(genneraCode); } catch (Exception e) {
	 * logger.error("省查询时异常", e); return null; } }
	 * 
	 * @Override public List<GenneraCode> queryCityCodeByParentid(GenneraCode
	 * genneraCode) { // TODO 自动生成的方法存根 try { return
	 * rd.queryCityCodeByParentid(genneraCode); } catch (Exception e) {
	 * logger.error("市区查询时异常", e); return null; } }
	 */

	@Override
	public int countTotal() {
		// TODO 自动生成的方法存根
		try {
			return rd.countTotal();
		} catch (Exception e) {
			logger.error("查总数量时异常", e);
			return 0;
		}
	}

	@Override
	public List<Probability_fz> queryRedgailvList(String like, String order, String sort, String typeId,
			Integer firstResult, Integer pageSize) {
		List<Probability_fz> productList = Collections.emptyList();
		try {
			productList = rd.queryRedgailvList(like, order, sort, typeId, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询商品异常！", e);
		}
		return productList;

	}

	@Override
	public Probability_fz queryRedgailvByzipcode(Probability_fz probability_fz) {
		// TODO 自动生成的方法存根
		try {
			return rd.queryRedgailvByzipcode(probability_fz);
		} catch (Exception e) {
			logger.error("单查地区概率时异常！", e);
			return null;
		}
	}

	@Override
	public List<Probability_fz> queryLikeRedpackGailv(String merername,String like, String order, String sort, String typeId,
			Integer firstResult, Integer pageSize) {
		// TODO 自动生成的方法存根
		try {
			return rd.queryLikeRedpackGailv(merername,like, order, sort, typeId, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据地区模糊查询概率时异常！", e);
			return null;
		}
	}

	@Override
	public int queryLikeRedpackGailvCuont(Probability_fz probability_fz) {
		// TODO 自动生成的方法存根
		try {
			return rd.queryLikeRedpackGailvCuont(probability_fz);
		}catch(Exception e) {
			logger.error("根据地区模糊查询概率总数量时异常！", e);
			return 0;
		}
	}

	@Override
	public int queryBufaRedCount() {
		// TODO 自动生成的方法存根
		try {
			return rd.queryBufaRedCount();
		}catch(Exception e) {
			logger.error("查询未发放红包记录数量时异常！", e);
			return 0;
		}
	}

	@Override
	public List<OrderMerchantRedpack> queryBufaRedlist( String like, String order, String sort, String typeId,
			Integer firstResult, Integer pageSize) {
		// TODO 自动生成的方法存根
		try {
			return rd.queryBufaRedlist(like, order, sort, typeId, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("查询未发放红包记录时异常！", e);
			return null;
		}
	}

	@Override
	public boolean redBufaUpdate(OrderMerchantRedpack orderMerchantRedpack) {
		// TODO 自动生成的方法存根
		try {
			rd.updateUserRedPack(orderMerchantRedpack);
			return true;
		} catch (Exception e) {
			logger.error("修改补发红包成已发送状态时异常", e);
			return false;
		}
	}

	@Override
	public boolean addRedpackFafang(OrderMerchantRedpack orderMerchantRedpack) {
		// TODO 自动生成的方法存根
		try {
			//rd.addRedpackFafang(faile_redp);
			rd.addUserRedPack(orderMerchantRedpack);
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("手动红包发放存储时异常", e);
			return false;
		}
	}

	@Override
	public boolean addMerchantPayment(OrderMerchantPayment orderMerchantPayment) {
		// TODO 自动生成的方法存根
		try {
			rd.addMerchantPayment(orderMerchantPayment);
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("手动企业付款存储时异常", e);
			return false;
		}
	}

	@Override
	public boolean addVoucher(Voucher voucher) {
		// TODO 自动生成的方法存根
		try {
			rd.addVoucher(voucher);
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("手动代金券添加时异常", e);
			return false;
		}
	}

	@Override
	public int queryVoucherCount(String sendTime) {
		// TODO 自动生成的方法存根
		try {
			return rd.queryVoucherCount(sendTime);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("代金券查询总数量时异常", e);
			return 0;
		}
	}

	@Override
	public List<Voucher> queryVoucherlist(String sendTime, String like, String order, String sort, String typeId,
			Integer firstResult, Integer pageSize) {
		// TODO 自动生成的方法存根
		try {
			return rd.queryVoucherlist(sendTime, like, order, sort, typeId, firstResult, pageSize);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("代金券查询时异常", e);
			return null;
		}
	}

	@Override
	public boolean addUserVoucher(Activities activities) {
		// TODO 自动生成的方法存根
		try {
			System.out.println("coupon_stock_id:"+activities.getCoupon_stock_id()+"openid:"+activities.getOpenid()+"coupon_id:"+activities.getCoupon_id()+"getTime:"+activities.getGetTime()+"count:"+activities.getCount()+"beginTime:"+activities.getBeginTime()+"endTime:"+activities.getEndTime()+"cadeId:"+activities.getCadeId()+"coupon_value:"+activities.getCoupon_value()+"coupon_mininum:"+activities.getCoupon_mininum()+"coupon_name:"+activities.getCoupon_name()+"coupon_desc:"+activities.getCoupon_desc()+"scope:"+activities.getScope()+"send_source:"+activities.getSend_source());
			rd.addUserVoucher(activities);
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("代金券发放成功信息存储时异常", e);
			return false;
		}
	}

	@Override
	public List<Voucher> getSendCoupon_stock_id(Voucher vouchers) {
		// TODO 自动生成的方法存根
		try {
			return rd.getSendCoupon_stock_id(vouchers);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("代金券通过时间查询时异常", e);
			return null;
		}
	}

	@Override
	public List<Activities> getActivitiesList(String date3, String like, String order, String sort, String typeId,
			Integer firstResult, Integer pageSize) {
		try {
			return rd.getActivitiesList(date3, like, order, sort, typeId, firstResult, pageSize);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("正常代金券查询时异常", e);
			return null;
		}
	}

	@Override
	public int getActivitiesCountList(Activities activity) {
		// TODO 自动生成的方法存根
		try {
			return rd.getActivitiesCountList(activity);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("正常代金券查询数量时异常", e);
			return 0;
		}
	}

	@Override
	public int getActivitiesCountLikeList(String activitsName) {
		// TODO 自动生成的方法存根
		try {
			return rd.getActivitiesCountLikeList(activitsName);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("正常代金券模糊查询数量时异常", e);
			return 0;
		}
	}

	@Override
	public List<Activities> getActivitiesLikeList(String activitsName, String like, String order, String sort,
			String typeId, Integer firstResult, Integer pageSize) {
		// TODO 自动生成的方法存根
		try {
			return rd.getActivitiesLikeList(activitsName, like, order, sort, typeId, firstResult, pageSize);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("正常代金券模糊查询时异常", e);
			return null;
		}
	}

	@Override
	public int queryOverdueVouchersCountBytime() {
		// TODO 自动生成的方法存根
		try {
			return rd.queryOverdueVouchersCountBytime();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("过期代金券查询数量时异常", e);
			return 0;
		}
	}

	@Override
	public List<Activities> queryOverdueVouchersBytime(String like, String order, String sort, String typeId,
			Integer firstResult, Integer pageSize) {
		// TODO 自动生成的方法存根
		try {
			return rd.queryOverdueVouchersBytime(like, order, sort, typeId, firstResult, pageSize);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("过期代金券查询时异常", e);
			return null;
		}
	}

	@Override
	public boolean addNoGetVouchers(Activities activity) {
		// TODO 自动生成的方法存根
		try {
			rd.addNoGetVouchers(activity);
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("用户代金券领取失败添加错误信息时异常", e);
			return false;
		}
	}

	@Override
	public int queryFzvoruserCount() {
		// TODO 自动生成的方法存根
		try {
			return rd.queryFzvoruserCount();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("代金券查询数量时异常", e);
			return 0;
		}
	}

	@Override
	public List<FzVorUser> queryFzvoruserList(String like, String order, String sort, String typeId,
			Integer firstResult, Integer pageSize) {
		// TODO 自动生成的方法存根
		try {
			return rd.queryFzvoruserList(like, order, sort, typeId, firstResult, pageSize);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			logger.error("代金券查询时异常", e);
			return null;
		}
	}

	@Override
	public boolean updatePromoney(Probability_fz probability_fz) {
		try {
			rd.updatePromoney(probability_fz);
			return true;
		} catch (Exception e) {
			logger.error("修改概率金额时异常", e);
			return false;
		}
	}

	@Override
	public List<Probability_fz> queryPromoneyByzipcode(Probability_fz probability_fz) {
		List<Probability_fz> list=new ArrayList<Probability_fz>();
		try {
			list=rd.queryPromoneyByzipcode(probability_fz);
			return list;
		} catch (Exception e) {
			logger.error("修改概率金额查询金额时异常", e);
			return null;
		}
	}

	@Override
	public boolean addCommissionSettlement(OrderMerchantPayment orderMerchantPayment){
		try {
			rd.addCommissionSettlement(orderMerchantPayment);
			return true;
		} catch (Exception e) {
			logger.error("佣金结算时异常", e);
			return false;
		}
	}

}
