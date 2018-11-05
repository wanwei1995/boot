package com.ww.springboot.boot.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import org.springframework.util.StringUtils;


public class DateUtil {
	public static final String DAY = "day";
	public static final String WEEK = "week";
	public static final String MONTH = "month";
	public static final String YESTERDAY = "yesterday";
	public static final String LASTWEEK = "lastWeek";
	public static final String LASTMONTH = "lastMonth";
	public static final String ISO_DATE_FORMAT = "yyyyMMdd";
	public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";
	public static String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String CHINESE_EXPANDED_DATE_FORMAT = "yyyy年MM月dd日";
	private static boolean LENIENT_DATE = false;

	public static Date getNowDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(1), cal.get(2), cal.get(5), 0, 0, 0);
		cal.set(14, 0);
		return convertCalToTs(cal);
	}

	public static java.sql.Date getTodayDate() {
		Calendar c = Calendar.getInstance();
		java.sql.Date now = new java.sql.Date(c.getTimeInMillis());
		return now;
	}

	public static Timestamp getNowTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static Timestamp convertCalToTs(Calendar cald) {
		return new Timestamp(cald.getTime().getTime());
	}

	public static Calendar convertTsToCal(Timestamp ts) {
		Calendar cald = Calendar.getInstance();
		cald.setTime(new Date(ts.getTime()));
		return cald;
	}

	public static Date convertTsToDt(Timestamp ts) {
		return new Date(ts.getTime());
	}

	public static Timestamp convertDtToTs(Date dt) {
		return new Timestamp(dt.getTime());
	}

	public static String convertTsToStr(Timestamp ts) {
		return ts != null ? ts.toString().substring(0, 10) : "";
	}

	public static String convertTsToStrWithSecs(Timestamp ts) {
		return ts != null ? ts.toString().substring(0, 19) : "";
	}

	public static String convertTsToStrWithDayOfWeek(Timestamp ts) {
		return ts != null ? ts.toString().substring(0, 10) + " " + getStrDay(ts) : "";
	}

	public static Timestamp createTimestamp(int year, int month, int date, int hour, int minute, int second) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, date, hour, minute, second);
		cal.set(14, 0);
		return convertCalToTs(cal);
	}

	public static Timestamp createTimestamp(int year, int month, int date) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, date, 0, 0, 0);
		cal.set(14, 0);
		return convertCalToTs(cal);
	}

	public static Timestamp createTimestamp(String str, String splitStr) {
		if (str != null && str.trim().length() >= 1) {
			if ("".equals(splitStr)) {
				splitStr = "-";
			}

			if (str.lastIndexOf(" ") != -1) {
				str = str.substring(0, 10);
			}

			try {
				StringTokenizer e = new StringTokenizer(str, splitStr);
				int year = Integer.parseInt(e.nextToken());
				int month = Integer.parseInt(e.nextToken());
				int date = Integer.parseInt(e.nextToken());
				return createTimestamp(year, month, date);
			} catch (Exception arg5) {
				return null;
			}
		} else {
			return null;
		}
	}

	public static int getYear(Timestamp ts) {
		return convertTsToCal(ts).get(1);
	}

	public static int getMonth(Timestamp ts) {
		return convertTsToCal(ts).get(2) + 1;
	}

	public static int getDate(Timestamp ts) {
		return convertTsToCal(ts).get(5);
	}

	public static int getHour(Timestamp ts) {
		return convertTsToCal(ts).get(11);
	}

	public static int getMinute(Timestamp ts) {
		return convertTsToCal(ts).get(12);
	}

	public static int getSecond(Timestamp ts) {
		return convertTsToCal(ts).get(13);
	}

	public static int getMillisecond(Timestamp ts) {
		return convertTsToCal(ts).get(14);
	}

	public static long getMilliseconds(Timestamp ts) {
		return ts.getTime();
	}

	public static int getDay(Timestamp ts) {
		return convertTsToCal(ts).get(7);
	}

	public static String getStrDay(Timestamp ts) {
		if (ts == null) {
			return null;
		} else {
			int day = getDay(ts);
			String weekDay = "";
			switch (day) {
				case 1 :
					weekDay = "星期天";
					break;
				case 2 :
					weekDay = "星期一";
					break;
				case 3 :
					weekDay = "星期二";
					break;
				case 4 :
					weekDay = "星期三";
					break;
				case 5 :
					weekDay = "星期四";
					break;
				case 6 :
					weekDay = "星期五";
					break;
				case 7 :
					weekDay = "星期六";
					break;
				default :
					weekDay = "";
			}

			return weekDay;
		}
	}

	public static int dateDiff(String diffpart, Timestamp ts1, Timestamp ts2) {
		if (ts1 != null && ts2 != null) {
			Date date1 = null;
			Date date2 = null;
			date1 = new Date(ts1.getTime());
			date2 = new Date(ts2.getTime());
			Calendar cal1 = null;
			Calendar cal2 = null;
			cal1 = Calendar.getInstance();
			cal2 = Calendar.getInstance();
			cal1.setTime(date1);
			long ldate1 = date1.getTime() + (long) cal1.get(15) + (long) cal1.get(16);
			cal2.setTime(date2);
			long ldate2 = date2.getTime() + (long) cal2.get(15) + (long) cal2.get(16);
			int hr1 = (int) (ldate1 / 3600000L);
			int hr2 = (int) (ldate2 / 3600000L);
			int days1 = hr1 / 24;
			int days2 = hr2 / 24;
			int dateDiff = days2 - days1;
			int weekOffset = cal2.get(7) - cal1.get(7) < 0 ? 1 : 0;
			int weekDiff = dateDiff / 7 + weekOffset;
			int yearDiff = cal2.get(1) - cal1.get(1);
			int monthDiff = yearDiff * 12 + cal2.get(2) - cal1.get(2);
			return "YEAR".equals(diffpart)
					? yearDiff
					: ("MONTH".equals(diffpart)
							? monthDiff
							: ("DATE".equals(diffpart) ? dateDiff : ("WEEK".equals(diffpart) ? weekDiff : dateDiff)));
		} else {
			return -1;
		}
	}

	public static boolean isLeapyear(Timestamp ts) {
		Calendar cal = Calendar.getInstance();
		boolean booleanleapYear = ((GregorianCalendar) cal).isLeapYear(getYear(ts));
		return booleanleapYear;
	}

	public static boolean isLeapyear(int year) {
		Calendar cal = Calendar.getInstance();
		boolean booleanleapYear = ((GregorianCalendar) cal).isLeapYear(year);
		return booleanleapYear;
	}

	public static boolean isMatchDate(int year, int month, int date, Timestamp ts) {
		int year1 = getYear(ts);
		int month1 = getMonth(ts);
		int date1 = getDay(ts);
		return year != -1 && year != year1
				? false
				: (month != -1 && month != month1 ? false : date == -1 || date == date1);
	}

	public static Date getFirstDayOfWeek(Date date) {
		GregorianCalendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(2);
		c.setTime(date);
		c.set(7, c.getFirstDayOfWeek());
		return c.getTime();
	}

	public static Date getFirstWeekDayByGivenDay(Date date, int nWeeks) {
		GregorianCalendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(2);
		c.setTime(date);
		c.add(5, nWeeks * 7);
		c.set(7, c.getFirstDayOfWeek());
		return c.getTime();
	}

	public static Date getLastDayOfWeek(Date date) {
		GregorianCalendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(2);
		c.setTime(date);
		c.set(7, c.getFirstDayOfWeek() + 6);
		return c.getTime();
	}

	public static Timestamp formatToDate(Timestamp ts) {
		Calendar cd = Calendar.getInstance();
		cd.setTimeInMillis(ts.getTime());
		cd.set(11, 0);
		cd.set(12, 0);
		cd.set(13, 0);
		cd.set(14, 0);
		return new Timestamp(cd.getTime().getTime());
	}

	public static Date formatToDate(Date dt) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(dt);
		cd.set(11, 0);
		cd.set(12, 0);
		cd.set(13, 0);
		cd.set(14, 0);
		return cd.getTime();
	}

	public static java.sql.Date formatToDate(java.sql.Date dt) {
		Calendar cd = Calendar.getInstance();
		cd.setTimeInMillis(dt.getTime());
		cd.set(11, 0);
		cd.set(12, 0);
		cd.set(13, 0);
		cd.set(14, 0);
		return new java.sql.Date(cd.getTime().getTime());
	}

	public static String getLastMonth(String yearM) {
		String yymmdd = yearM + "01";
		Date date = valueOf(yymmdd, "yyyyMMdd");
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(date);
		cal.set(5, 1);
		cal.add(2, -1);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		String lastMonth = dateToString(cal.getTime(), "yyyyMMdd");
		return lastMonth.substring(0, lastMonth.length() - 2);
	}

	public static String getBeforTwelveMonth(String yearM) {
		String yymmdd = yearM + "01";
		Date date = valueOf(yymmdd, "yyyyMMdd");
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(date);
		cal.set(5, 1);
		cal.add(2, -12);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		String lastMonth = dateToString(cal.getTime(), "yyyyMMdd");
		return lastMonth.substring(0, lastMonth.length() - 2);
	}

	public static String dateToString(Date date) {
		return dateToString(date, "yyyy-MM-dd");
	}

	public static String dateToString(Date date, String pattern) {
		if (date == null) {
			return null;
		} else {
			try {
				SimpleDateFormat e = new SimpleDateFormat(pattern);
				e.setLenient(false);
				return e.format(date);
			} catch (Exception arg2) {
				return null;
			}
		}
	}

	public static Date valueOf(String dateString) {
		return valueOf(dateString, "yyyy-MM-dd", LENIENT_DATE);
	}

	public static Date valueOf(String dateString, String format) {
		return valueOf(dateString, format, LENIENT_DATE);
	}

	public static Date valueOf(String dateText, String format, boolean lenient) {
		if (dateText == null) {
			return null;
		} else {
			SimpleDateFormat df = null;

			try {
				if (format == null) {
					df = new SimpleDateFormat();
				} else {
					df = new SimpleDateFormat(format);
				}

				df.setLenient(false);
				return df.parse(dateText);
			} catch (ParseException arg4) {
				return null;
			}
		}
	}

	public static String getBeforeMonth(Date currentDate, int span) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(currentDate);
		cal.set(5, 1);
		cal.add(2, -span);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		String lastMonth = dateToString(cal.getTime(), "yyyyMM");
		return lastMonth;
	}

	public static String getAfterMonth(Date currentDate, int span) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(currentDate);
		cal.set(5, 1);
		cal.add(2, span);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		String lastMonth = dateToString(cal.getTime(), "yyyyMM");
		return lastMonth;
	}

	public static String format(long ms) {
		short ss = 1000;
		int mi = ss * 60;
		int hh = mi * 60;
		int dd = hh * 24;
		long day = ms / (long) dd;
		long hour = (ms - day * (long) dd) / (long) hh;
		long minute = (ms - day * (long) dd - hour * (long) hh) / (long) mi;
		long second = (ms - day * (long) dd - hour * (long) hh - minute * (long) mi) / (long) ss;
		long milliSecond = ms - day * (long) dd - hour * (long) hh - minute * (long) mi - second * (long) ss;
		String strDay = day < 10L ? "0" + day : "" + day;
		String strHour = hour < 10L ? "0" + hour : "" + hour;
		String strMinute = minute < 10L ? "0" + minute : "" + minute;
		String strSecond = second < 10L ? "0" + second : "" + second;
		String strMilliSecond = milliSecond < 10L ? "0" + milliSecond : "" + milliSecond;
		if (milliSecond < 100L) {
			(new StringBuilder("0")).append(strMilliSecond).toString();
		} else {
			(new StringBuilder()).append(strMilliSecond).toString();
		}

		return strDay + "天," + strHour + "小时," + strMinute + "分钟," + strSecond + "秒";
	}

	public static String Longtimeformat(long ms) {
		short ss = 1000;
		int mi = ss * 60;
		int hh = mi * 60;
		long hour = ms / (long) hh;
		long minute = (ms - hour * (long) hh) / (long) mi;
		long second = (ms - hour * (long) hh - minute * (long) mi) / (long) ss;
		long milliSecond = ms - hour * (long) hh - minute * (long) mi - second * (long) ss;
		String strHour = hour < 10L ? "" + hour : "" + hour;
		String strMinute = minute < 10L ? "" + minute : "" + minute;
		String strSecond = second < 10L ? "" + second : "" + second;
		String strMilliSecond = milliSecond < 10L ? "0" + milliSecond : "" + milliSecond;
		if (milliSecond < 100L) {
			(new StringBuilder("0")).append(strMilliSecond).toString();
		} else {
			(new StringBuilder()).append(strMilliSecond).toString();
		}

		String result = strHour + "小时" + strMinute + "分钟" + strSecond + "秒";
		if (hour == 0L) {
			result = strMinute + "分钟" + strSecond + "秒";
		}

		if (hour == 0L && minute == 0L) {
			result = strSecond + "秒";
		}

		return result;
	}

	public static Date getDateAfterIDay(Date date, int i) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(5, i);
		return c.getTime();
	}

	public static Date convertCalToTs(Date date, int hour, int minute, int second) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(11, hour);
		c.set(12, minute);
		c.set(13, second);
		return c.getTime();
	}

	public static void setHMS(Calendar c, int hour, int minute, int second) {
		c.set(11, hour);
		c.set(12, minute);
		c.set(13, second);
	}

	public static void setHMSM(Calendar c, int hour, int minute, int second, int milliSecond) {
		c.set(11, hour);
		c.set(12, minute);
		c.set(13, second);
		c.set(14, milliSecond);
	}

	public static Date getGivenTimeOfToday(int hour, int minute, int second) {
		Calendar cal = Calendar.getInstance();
		cal.set(11, hour);
		cal.set(12, minute);
		cal.set(13, second);
		return new Date(cal.getTimeInMillis());
	}

	public static Date getGivenTimeAfterSomeDay(int hour, int minute, int second, int dayCount) {
		Calendar cal = Calendar.getInstance();
		cal.add(5, dayCount);
		cal.set(11, hour);
		cal.set(12, minute);
		cal.set(13, second);
		return new Date(cal.getTimeInMillis());
	}

	public static Date getGivenTimeAfterSomeDay(int hour, int minute, int second, Date date, int dayCount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(5, dayCount);
		cal.set(11, hour);
		cal.set(12, minute);
		cal.set(13, second);
		return new Date(cal.getTimeInMillis());
	}

	public static boolean isValidTime(String timeStr) {
		if (timeStr != null && timeStr.length() == 8) {
			if (":".equals(timeStr.substring(2, 3)) && ":".equals(timeStr.substring(5, 6))) {
				try {
					int e = Integer.parseInt(timeStr.substring(0, 2));
					if (e >= 0 && e <= 47) {
						int minute = Integer.parseInt(timeStr.substring(3, 5));
						if (minute >= 0 && minute <= 59) {
							int second = Integer.parseInt(timeStr.substring(6, 8));
							return second >= 0 && second <= 59;
						} else {
							return false;
						}
					} else {
						return false;
					}
				} catch (Exception arg3) {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isValidTime(String... dateStrArr) {
		if (dateStrArr != null && dateStrArr.length != 0) {
			String[] arg3 = dateStrArr;
			int arg2 = dateStrArr.length;

			for (int arg1 = 0; arg1 < arg2; ++arg1) {
				String dateStr = arg3[arg1];
				if (!isValidTime(dateStr)) {
					return false;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	public static void checkTime(String testTime) throws Exception {
		if (!isValidTime(testTime)) {
			throw new Exception(testTime);
		}
	}

	public static String addTimePrefix(String srcTime, String prefix) throws Exception {
		if (StringUtils.isEmpty(srcTime)) {
			return srcTime;
		} else {
			String hour = srcTime.substring(0, 2);
			int hourInt = Integer.parseInt(hour);
			if (hourInt >= 24) {
				int newHourInt = hourInt - 24;
				if (newHourInt < 10) {
					prefix = prefix + "0";
				}

				return prefix + newHourInt + srcTime.substring(2);
			} else {
				return srcTime;
			}
		}
	}
}