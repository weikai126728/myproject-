package com.abbot.schimneylife.serviceImpl.shopping;

import org.springframework.stereotype.Service;

import com.abbot.schimneylife.service.shopping.AlibabaService;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.vo.AlibabaAgentProductGetParam;
import com.abbot.schimneylife.vo.AlibabaTradeGetLogisticsInfosBuyerViewParam;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.logistics.param.AlibabaTradeGetLogisticsTraceInfoBuyerViewParam;
import com.alibaba.logistics.param.AlibabaTradeGetLogisticsTraceInfoBuyerViewResult;
import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.trade.param.AlibabaAlipayUrlGetParam;
import com.alibaba.trade.param.AlibabaAlipayUrlGetResult;
import com.alibaba.trade.param.AlibabaTradeCancelParam;
import com.alibaba.trade.param.AlibabaTradeCancelResult;
import com.alibaba.trade.param.AlibabaTradeFastCreateOrderParam;
import com.alibaba.trade.param.AlibabaTradeFastCreateOrderResult;
import com.alibaba.trade.param.AlibabaTradeGetBuyerViewParam;
import com.alibaba.trade.param.AlibabaTradeGetBuyerViewResult;
@Service
public class AlibabaServiceImpl implements AlibabaService {

	@Override
	public JSONObject getProduct(String productID) throws Exception {
		ApiExecutor apiExecutor = this.getExecutor();
		AlibabaAgentProductGetParam product = new AlibabaAgentProductGetParam();
		product.setProductID(Long.valueOf(productID));
		product.setWebSite("1688");
		return apiExecutor.execute(product);
	}
	
	@Override
	public AlibabaTradeFastCreateOrderResult fastCreateOrder(AlibabaTradeFastCreateOrderParam orderParam) throws Exception {
		ApiExecutor apiExecutor = this.getExecutor();
		return apiExecutor.execute(orderParam);
	}

	@Override
	public AlibabaTradeCancelResult tradeCancel(AlibabaTradeCancelParam param) throws Exception {
		ApiExecutor apiExecutor = this.getExecutor();
		return apiExecutor.execute(param);
	}

	private ApiExecutor getExecutor() {
		return  new ApiExecutor(ConfigureUtil.ALIBABA_SERVERHOST.toString()
				,Integer.valueOf(ConfigureUtil.ALIBABA_HTTPPORT.toString())
				,Integer.valueOf(ConfigureUtil.ALIBABA_HTTPSPORT.toString())
				,ConfigureUtil.ALIBABA_APPKEY.toString()
				,ConfigureUtil.ALIBABA_SECKEY.toString());
	}

	@Override
	public AlibabaAlipayUrlGetResult getAlipayUrl(AlibabaAlipayUrlGetParam param) throws Exception {
		ApiExecutor apiExecutor = this.getExecutor();
		return apiExecutor.execute(param);
	}

	

	@Override
	public JSONObject getLogisticsInfos(AlibabaTradeGetLogisticsInfosBuyerViewParam param) throws Exception {
		ApiExecutor apiExecutor = this.getExecutor();
		return apiExecutor.execute(param);
//		Map<String,Object> parameters = new HashMap<>();
//		parameters.put("webSite", param.getWebSite());
//		parameters.put("orderId", param.getOrderId());
//		parameters.put("fields", param.getFields());
//		String result = AlibabaRequestUtil.request(param.getOceanApiId().getNamespace(), param.getOceanApiId().getName(), parameters);
//		return JSONObject.parseObject(result);
	}

	@Override
	public AlibabaTradeGetLogisticsTraceInfoBuyerViewResult getLogisticsTraceInfo(
			AlibabaTradeGetLogisticsTraceInfoBuyerViewParam param) throws Exception {
		ApiExecutor apiExecutor = this.getExecutor();
		return apiExecutor.execute(param);
	}

	@Override
	public AlibabaTradeGetBuyerViewResult getBuyerView(AlibabaTradeGetBuyerViewParam param) throws Exception {
		ApiExecutor apiExecutor = this.getExecutor();
		return apiExecutor.execute(param);
	}

	
}
