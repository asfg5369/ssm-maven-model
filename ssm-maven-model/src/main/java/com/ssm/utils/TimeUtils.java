package com.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 
 *
 */
public final class TimeUtils {

	/**
	 * 获取当前时间
	 */
	public static String getTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d); 
	}

}
