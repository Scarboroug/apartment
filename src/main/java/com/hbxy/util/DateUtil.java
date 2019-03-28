package com.hbxy.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class DateUtil
{
	/**
	 * 按照yyyy-MM-dd的格式，日期转字符串
	 * @param date
	 * @return yyyy-MM-dd
	 */
	public static String date2Str(Date date) {
		return date2Str(date, "yyyy-MM-dd");
	}
	
	/**
	 * 按照yyyy-MM-dd的格式，字符串转日期
	 * @param date
	 * @return
	 */
	public static Date str2Date(String date) {
		if (notEmpty(date)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new Date();
		} else {
			return null;
		}
	}
	
	/**
	 * 按照指定格式的格式，字符串转日期
	 * @param date
	 * @return
	 */
	public static Date str2Date(String date, String fmt) {
		if (notEmpty(date)) {
			SimpleDateFormat sdf = new SimpleDateFormat(fmt);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new Date();
		} else {
			return null;
		}
	}

	/**
	 * 按照参数format的格式，日期转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date, String format) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} else {
			return "";
		}
	}
	
	/**
	 * 检测字符串是否不为空(null,"","null")
	 * @param s
	 * @return 不为空则返回true，否则返回false
	 */
	public static boolean notEmpty(String s) {
		return s != null && !"".equals(s) && !"null".equals(s);
	}
}
