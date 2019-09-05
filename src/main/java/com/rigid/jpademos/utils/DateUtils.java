package com.rigid.jpademos.utils;

import org.apache.commons.lang.time.DateFormatUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * @tool: Created with IntelliJ IDEA
 * @program:
 * @description: 日期转换类 转换一个 java.util.Date 对象到一个字符串以及 一个字符串到一个 java.util.Date 对象.
 * @author: Rigid
 * @create: 2019-08-26 11:13
 */
public final class DateUtils extends DateFormatUtils {

    public final static String dateAndTime = "yyyy-MM-dd HH:mm:ss";
    public final static String datePattern = "yyyy-MM-dd";
    public final static String timePattern = "HH:mm";
    public final static String GMTPattern = "EEE,d MMM yyyy HH:mm:ss z";
    static final String dayNames[] = {"", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    /**
     * 返回年月日格式化字符串"yyyy-MM-dd"
     *
     * @return
     */
    public static String getDatePattern() {
        return datePattern;
    }

    /**
     * 返回当天时间字符串:2008-10-15
     *
     * @return 时间字符串
     */
    public static String today() {
        Calendar cal = Calendar.getInstance();
        DecimalFormat f = new DecimalFormat("00");
        StringBuffer date = new StringBuffer();
        date.append(cal.get(Calendar.YEAR)).append("-").append(f.format(cal.get(Calendar.MONTH) + 1)).append("-").append(f.format(cal.get(Calendar.DAY_OF_MONTH)));
        return date.toString();
    }

    /**
     * 获取当前时间的指定格式
     *
     * @param format
     * @return
     */
    public final static String getCurrDate(String format) {
        return format(format, new Date());
    }

    /**
     * 返回yyyy-MM-dd HH:mm:ss格式
     *
     * @param Date
     * @return
     */
    public static final String formatTime(Date date) {
        SimpleDateFormat df = null;
        String returnValue = "";
        if (date != null) {
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            returnValue = df.format(date);
        }
        return (returnValue);
    }

    /**
     * 根据日期格式，返回日期按datePattern格式转换后的字符串.
     *
     * @param date the a date
     * @return the string
     */
    public static final String formatDate(Date date) {
        return format(datePattern, date);
    }

    /**
     * 返回字符串时间格式: HH:mm
     *
     * @param theTime
     * @return
     */
    public static String formatTimePattern(Date theTime) {
        return format(timePattern, theTime);
    }

    /**
     * 根据一个时间格式字符串串，返回一个字符串
     *
     * @param format 时间字符串
     * @param Date  要格式化的时间数据
     */
    public static final String format(String format, Date date) {
        SimpleDateFormat df = null;
        String returnValue = "";
        if (date != null) {
            df = new SimpleDateFormat(format);
            returnValue = df.format(date);
        }
        return (returnValue);
    }

    /**
     * 几个月之后的时间
     *
     * @param date
     * @return
     */
    public static Date monthLater(Date date, int n) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        Date dateLater = cal.getTime();
        return dateLater;
    }

    /**
     * 格式化时间到"yyyy-MM-dd"
     *
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static final Date parseToDate(String strDate) throws ParseException {
        return parse(datePattern, strDate);
    }

    /**
     * 格式换时间戳"yyyy-MM-dd HH:mm:ss"
     *
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static final Date parseToTime(String strDate) throws ParseException {
        return parse(dateAndTime, strDate);
    }

    /**
     * 自定义格式化字符串
     *
     * @param format  格式化
     * @param strDate 时间字符串
     * @return
     * @throws ParseException
     */
    public static final Date parse(String format, String strDate) throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(format);
        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }
        return (date);
    }

    /**
     * 获得当前日期
     *
     * @return int
     */
    public static int dateOfMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

    /**
     * 返回日期的天
     * #DAY_OF_MONTH
     *
     * @param date Date
     * @return int
     */
    public static int dateOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获得当前月份
     *
     * @return int
     */
    public static int getMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获得当前年份
     *
     * @return int
     */
    public static int getToYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 计算两个日期相差的天数，如果date2 > date1 返回正数，否则返回负数
     *
     * @param date1 Date
     * @param date2 Date
     * @return long
     */
    public static long dayDiff(Date date1, Date date2) {
        return (date2.getTime() - date1.getTime()) / 86400000;
    }

    /**
     * 获取每月的第一周
     *
     * @param year
     * @param month
     * @return 返回所在星期的第几天
     * @author lujun
     */
    public static int getFirstWeekdayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.set(year, month - 1, 1);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取每月的最后一周
     *
     * @param year
     * @param month
     * @return
     * @author lujun
     */
    public static int getLastWeekdayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.set(year, month - 1, getDaysOfMonth(year, month));
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取本月第一天
     *
     * @param format
     * @return
     */
    public static String getFirstDayOfMonth(String format) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        return format(format, cal.getTime());
    }

    /**
     * 获取本月最后一天
     *
     * @param format
     * @return
     */
    public static String getLastDayOfMonth(String format) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return format(format, cal.getTime());
    }

    /**
     * 获取某年某月的天数
     *
     * @param year  int
     * @param month int 月份[1-12]
     * @return int
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得某月的天数
     *
     * @param year  int
     * @param month int
     * @return int
     */
    public static int getDaysOfMonth(String year, String month) {
        int days = 0;
        if (month.equals("1") || month.equals("3") || month.equals("5") || month.equals("7") || month.equals("8") || month.equals("10") || month.equals("12")) {
            days = 31;
        } else if (month.equals("4") || month.equals("6") || month.equals("9") || month.equals("11")) {
            days = 30;
        } else {
            if ((Integer.parseInt(year) % 4 == 0 && Integer.parseInt(year) % 100 != 0) || Integer.parseInt(year) % 400 == 0) {
                days = 29;
            } else {
                days = 28;
            }
        }
        return days;
    }

    /**
     * 按照日期格式，将字符串解析为日期对象.
     * 输入字符串的格式,如yyyy-MM-dd hh:mm:ss
     * 一个按aMask格式排列的日期的字符串描
     *
     * @return Date 对象
     */
    public static final Date GMT2Date(String gmtStr) throws ParseException {
        return parse(GMTPattern, gmtStr);
    }

    /**
     * 返回当前日期到时间24：00：00 用于查询该日期的内容
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static final Date dateStartDate(Date date) throws ParseException {
        String dastr = formatDate(date) + " 00:00:00";
        return parse(dateAndTime, dastr);
    }

    /**
     * 返回当前日期到时间 00:00:00 用于查询该日期的内容
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static final Date dateStartDate(String dateStr) throws ParseException {
        String dastr = dateStr + " 00:00:00";
        return parse(dateAndTime, dastr);
    }

    /**
     * 返回当前日期到时间24：00：00 用于查询该日期的内容
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static final Date dateEndDate(Date date) throws ParseException {
        String dastr = formatDate(date) + " 23:59:59";
        return parse(dateAndTime, dastr);
    }

    /**
     * 返回当前日期到时间 23:59:59 用于查询该日期的内容
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static final Date dateEndDate(String dateStr) throws ParseException {
        String dastr = dateStr + " 23:59:59";
        return parse(dateAndTime, dastr);
    }

    /**
     * 返回当天的Calendar对象
     *
     * @return the current date
     */
    public static Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(datePattern);
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(parseToTime(todayAsString));
        return cal;
    }

    /**
     * 两个日期相差的天数
     * 如果返回正数 date1 在  date0 几天
     */
    public static int daysBetween(Date date1, Date date0) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date0);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 返回时间格式的带有num位随机数的字符串
     *
     * @param num
     * @return
     */
    public static final String getDateNO(int num) {
        return getDateNO(new Date(), num);
    }

    /**
     * 返回时间字符串(没有间隔符)"yyyyMMddHHmmss"
     *
     * @param date
     * @param num
     * @return
     */
    public static final String getDateNO(Date date, int num) {
        Random jjj = new Random();
        if (num == 0) {
            return format("yyyyMMddHHmmss", date);
        }
        String jj = "";
        for (int k = 0; k < num; k++) {
            jj = jj + jjj.nextInt(9);
        }
        return format("yyyyMMddHHmmss", date) + jj;
    }

    /**
     * 返回前后多少年，月，日
     *
     * @param field Calendar.year...
     * @return
     */
    public static Date getNextDay(int field, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.add(field, amount);
        return cal.getTime();
    }

    /**
     * 根据当前一个时期，取得一个时间的部分,用下面方法比getDateTime("MM",new Date());方法速度快两倍
     *
     * @param date
     * @param w
     * @return
     */
    public static String partDate(Date date, int w) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        DecimalFormat f = new DecimalFormat("00");
        switch (w) {
            case 1: {
                return String.valueOf(cal.get(Calendar.YEAR));
            }
            case 2: {
                return f.format(cal.get(Calendar.MONTH) + 1);
            }
            case 3: {
                return f.format(cal.get(Calendar.DAY_OF_MONTH));
            }
            case 4: {
                return f.format(cal.get(Calendar.HOUR_OF_DAY));
            }
            case 5: {
                return f.format(cal.get(Calendar.MINUTE));
            }
            case 6: {
                return f.format(cal.get(Calendar.SECOND));
            }
        }
        return "00";
    }

    /**
     * 返回当前日期 时间为0
     *
     * @return
     */
    public static Date getOnlyDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 判断日期是否有效,包括闰年的情况
     *
     * @param date YYYY-mm-dd
     * @return
     */
    public static boolean isDate(String date) {
        StringBuffer reg = new StringBuffer("^((\\d{2}(([02468][048])|([13579][26]))-?((((0?");
        reg.append("[13578])|(1[02]))-?((0?[1-9])|([1-2][0-9])|(3[01])))");
        reg.append("|(((0?[469])|(11))-?((0?[1-9])|([1-2][0-9])|(30)))|");
        reg.append("(0?2-?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12");
        reg.append("35679])|([13579][01345789]))-?((((0?[13578])|(1[02]))");
        reg.append("-?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))");
        reg.append("-?((0?[1-9])|([1-2][0-9])|(30)))|(0?2-?((0?[");
        reg.append("1-9])|(1[0-9])|(2[0-8]))))))");
        Pattern p = Pattern.compile(reg.toString());
        return p.matcher(date).matches();
    }

    /**
     * 获取微博表现时间实现
     *
     * @param date
     * @return
     */
    public static String weiboTime(Date date) {
        String str = "";
        if (date == null) {
            return str;
        }
        Date now = new Date();
        Date yestoday = new Date(now.getTime() - 24 * 60 * 60 * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowStr = sdf.format(now);
        String yesStr = sdf.format(yestoday);
        String dateStr = sdf.format(date);
        if (nowStr.equals(dateStr)) {
            SimpleDateFormat msdf = new SimpleDateFormat("HH:mm");
            str = "今天 " + msdf.format(date);
        } else if (yesStr.equals(dateStr)) {
            SimpleDateFormat msdf = new SimpleDateFormat("HH:mm");
            str = "昨天 " + msdf.format(date);
        } else {
            SimpleDateFormat msdf = new SimpleDateFormat("MM-dd HH:mm");
            str = msdf.format(date);
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        int num = getLastWeekdayOfMonth(2011, 4);
        System.out.println(num + "--" + dayNames[num]);
    }
}