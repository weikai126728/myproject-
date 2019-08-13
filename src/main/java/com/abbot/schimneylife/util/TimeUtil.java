package com.abbot.schimneylife.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public static long getTimeCha(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//Calendar calendar = Calendar.getInstance();
		Date today = null;
		Date chooseDate = null;
		try {
			today = sdf.parse(sdf.format(new Date()));
			chooseDate = sdf.parse(date);//将选择是日期转换成Date
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//将今天的日期格式化成 yyyy-MM-dd
		long t =today.getTime()- chooseDate.getTime() ;	//计算两个日期的时间差
		long d = t / (1000 * 60 * 60 * 24);	//计算两个日期相
		return d;
	}
	
}
