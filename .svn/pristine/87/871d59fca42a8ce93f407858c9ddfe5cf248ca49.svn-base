package com.abbot.schimneylife.util;

/**
 * 公共变量类
 * 
 * @author xinye
 *
 */
public class CommonKey {
	public static final int SUCCESS_CODE = 0;// 通过
	public static final int ERROR_CODE = 1;// 异常
	public static final int LOSE_CODE = 2;// 权限失效

	public static final int WAP_PAGESIZE = 5;// wap初始页面加载数据量

	public static final int SERVICE_REFUND_ONLY = 1;// 仅退款
	public static final int SERVICE_REFUNDS = 2;// 退货退款
	public static final int SERVICE_EXCHANGE  = 3;// 换货
	
	public static final int service_status = 0;// 申请售后
	public static final int service_status_agree = 1;// 同意
	public static final int service_status_disagree = -1;// 拒绝

	/**
	 * 1688订单发货
	 */
	public static final String ORDER_ANNOUNCE_SENDGOODS = "ORDER-ANNOUNCE_SENDGOODS";// 1688订单发货
	public static final String ORDER_ORDER_BOPS_CLOSE = "ORDER-ORDER_BOPS_CLOSE";// 1688运营后台关闭订单
	public static final String ORDER_ORDER_PRICE_MODIFY = "ORDER-ORDER_PRICE_MODIFY";// 1688修改订单价格
	public static final String ORDER_ORDER_SELLER_CLOSE = "ORDER-ORDER_SELLER_CLOSE";// 1688卖家关闭订单
	public static final String ORDER_ORDER_COMFIRM_RECEIVEGOODS = "ORDER-ORDER_COMFIRM_RECEIVEGOODS";// 1688订单确认收货
	public static final String ORDER_ORDER_SUCCESS = "ORDER-ORDER_SUCCESS";// 1688交易成功
	public static final String ORDER_PAY = "ORDER_PAY";// 1688交易付款
	public static final String PRODUCT_EXPIRE = "PRODUCT_EXPIRE";//1688产品下架
	public static final String PRODUCT_NEW_OR_MODIFY = "PRODUCT_NEW_OR_MODIFY";//1688产品新增或修改
	public static final String PRODUCT_DELETE = "PRODUCT_DELETE";//1688产品删除
	/**
	 * 禁用
	 */
	public static final int DISABLE_FLAG = 0;
	/**
	 * 启用
	 */
	public static final int ENABLE_FLAG = 1;

	/**
	 * 广播事件类型
	 */
	public static final int EVENT_TYPE_RADIO = 0;
	/**
	 * 消息事件类型
	 */
	public static final int EVENT_TYPE_TIDINGS = 1;

	/**
	 * �û���Ϣ��ͨ�ñ���
	 * 
	 * @author xinye
	 *
	 */
	public static class User {
		/**
		 * 性别
		 * 
		 * @author xinye
		 *
		 */
		public enum Sex {
			MALE(1), FEMALE(0);
			private Integer value;

			private Sex(Integer value) {
				this.value = value;
			}

			public Integer getValue() {
				return this.value;
			}
		}

		/**
		 * 状态̬
		 * 
		 * @author xinye
		 *
		 */
		public enum Status {
			ENABLE(1), DISABLE(0);
			private Integer value;

			private Status(Integer value) {
				this.value = value;
			}

			public Integer getValue() {
				return this.value;
			}
		}
	}

	public enum Role {
		SUPERMANAGER(-1), //超級管理員
		MANAGER(0), //普通管理员
		AGENT(1), //代理商
		SUPERMARKET(2),//商超管理员
		MEMBER(3),//商城会员
		BUSINESSMANAGER(4),//业务主管
		SALESMAN(5),//业务员
		CASHIER(6),//收银员
		LINERED(8);//网红
		private Integer level;

		private Role(Integer level) {
			this.level = level;
		}

		public Integer getLevel() {
			return this.level;
		}
	}

	public enum ProductSource {
		SELFSUPPORT(0), AliPROXY(1), AliBUY(2);
		private Integer source;

		private ProductSource(Integer source) {
			this.source = source;
		}

		public Integer getSource() {
			return this.source;
		}
	}

	public enum EvaluateType {
		MALL(1), MARKET(2);
		private Integer type;

		private EvaluateType(Integer type) {
			this.type = type;
		}

		public Integer getType() {
			return this.type;
		}
	}

	public enum EvaluateStatus {
		DISABLE(0), ENABLE_NO_AUDITING(1), ENABLE_AUDITINGED(2);
		private Integer status;

		private EvaluateStatus(Integer status) {
			this.status = status;
		}

		public Integer getStatus() {
			return this.status;
		}
	}

	public enum EvaluateLevel {
		ORIGINAL(0), ADD(1);
		private Integer level;

		private EvaluateLevel(Integer level) {
			this.level = level;
		}

		public Integer getLevel() {
			return this.level;
		}
	}

	public enum Order {
		FAILED(-2)// 交易失败
		, CANCEL(-1)// 交易关闭
		, NO_PAY(0)// 未付款
		, NO_SEND_NO_SETTLEMENT(1)// 已付款未结算（未发货）
		, NO_SEND_SETTLEMENT(2)// 已付款已结算（未发货）
		, NO_GOT(3)// 未收货
		, SUCCESS_NO_EVALUATE(4)// 交易成功未评价
		, SUCCESS_EVALUATE(5)// 交易成功已评价
		, CASHBACK_OK(1)// 交易成功已评价
		, CASHBACK_NO(0);// 交易成功已评价
		private Integer status;

		private Order(Integer status) {
			this.status = status;
		}

		public Integer getStatus() {
			return this.status;
		}
	}

	public enum UserOperationLog {
		LOGIN(0), ORDER(1), PRODUCT(2);
		private Integer type;

		private UserOperationLog(Integer type) {
			this.type = type;
		}

		public Integer getType() {
			return this.type;
		}
	}

	public enum WXTradeType {
		JSAPI("JSAPI"), NATIVE("NATIVE"), APP("APP");
		private String type;

		private WXTradeType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}

	public enum BannerType {
		MOBILE(1),
		POBILE(2);
		private Integer type;

		private BannerType(Integer type) {
			this.type = type;
		}

		public Integer getType() {
			return this.type;
		}
	}

}