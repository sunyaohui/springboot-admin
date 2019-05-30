package com.hzy.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {

	public static final String FORMAT_DATE = "yyyy-MM-dd";
	public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_TIME = "HH:mm:ss";

	private static SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);

	private static SimpleDateFormat datetimeFormat = new SimpleDateFormat(FORMAT_DATE_TIME);

	private static SimpleDateFormat timeFormat = new SimpleDateFormat(FORMAT_TIME);

	private static Map<String, SimpleDateFormat> formatMap = new HashMap<String, SimpleDateFormat>();

	public static final long SECOND_MILL = 1000l;

	public static final long MINUTE_MILL = 60 * 1000l;

	public static final long HOUR_MILL = 60 * 60 * 1000l;

	public static final long DAY_MILL = 24 * 60 * 60 * 1000l;

	static {
		formatMap.put(FORMAT_DATE, dateFormat);
		formatMap.put(FORMAT_DATE_TIME, datetimeFormat);
		formatMap.put(FORMAT_TIME, timeFormat);
	}

	/**
	 * 当前日期 yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String today() {
		return formatDate(new Date());
	}

	/**
	 * 昨天日期 yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String yestoday() {
		return formatDate(addDay(new Date(), -1));
	}

	/**
	 * yyyy-MM-dd HH
	 * 
	 * @return
	 */
	public static String lastHour() {
		return formatDate(addHours(new Date(), -1), "yyyy-MM-dd HH");
	}

	/**
	 * yyyy-MM-dd HH
	 * 
	 * @return
	 */
	public static String currentHour() {
		return formatDate(new Date(), "yyyy-MM-dd HH");
	}

	/**
	 * 当前时间yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentDateTime() {
		return formatDateTime(new Date());
	}

	/**
	 * 日期格式化 yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		return formatDate(date, FORMAT_DATE);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, FORMAT_DATE_TIME);
	}

	/**
	 * HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String formatTime(Date date) {
		return formatDate(date, FORMAT_TIME);
	}

	/**
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		if (formatMap.containsKey(format)) {
			return formatMap.get(format).format(date);
		}

		addDateFormat(format);

		return formatMap.get(format).format(date);
	}

	/**
	 * 
	 * @param format
	 */
	public static void addDateFormat(String format) {
		synchronized (formatMap) {
			SimpleDateFormat timeFormat = new SimpleDateFormat(format);
			formatMap.put(format, timeFormat);
		}
	}

	/**
	 * yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseDate(String date) {
		return parseDate(date, FORMAT_DATE);
	}

	/**
	 * HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseDateTime(String date) {
		return parseDate(date, FORMAT_DATE_TIME);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseTime(String date) {
		return parseDate(date, FORMAT_DATE_TIME);
	}

	/**
	 * 
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date parseDate(String date, String format) {

		try {

			if (formatMap.containsKey(format)) {
				return formatMap.get(format).parse(date);
			}

			addDateFormat(format);

			return formatMap.get(format).parse(date);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addDay(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, amount);
		return c.getTime();
	}

	/**
	 * 
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addHours(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR, amount);
		return c.getTime();
	}

	/**
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addMinute(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, amount);
		return c.getTime();
	}

	/**
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addSecond(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.SECOND, amount);
		return c.getTime();
	}

	/**
	 * 
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addYear(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, amount);
		return c.getTime();
	}

	/**
	 * 
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addMonth(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, amount);
		return c.getTime();
	}

	/**
	 * 获得当前年份第一天
	 * 
	 * @return
	 */
	public static Date getFirstDayOfYear() {
		return getFirstDayOfYear(new Date());
	}

	/**
	 * 获取一年的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_YEAR, 1);
		return c.getTime();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public static Date getLastDayOfYear() {
		return getLastDayOfYear(new Date());
	}

	/**
	 * 
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfYear(Date date) {
		Date firstDate = getFirstDayOfYear(date);// 当年第一天
		Calendar c = Calendar.getInstance();
		c.setTime(firstDate);
		c.add(Calendar.YEAR, 1);// 下一年第一天
		c.set(Calendar.DAY_OF_YEAR, -1);// 当年最后一天
		return c.getTime();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public static Date getFirstDayOfMonth() {
		return getFirstDayOfMonth(new Date());
	}

	/**
	 * 获取指定月份的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public static Date getLastDayOfMonth() {
		return getLastDayOfMonth(new Date());
	}

	/**
	 * 
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
		Date firstDate = getFirstDayOfMonth(date);// 当月第一天
		Calendar c = Calendar.getInstance();
		c.setTime(firstDate);
		c.add(Calendar.MONTH, 1);// 下个月第一天
		c.set(Calendar.DAY_OF_MONTH, -1);// 当月最后一天
		return c.getTime();
	}

	/**
	 * 获取当前小时的时间，分秒都为0
	 * 
	 * @return
	 */
	public static Date getCurrentHour() {
		return getCurrentHour(new Date());
	}

	/**
	 * 获取当前小时的时间，分秒都为0
	 * 
	 * @param date
	 * @return
	 */
	public static Date getCurrentHour(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取当前分钟的时间，秒为0
	 * 
	 * @return
	 */
	public static Date getCurrentMinute() {
		return getCurrentMinute(new Date());
	}

	/**
	 * 获取当前分钟的时间，秒都为0
	 * 
	 * @param date
	 * @return
	 */
	public static Date getCurrentMinute(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

}
