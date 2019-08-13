package com.abbot.schimneylife.util;

/**
 * 
 * @author Administrator 常量值工具类 所需相关参数封装
 */
public class ConfigNativeUtil {

	/** 以下相关参数需要根据自己实际情况进行配置 */

	// 测试平台APPID
	public static String APP_ID = "wxc38e4811474d3052";
	public static String APP_SECRET = "3004fbfbb50f0c53465bb3673fcb4106";
	public static String MCH_ID = "1494502002";
	public static String API_KEY = "edeed090547ed28e090e353df22873dc";
	//生产环境
//	public static String APP_ID = "wxe230615e5b488eca";
//	public static String APP_SECRET = "ae810c7a83644eb612cdb3bd657a79ad";
//	public static String MCH_ID = "1491807662";
//	public static String API_KEY = "1339e89a296607c188771ad0adcc8138";
	/** 支付方式 NATIVE 扫码支付 */
	public static String TRADE_TYPE_NATIVE = "NATIVE";
	/** 支付方式 JSAPI 支付 */
	public static String TRADE_TYPE_JSAPI = "JSAPI";
	/**域名地址*/
	public static final String URL_COMPANY = "http://fangzhangsc.cn";
	/**金额不在1-2000间推送到加盟商模板消息*/
	public static final String MESSAGE_ALLIANCE = "付款金额超出限制";
	// 获取电脑IP
	public static String CREATE_IP = "222.223.103.164";// key
	/**企业付款证书路径*/
	public static String URL_CERTIFICATE="E:/ceshi201838/apiclient_cert.p12";
	// 统一下单接口
	public static String UFDODER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	// 回调地址支付后调用
	public static String NOTIFY_URL =  URL_COMPANY +"/NativeFangzhang/paymentResult.do";
	//转短连接
	public static String SHORT_URL = "https://api.mch.weixin.qq.com/tools/shorturl";
	// 被扫支付查询API
	public static String PAY_QUERY_API = "https://api.mch.weixin.qq.com/pay/orderquery";
	// 退款API
	public static String REFUND_API = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	// 退款查询API
	public static String REFUND_QUERY_API = "https://api.mch.weixin.qq.com/pay/refundquery";
	// 撤销API
	public static String REVERSE_API = "https://api.mch.weixin.qq.com/secapi/pay/reverse";
	// 下载对账单API
	public static String DOWNLOAD_BILL_API = "https://api.mch.weixin.qq.com/pay/downloadbill";
	// 统计上报API
	public static String REPORT_API = "https://api.mch.weixin.qq.com/payitil/report";
	/** OAUTH2网页授权认证接口 */
	public static final String URL_OAUTH2_GET_CODE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	public static final String URL_OAUTH2_GET_ACCESSTOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	public static final String URL_OAUTH2_GET_REFRESH_ACCESSTOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	public static final String URL_OAUTH2_GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	public static final String URL_OAUTH2_CHECK_ACCESSTOKEN = "https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
	/** 授权回调URL 手动授权时调用 */
	public static final String URL_OAUTH2_GET_PAGE = URL_COMPANY + "/NativeFangzhang/allianceObtainOauth.do";
	/** 授权回调URL 添加店员是静默授权时调用 */
	public static final String URL_OAUTH2_GET_SON_OPENID = URL_COMPANY + "/NativeFangzhang/son_openidGetcode.do";
	
	/** 授权回调URL 静默授权时调用 */
	public static final String URL_OAUTH2_GET_OPENID =  URL_COMPANY +"/NativeFangzhang/allianceNoObtainOauth.do";
	/** 授权回调URL 静默授权时调用 ,不去支付*/
	public static final String URL_OAUTH2_GET_OPENIDS =  URL_COMPANY +"/NativeFangzhang/ObtainOauth.do";
	/**授权回调URL 静默授权时调用 ,不去支付(红包)*/
	public static final String URL_OAUTH2_GET_OPENIDS_REDPACK =  URL_COMPANY +"/NativeFangzhang/red/ObtainOauth.do";
	/** 不弹出授权页面，直接跳转，只能获取用户OPENID */
	public static final String OAUTH2_SCOPE_BASE = "snsapi_base";
	/** 弹出授权页面，可通过OPENID拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息 */
	public static final String OAUTH2_SCOPE_USER_INFO = "snsapi_userinfo";
	/**企业付款个人调用接口*/
	public static String MENU_PAYMENT_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
	/**企业普通红包调用接口*/
	public static String MENU_REDENVELOPES_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	/**企业裂变红包调用接口*/
	public static String MENU_LIEBIAN_REDENVELOPES_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	/**长连接变短连接 */
	public static final String URL_LONGURL_TO_SHORTURL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";
	/**获取ACCESSTOEKN */
	public static final String URL_GET_ACCESSTOEKN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	/**发送消息模板*/
	public static  final String URL_TEMPLATE_MESSAGE="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	/**发送代金券*/
	public static final String URL_SEND_VOUCHER="https://api.mch.weixin.qq.com/mmpaymkttransfers/send_coupon";
	/**查寻代金券*/
	public static final String URL_VOUCHER_INFO="https://api.mch.weixin.qq.com/mmpaymkttransfers/querycouponsinfo";
	/**菜单创建（POST） 限100（次/天）*/
	public  static final String URL_MEAN_CREAT="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	/////////////////////////
	//////JsapiTicket
	/////////////////////////
	public static final String URL_GET_JS_API_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	/////////////////////////
	//////JsapiTicket卡券
	/////////////////////////
	public static final String URL_GET_JS_API_wx_card = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=wx_card";
}