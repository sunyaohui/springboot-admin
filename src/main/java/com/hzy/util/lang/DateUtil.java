package com.hzy.util.lang;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtil {
	
	public static final String DAY="day";
	public static final String HOUR="hour";
	public static final String MINUTE="minute";
	public static final String SECOND="second";
	
	private final static Log log = LogFactory.getLog(DateUtil.class);

	/**
	 * 获取现在时间
	 *
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	 */
	public static Date getNowDate() {
		SimpleDateFormat formatter_full = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter_full.format(currentTime);
		ParsePosition pos = new ParsePosition(0);
		Date currentTime_2 = formatter_full.parse(dateString, pos);
		return currentTime_2;
	}
	
	/**
	 * 获取当前时间
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrentTime(){
		SimpleDateFormat formatter_full = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter_full.format(currentTime);
		return dateString;
	}
	
	/**
	 * 获取当前时间
	 * @return yyyyMMddHHmmss
	 */
	public static String getCurrentTime2(){
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	
	/**
	 * 获取当前日期
	 * @return yyyy-MM-dd
	 */
	public static String getCurrentDate(){
		SimpleDateFormat formatter_date = new SimpleDateFormat("yyyy-MM-dd");
		return formatter_date.format(new Date());
	}

	/**
	 * 获取现在时间
	 *
	 * @return返回短时间格式 yyyy-MM-dd
	 */
	public static Date getNowDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(0);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
	 * 获取现在时间
	 *
	 * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getStringDate() {
		SimpleDateFormat formatter_full = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter_full.format(currentTime);
		return dateString;
	}

	/**
	 * 获取现在时间
	 *
	 * @return 返回短时间字符串格式yyyy-MM-dd
	 */
	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取时间 小时:分;秒 HH:mm:ss
	 *
	 * @return
	 */
	public static String getTimeShort() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 *
	 * @param strDate
	 * @return
	 */
	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter_full = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter_full.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 *
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong(java.util.Date dateDate) {
		SimpleDateFormat formatter_full = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter_full.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 *
	 * @param dateDate
	 * @return
	 */
	public static String dateToStr(java.util.Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 *
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}



	/**
	 * 得到现在时间
	 *
	 * @return
	 */
	public static Date getNow() {
		Date currentTime = new Date();
		return currentTime;
	}

	/**
	 * 提取一个月中的最后一天
	 *
	 * @param day
	 * @return
	 */
	public static Date getLastDate(long day) {
		Date date = new Date();
		long date_3_hm = date.getTime() - 3600000 * 34 * day;
		Date date_3_hm_date = new Date(date_3_hm);
		return date_3_hm_date;
	}

	/**
	 * 得到现在时间
	 *
	 * @return 字符串 yyyyMMdd HHmmss
	 */
	public static String getStringToday() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 得到现在小时
	 */
	public static String getHour() {
		SimpleDateFormat formatter_full = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter_full.format(currentTime);
		String hour;
		hour = dateString.substring(11, 13);
		return hour;
	}

	/**
	 * 得到现在分钟
	 *
	 * @return
	 */
	public static String getTime() {
		SimpleDateFormat formatter_full = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter_full.format(currentTime);
		String min;
		min = dateString.substring(14, 16);
		return min;
	}

	/**
	 * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
	 *
	 * @param sformat
	 *            yyyyMMddhhmmss
	 * @return
	 */
	public static String getUserDate(String sformat) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	 */
	public static String getTwoHour(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
			return "0";
		else {
			double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1]) / 60;
			double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1]) / 60;
			if ((y - u) > 0)
				return y - u + "";
			else
				return "0";
		}
	}

	/**
	 * 得到二个日期间的间隔天数
	 */
	public static String getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		long day = 0;
		try {
			java.util.Date date = myFormatter.parse(sj1);
			java.util.Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}

	/**
	 * 时间前推或后推分钟,其中JJ表示分钟.
	 */
	public static String getPreTime(String sj1, String jj) {
		SimpleDateFormat formatter_full = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mydate1 = "";
		try {
			Date date1 = formatter_full.parse(sj1);
			long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
			date1.setTime(Time * 1000);
			mydate1 = formatter_full.format(date1);
		} catch (Exception e) {
		}
		return mydate1;
	}
	
	/**
	 * 指定时间往后推多少秒；返回时间格式
	 * @param date 指定
	 * @param ss
	 * @return
	 */
	public static Date getExPreTime(Date date,String ss){
		try {
			long timeStamp = date.getTime(); 
			return new Date(timeStamp+Long.valueOf(ss)*1000);
		} catch (Exception e) {
			log.error("DateUtil getExpreTime failed", e);
			return null;
		}
	}

	/**
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
	 */
	public static String getNextDay(String nowdate, String delay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String mdate = "";
			Date d = strToDate(nowdate);
			long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
			d.setTime(myTime * 1000);
			mdate = format.format(d);
			return mdate;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 判断是否润年
	 *
	 * @param ddate
	 * @return
	 */
	public static boolean isLeapYear(String ddate) {

		/**
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰年
		 */
		Date d = strToDate(ddate);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		int year = gc.get(Calendar.YEAR);
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0) {
			if ((year % 100) == 0)
				return false;
			else
				return true;
		} else
			return false;
	}

	/**
	 * 返回美国时间格式 26 Apr 2006
	 *
	 * @param str
	 * @return
	 */
	public static String getEDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(str, pos);
		String j = strtodate.toString();
		String[] k = j.split(" ");
		return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
	}

	/**
	 * 获取一个月的最后一天
	 *
	 * @param dat
	 * @return
	 */
	public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd
		String str = dat.substring(0, 8);
		String month = dat.substring(5, 7);
		int mon = Integer.parseInt(month);
		if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
			str += "31";
		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			str += "30";
		} else {
			if (isLeapYear(dat)) {
				str += "29";
			} else {
				str += "28";
			}
		}
		return str;
	}
	
	/**
	 * 获得 num 天的信息 <br/>
	 * num = 0  为当天<br/>
	 * num = -1 为昨天<br/>
	 * num = 1 为明天
	 * @param num
	 * @return yyyy-MM-dd
	 */
	public static String getNumDay( int num ){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, num );
		
		return sdf.format(cal.getTime()) ;
	}
	
	/**
	 * 获得 num 个月的月份信息 <br>
	 * num = 0 为当前月<br/>
	 * num = -1 为上个月<br/>
	 * num = 1 为下个月
	 * @param num
	 * @return yyyy-MM
	 */
	public static String getNumMonth( int num ){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, num);
		
		return sdf.format(cal.getTime()) ;
	}
	
	/**
	 * 获得 num 个年的年份信息 <br>
	 * num = 0 为当前年<br/>
	 * num = -1 为上个年<br/>
	 * num = 1 为下个年
	 * @param num
	 * @return yyyy
	 */
	public static String getNumYear( int num ){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, num);
		
		return sdf.format(cal.getTime()) ;
	}
	
	/**
	 * 获得 num 个月的第一天 <br>
	 * num = 0 为当前月<br/>
	 * num = -1 为上个月<br/>
	 * num = 1 为下个月
	 * @param num
	 * @return
	 */
	public static String getNumMonthFirst( int num ){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, num);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		return sdf.format(cal.getTime()) ;
	}
	
	/**
	 * 获得 num 个月的最后一天 <br>
	 * num = 0 为当前月<br/>
	 * num = -1 为上个月<br/>
	 * num = 1 为下个月
	 * @param num
	 * @return
	 */
	public static String getNumMonthEnd( int num ){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, num+1);
		//获取最后一天要稍微变通一点 , 先将日期设置为下个月的第一天, 然后减一天
		cal.set(Calendar.DAY_OF_MONTH, 1); 
		cal.add(Calendar.DATE, -1);
		
		return sdf.format(cal.getTime()) ;
	}

	/**
	 * 判断二个时间是否在同一个周
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameWeekDates(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (0 == subYear) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
			// 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}

	/**
	 * 产生周序列,即得到当前时间所在的年度是第几周
	 *
	 * @return
	 */
	public static String getSeqWeek() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
			week = "0" + week;
		String year = Integer.toString(c.get(Calendar.YEAR));
		return year + week;
	}

	/**
	 * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
	 *
	 * @param sdate
	 * @param num
	 * @return
	 */
	public static String getWeek(String sdate, String num) {
		// 再转换为时间
		Date dd = DateUtil.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(dd);
		if (num.equals("1")) // 返回星期一所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		else if (num.equals("2")) // 返回星期二所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		else if (num.equals("3")) // 返回星期三所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		else if (num.equals("4")) // 返回星期四所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		else if (num.equals("5")) // 返回星期五所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		else if (num.equals("6")) // 返回星期六所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		else if (num.equals("0")) // 返回星期日所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}
	
	/**
	 * 获取num个星期的星期几
	 * @param weekDay 需要获取星期几 - 不符合标准则默认星期一
	 * @param num		多少个星期 <br/> 0 : 为本周 <br/> -1 : 为上周 <br/> 1 : 下周 <br/> 以此类推
	 * @return
	 */
	public static String getWeek( int weekDay , int num ){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, num*7);
		//设置一个星期的第一天为周一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		switch (weekDay) {
		case 1:
			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			break;
		case 2:
			cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			break;
		case 3:
			cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
			break;
		case 4:
			cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
			break;
		case 5:
			cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			break;
		case 6:
			cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
			break;
		case 7:
			cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			break;
		default:
			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			break;
		}

		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()); 
	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 *
	 * @param sdate
	 * @return
	 */
	public static String getWeek(String sdate) {
		// 再转换为时间
		Date date = DateUtil.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	public static String getWeekStr(String sdate) {
		String str = "";
		str = DateUtil.getWeek(sdate);
		if ("1".equals(str)) {
			str = "星期日";
		} else if ("2".equals(str)) {
			str = "星期一";
		} else if ("3".equals(str)) {
			str = "星期二";
		} else if ("4".equals(str)) {
			str = "星期三";
		} else if ("5".equals(str)) {
			str = "星期四";
		} else if ("6".equals(str)) {
			str = "星期五";
		} else if ("7".equals(str)) {
			str = "星期六";
		}
		return str;
	}

	/**
	 * 两个时间之间的天数
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDays(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		// 转换为标准时间
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = myFormatter.parse(date1);
			Date mydate = myFormatter.parse(date2);
			long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
			return day;
		} catch (Exception e) {
		}
		return 0;
	}
	
	/**
	 * 两个时间时间差，date1>date2 返回正数
	 *
	 * @param date1 yyyy-MM-dd HH:mm:ss
	 * @param date2 yyyy-MM-dd HH:mm:ss
	 * @param type day、 hour、minute、second
	 * @return
	 */
	public static long getTimeDiffrence(String date1, String date2,String type) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;

		if(type.equals(DateUtil.DAY)){
			return getDays(date1, date2);
		}else if(type.equals(DateUtil.HOUR)){
			Date date = strToDateLong(date1);
			Date mydate = strToDateLong(date2);
			long hours = (date.getTime() - mydate.getTime()) / (60 * 60 * 1000);		
			return hours;
		}else if(type.equals(DateUtil.MINUTE)){
			Date date = strToDateLong(date1);
			Date mydate = strToDateLong(date2);
			long minutes = (date.getTime() - mydate.getTime()) / (60 * 1000);		
			return minutes;
		}else if(type.equals(DateUtil.SECOND)){
			Date date = strToDateLong(date1);
			Date mydate = strToDateLong(date2);
			long seconds = (date.getTime() - mydate.getTime()) / (1000);		
			return seconds;
		}
		return 0;
	}

	/**
	 * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
	 * 此函数返回该日历第一行星期日所在的日期
	 *
	 * @param sdate
	 * @return
	 */
	public static String getNowMonth(String sdate) {
		// 取该时间所在月的一号
		sdate = sdate.substring(0, 8) + "01";

		// 得到这个月的1号是星期几
		Date date = DateUtil.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int u = c.get(Calendar.DAY_OF_WEEK);
		String newday = DateUtil.getNextDay(sdate, (1 - u) + "");
		return newday;
	}

	/**
	 * 取得数据库主键 生成格式为yyyyMMddHHmmss+k位随机数
	 *
	 * @param k
	 *            表示是取几位随机数，可以自己定
	 */

	public static String getNo(int k) {

		return getUserDate("yyyyMMddHHmmss") + getRandom(k);
	}

	/**
	 * 返回一个随机数
	 *
	 * @param i
	 * @return
	 */
	public static String getRandom(int i) {
		Random jjj = new Random();
		// int suiJiShu = jjj.nextInt(9);
		if (i == 0)
			return "";
		String jj = "";
		for (int k = 0; k < i; k++) {
			jj = jj + jjj.nextInt(9);
		}
		return jj;
	}

	/**
	 */
	public static boolean RightDate(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		;
		if (date == null)
			return false;
		if (date.length() > 10) {
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		try {
			sdf.parse(date);
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}


	/**
	 * 当前天加minute
	 * @param minute
	 * @return
	 * @author zp
	 */
	public static Date addMinute(int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}
	
	public static Date addSecond(Date date,int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND,second);
		return calendar.getTime();
	}
	
	/**
	 * 获得 num 天的信息 <br/>
	 * num = 0  为当天<br/>
	 * num = -1 为昨天<br/>
	 * num = 1 为明天
	 * @param num
	 * @return yyyy-MM-dd
	 */
	public static Date getDayNum(Date date, int num ){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, num );	
		return cal.getTime();
	}
	
	/**
	 * 获得 num 个月的月份信息 <br>
	 * num = 0 为当前月<br/>
	 * num = -1 为上个月<br/>
	 * num = 1 为下个月
	 * @param num
	 * @return yyyy-MM
	 */
	public static Date getMonthNum(Date date,int num ){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, num);	
		return cal.getTime();
	}
	
	/**
	 * 获得 num 个年的年份信息 <br>
	 * num = 0 为当前年<br/>
	 * num = -1 为上个年<br/>
	 * num = 1 为下个年
	 * @param num
	 * @return yyyy
	 */
	public static Date getYearNum(Date date,int num ){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, num);		
		return cal.getTime();
	}
	
	public static void main(String[] args) {
//		System.out.println(getWeek(7, -1));
//		System.out.println(getNumMonthFirst(-2));
//		System.out.println(getNumMonthEnd(-2));
//		System.out.println(getNumDay(-1));
		Date date = new Date();
		System.out.println(date);
		System.out.println(addSecond(date,-1));
	}
}
