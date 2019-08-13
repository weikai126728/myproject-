package com.abbot.schimneylife.util;

import java.util.Calendar;

public class OrderNumberUtil {

	/**
	 * 生成订单编号  生成规则：年+月+日+时间戳后8位
	 * @return
	 */
	public static String getOrderNumber() {
		Calendar calendar = Calendar.getInstance();
		String year = calendar.get(Calendar.YEAR)+"";
		int m = calendar.get(Calendar.MONTH)+1;
		String month = "";
		if(m<10) {
			month = "0"+m;
		}else {
			month = ""+m;
		}
		String day = "";
		int d = calendar.get(Calendar.DAY_OF_MONTH);
		if(d<10) {
			day = "0"+d;
		}else {
			day = ""+d;
		}
		return year+month+day+String.valueOf(calendar.getTimeInMillis()).substring(5);
	}
}
