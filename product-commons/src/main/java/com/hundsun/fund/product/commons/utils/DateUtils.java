package com.hundsun.fund.product.commons.utils;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author william
 *
 */
public class DateUtils {

    public static final SimpleDateFormat datetimeFormat      = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat dateFormat          = new SimpleDateFormat ("yyyy-MM-dd");
    public static final SimpleDateFormat timeFormat          = new SimpleDateFormat ("HH:mm:ss");
    
    /**
     * 最小日期，设定为1000年1月1日
     */
    public static final Date             MIN_DATE            = date (1000, 1, 1);
    /**
     * 最大日期，设定为8888年1月1日
     */
    public static final Date             MAX_DATE            = date (8888, 1, 1);
    private static final long            MILLIS_IN_A_SECOND  = 1000;
    private static final long            SECONDS_IN_A_MINUTE = 60;
    private static final long            MINUTES_IN_AN_HOUR  = 60;
    private static final long            HOURS_IN_A_DAY      = 24;
    private static final int             DAYS_IN_A_WEEK      = 7;
    private static final int             MONTHS_IN_A_YEAR    = 12;

    private DateUtils() {
        super ();
    }

    /**
     * 根据年月日构建日期对象。注意月份是从1开始计数的，即month为1代表1月份。
     *
     * @param year 年
     * @param month 月。注意1代表1月份，依此类推。
     * @param day 日
     * @return 一个日期
     */
    public static Date date(int year,int month,int day){
        Calendar calendar = Calendar.getInstance ();
        calendar.set (year, month - 1, day, 0, 0, 0);
        calendar.set (Calendar.MILLISECOND, 0);
        return calendar.getTime ();
    }

    /**
     * 根据年月日构建日期对象。注意月份是从1开始计数的，即month为1代表1月份。
     *
     * @param year 年
     * @param month 月。注意1代表1月份，依此类推。
     * @param day 日
     * @param hour 时
     * @param minute 分
     * @param second 秒
     * @return 一个日期
     */
    public static Date date(int year,int month,int day,int hour,int minute,int second){
        Calendar calendar = Calendar.getInstance ();
        calendar.set (year, month - 1, day, hour, minute, second);
        calendar.set (Calendar.MILLISECOND, 0);
        return calendar.getTime ();
    }

    /**
     * 计算两个日期（不包括时间）之间相差的周年数
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 两个日期之间相隔的周年数
     */
    public static int getYearDiff(Date date1,Date date2){
        if (date1 == null || date2 == null) { throw new InvalidParameterException ("date1 and date2 cannot be null!"); }
        if (date1.after (date2)) { throw new InvalidParameterException ("date1 cannot be after date2!"); }

        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (date1);
        int year1 = calendar.get (Calendar.YEAR);
        int month1 = calendar.get (Calendar.MONTH);
        int day1 = calendar.get (Calendar.DATE);

        calendar.setTime (date2);
        int year2 = calendar.get (Calendar.YEAR);
        int month2 = calendar.get (Calendar.MONTH);
        int day2 = calendar.get (Calendar.DATE);

        int result = year2 - year1;
        if (month2 < month1) {
            result--;
        } else if (month2 == month1 && day2 < day1) {
            result--;
        }
        return result;
    }

    /**
     * 计算两个日期（不包括时间）之间相差的整月数
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 两个日期之间相隔的整月数
     */
    public static int getMonthDiff(Date date1,Date date2){
        if (date1 == null || date2 == null) { throw new InvalidParameterException ("date1 and date2 cannot be null!"); }
        if (date1.after (date2)) { throw new InvalidParameterException ("date1 cannot be after date2!"); }

        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (date1);
        int year1 = calendar.get (Calendar.YEAR);
        int month1 = calendar.get (Calendar.MONTH);
        int day1 = calendar.get (Calendar.DATE);

        calendar.setTime (date2);
        int year2 = calendar.get (Calendar.YEAR);
        int month2 = calendar.get (Calendar.MONTH);
        int day2 = calendar.get (Calendar.DATE);

        int months = 0;
        if (day2 >= day1) {
            months = month2 - month1;
        } else {
            months = month2 - month1 - 1;
        }
        return (year2 - year1) * MONTHS_IN_A_YEAR + months;
    }

    /**
     * 统计两个日期之间包含的天数。包含date1，但不包含date2
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 两个日期之间相隔的整天数
     */
    public static int getDayDiff(Date date1,Date date2){
        if (date1 == null || date2 == null) { throw new InvalidParameterException ("date1 and date2 cannot be null!"); }
        Date startDate = org.apache.commons.lang3.time.DateUtils.truncate (date1, Calendar.DATE);
        Date endDate = org.apache.commons.lang3.time.DateUtils.truncate (date2, Calendar.DATE);
        if (startDate.after (endDate)) { throw new InvalidParameterException ("date1 cannot be after date2!"); }
        long millSecondsInOneDay = HOURS_IN_A_DAY * MINUTES_IN_AN_HOUR * SECONDS_IN_A_MINUTE * MILLIS_IN_A_SECOND;
        return (int) ((endDate.getTime () - startDate.getTime ()) / millSecondsInOneDay);
    }

    /**
     * 计算time2比time1晚多少分钟，忽略日期部分
     *
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 两个时间之间相隔的分钟数
     */
    public static int getMinuteDiffByTime(Date time1,Date time2){
        long startMil = 0;
        long endMil = 0;
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (time1);
        calendar.set (1900, 1, 1);
        startMil = calendar.getTimeInMillis ();
        calendar.setTime (time2);
        calendar.set (1900, 1, 1);
        endMil = calendar.getTimeInMillis ();
        return (int) ((endMil - startMil) / MILLIS_IN_A_SECOND / SECONDS_IN_A_MINUTE);
    }

    /**
     * 计算指定日期的前一天
     *
     * @param date 一个日期
     * @return 代表date前一天的日期
     */
    public static Date getPrevDay(Date date){
        return org.apache.commons.lang3.time.DateUtils.addDays (date, -1);
    }

    /**
     * 计算指定日期的后一天
     *
     * @param date 一个日期
     * @return 代表date后一天的日期
     */
    public static Date getNextDay(Date date){
        return org.apache.commons.lang3.time.DateUtils.addDays (date, 1);
    }

    /**
     * 判断date1是否在date2之后，忽略时间部分
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 如果date1处于date2之后，返回true，否则返回false
     */
    public static boolean isDateAfter(Date date1,Date date2){
        Date theDate1 = org.apache.commons.lang3.time.DateUtils.truncate (date1, Calendar.DATE);
        Date theDate2 = org.apache.commons.lang3.time.DateUtils.truncate (date2, Calendar.DATE);
        return theDate1.after (theDate2);
    }

    /**
     * 判断date1是否在date2之前，忽略时间部分
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 如果date1处于date2之前，返回true，否则返回false
     */
    public static boolean isDateBefore(Date date1,Date date2){
        return isDateAfter (date2, date1);
    }

    /**
     * 判断time1是否在time2之后，忽略日期部分
     *
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 如果time1位于time2之后，返回true，否则返回false
     */
    public static boolean isTimeAfter(Date time1,Date time2){
        Calendar calendar1 = Calendar.getInstance ();
        calendar1.setTime (time1);
        calendar1.set (1900, 1, 1);
        Calendar calendar2 = Calendar.getInstance ();
        calendar2.setTime (time2);
        calendar2.set (1900, 1, 1);
        return calendar1.after (calendar2);
    }

    /**
     * 判断time1是否在time2之前，忽略日期部分
     *
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 如果time1位于time2之前，返回true，否则返回false
     */
    public static boolean isTimeBefore(Date time1,Date time2){
        return isTimeAfter (time2, time1);
    }

    /**
     * 判断两个日期是否同一天（忽略时间部分）
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 如果date1和date2代表相同的日期，返回true，否则返回false
     */
    public static boolean isSameDay(Date date1,Date date2){
        return org.apache.commons.lang3.time.DateUtils.isSameDay (date1, date2);
    }

    /**
     * 判断两个日历天是否同一天（忽略时间部分）
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 如果date1和date2代表相同的日期，返回true，否则返回false
     */
    public static boolean isSameDay(Calendar date1,Calendar date2){
        return org.apache.commons.lang3.time.DateUtils.isSameDay (date1, date2);
    }

    /**
     * 将字符串形式的日期表示解析为日期对象
     *
     * @param dateString 代表日期的字符串
     * @return 一个日期
     */
    public static Date parseDate(String dateString){
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate (dateString, new String[] { "yyyy-MM-dd", "yyyy-M-d", "yyyy-MM-d", "yyyy-M-dd" });
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将字符串形式的时间表示解析为时间对象
     *
     * @param timeString 代表时间的字符串
     * @return 一个日期
     */
    public static Date parseTime(String timeString){
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate (timeString, new String[] { "hh:mm:ss", "h:m:s", "hh:mm", "h:m" });
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将字符串形式的日期时间表示解析为时间对象
     *
     * @param timeString 代表时间的字符串
     * @return 一个日期
     */
    public static Date parseDateTime(String timeString){
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate (timeString, new String[] { "yyyy-MM-dd HH:mm:ss", "yyyy-M-d H:m:s", "yyyy-MM-dd H:m:s",
                    "yyyy-M-d HH:mm:ss" });
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 计算两个日期之间包含的星期X的天数。
     *
     * @param fromDate 起始日期
     * @param toDate 结束日期
     * @param dayOfWeek 星期，例如星期三，星期四
     * @return 两个日期之间包含的星期X的数量
     */
    public static int getWeekDaysBetween(Date fromDate,Date toDate,int dayOfWeek){
        int result = 0;
        Date firstDate = getFirstWeekdayBetween (fromDate, toDate, dayOfWeek);
        if (firstDate == null) { return 0; }
        Calendar aDay = Calendar.getInstance ();
        aDay.setTime (firstDate);
        while (aDay.getTime ().before (toDate)) {
            result++;
            aDay.add (Calendar.DATE, DAYS_IN_A_WEEK);
        }
        return result;
    }

    /**
     * 获取在两个日期之间的第一个星期X
     *
     * @param fromDate 起始日期
     * @param toDate 结束日期
     * @param dayOfWeek 星期，例如星期三，星期四
     * @return 两个日期之间的第一个星期X
     */
    public static Date getFirstWeekdayBetween(Date fromDate,Date toDate,int dayOfWeek){
        Calendar aDay = Calendar.getInstance ();
        aDay.setTime (fromDate);
        while (aDay.getTime ().before (toDate)) {
            if (aDay.get (Calendar.DAY_OF_WEEK) == dayOfWeek) { return aDay.getTime (); }
            aDay.add (Calendar.DATE, 1);
        }
        return null;
    }

    /**
     * 取得参数year指定的年份的总天数
     *
     * @param year 年份
     * @return 当年的总天数
     */
    public static int getDaysInYear(int year){
        Calendar aDay = Calendar.getInstance ();
        aDay.set (year, 1, 1);
        Date from = aDay.getTime ();
        aDay.set (year + 1, 1, 1);
        Date to = aDay.getTime ();
        return getDayDiff (from, to);
    }

    /**
     * 取得指定年月的总天数
     *
     * @param year 年份
     * @param month 月份
     * @return 当月的总天数
     */
    public static int getDaysInMonth(int year,int month){
        Calendar aDay = Calendar.getInstance ();
        aDay.set (year, month, 1);
        Date from = aDay.getTime ();
        if (month == Calendar.DECEMBER) {
            aDay.set (year + 1, Calendar.JANUARY, 1);
        } else {
            aDay.set (year, month + 1, 1);
        }
        Date to = aDay.getTime ();
        return getDayDiff (from, to);
    }

    /**
     * 获得指定日期的年份
     *
     * @param date 一个日期
     * @return 日期所属的年份
     */
    public static int getYear(Date date){
        return getFieldValue (date, Calendar.YEAR);
    }

    /**
     * 获得指定日期的月份
     *
     * @param date 一个日期
     * @return 日期所属的月份
     */
    public static int getMonth(Date date){
        return getFieldValue (date, Calendar.MONTH) + 1;
    }

    /**
     * 获得指定日期是当年的第几天
     *
     * @param date 一个日期
     * @return 日期在当年中是第几天
     */
    public static int getDayOfYear(Date date){
        return getFieldValue (date, Calendar.DAY_OF_YEAR);
    }

    /**
     * 获得指定日期是当月的第几天
     *
     * @param date 一个日期
     * @return 日期在当月中是第几天
     */
    public static int getDayOfMonth(Date date){
        return getFieldValue (date, Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得指定日期是当周的第几天
     *
     * @param date 一个日期
     * @return 日期在本周中是第几天
     */
    public static int getDayOfWeek(Date date){
        return getFieldValue (date, Calendar.DAY_OF_WEEK);
    }

    private static int getFieldValue(Date date,int field){
        if (date == null) { throw new InvalidParameterException ("date cannot be null!"); }
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (date);
        return calendar.get (field);
    }

    /**
     * 获得指定日期之后一段时期的日期。例如某日期之后3天的日期等。
     *
     * @param origDate 基准日期
     * @param amount 时间数量
     * @param timeUnit 时间单位，如年、月、日等。用Calendar中的常量代表
     * @return 一个日期
     */
    public static final Date dateAfter(Date origDate,int amount,int timeUnit){
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (origDate);
        calendar.add (timeUnit, amount);
        return calendar.getTime ();
    }

    /**
     * 获得指定日期之前一段时期的日期。例如某日期之前3天的日期等。
     *
     * @param origDate 基准日期
     * @param amount 时间数量
     * @param timeUnit 时间单位，如年、月、日等。用Calendar中的常量代表
     * @return 一个日期
     */
    public static final Date dateBefore(Date origDate,int amount,int timeUnit){
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (origDate);
        calendar.add (timeUnit, -amount);
        return calendar.getTime ();
    }

    /** 
     * 格式化日期时间 
     *  
     * @param date 
     * @param pattern
     * @return 
     */
    public static String formatDatetime(Date date,String pattern){
        SimpleDateFormat customFormat = (SimpleDateFormat) datetimeFormat.clone ();
        customFormat.applyPattern (pattern);
        return customFormat.format (date);
    }

}
