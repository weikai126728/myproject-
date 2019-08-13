package com.abbot.schimneylife.service.shopping;

import com.abbot.schimneylife.vo.AlibabaTradeGetLogisticsInfosBuyerViewParam;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.logistics.param.AlibabaTradeGetLogisticsTraceInfoBuyerViewParam;
import com.alibaba.logistics.param.AlibabaTradeGetLogisticsTraceInfoBuyerViewResult;
import com.alibaba.trade.param.AlibabaAlipayUrlGetParam;
import com.alibaba.trade.param.AlibabaAlipayUrlGetResult;
import com.alibaba.trade.param.AlibabaTradeCancelParam;
import com.alibaba.trade.param.AlibabaTradeCancelResult;
import com.alibaba.trade.param.AlibabaTradeFastCreateOrderParam;
import com.alibaba.trade.param.AlibabaTradeFastCreateOrderResult;
import com.alibaba.trade.param.AlibabaTradeGetBuyerViewParam;
import com.alibaba.trade.param.AlibabaTradeGetBuyerViewResult;

public interface AlibabaService {

	/**
	 * 根据商品id获取商品信息
	 * @param productID
	 * @return
	 * @throws Exception
	 */
	JSONObject getProduct(String productID)throws Exception;
	/**
	 * 快速创建1688订单
	 * @param orderParam
	 * @return
	 * @throws Exception
	 */
	AlibabaTradeFastCreateOrderResult fastCreateOrder(AlibabaTradeFastCreateOrderParam orderParam)throws Exception;
	/**
	 * 取消订单交易
	 * @param param
	 * @return
	 * @throws Exception
	 */
	AlibabaTradeCancelResult tradeCancel(AlibabaTradeCancelParam param)throws Exception;
	/**
	 * 获取支付宝支付链接
	 * @param param
	 * @return
	 * @throws Exception
	 */
	AlibabaAlipayUrlGetResult getAlipayUrl(AlibabaAlipayUrlGetParam param)throws Exception; 
	/**
	 * 买家视角获取物流信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	JSONObject getLogisticsInfos(AlibabaTradeGetLogisticsInfosBuyerViewParam param)throws Exception;
	/**
	 * 买家视角获取物流跟踪信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	AlibabaTradeGetLogisticsTraceInfoBuyerViewResult getLogisticsTraceInfo(AlibabaTradeGetLogisticsTraceInfoBuyerViewParam param)throws Exception;
	/**
	 * 订单详情查看(买家视角)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	AlibabaTradeGetBuyerViewResult getBuyerView(AlibabaTradeGetBuyerViewParam param)throws Exception;
}
