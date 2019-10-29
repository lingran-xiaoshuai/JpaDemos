package com.rigid.jpademos.workTest;

import com.caimao.common.utils.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: JpaDemos
 * @description: 时间的基础操作
 * @author: Rigid_Shuai
 * @create: 2019-10-28 10:38
 */
public class TimeTest {

    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-28 10:42
     * @Description: Calendar对时间(int)的操作
     * @Param: []
     * @return: void
     */
    @Test
    public void test1() {
        //获取当前时间
        Calendar calendar = Calendar.getInstance();

        System.out.println("当前时间--> Date:" + calendar.getTime());

        //24小时置0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        //分钟置0
        calendar.set(Calendar.MINUTE, 0);
        //秒置0
        calendar.set(Calendar.SECOND, 0);
        //毫秒置0
        calendar.set(Calendar.MILLISECOND, 0);

        System.out.println("当前时间--> Date:" + calendar.getTime());

        System.out.println("今天年月日--> int类型:" + DateUtil.getDay(calendar));

        //当前日期减一天
        calendar.add(Calendar.DATE, -1);

        System.out.println("昨天年月日--> int类型:" + DateUtil.getDay(calendar));
    }

    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-28 10:46
     * @Description: 当月第一天到今天  int
     * @Param: []
     * @return: void
     */
    @Test
    public void test2() {
        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        //设置当前月为1号
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int day1 = DateUtil.getDay(calendar);
        //获取今天日期
        int day2 = DateUtil.getDay(System.currentTimeMillis());

        System.out.println("本月1号日期:" + day1);
        System.out.println("今天日期:" + day2);

    }

    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-28 10:57
     * @Description: long获取时间的年月日   精确到00:00:00
     * @Param: [timeMillis]
     * @return: long
     */
    @Test
    public void test3() {
        Long timeMillis = System.currentTimeMillis();
        long diff = (timeMillis + 1000L * 60 * 60 * 8) % DateUtils.MILLIS_PER_DAY;
        if (diff > 0) {
            System.out.println(timeMillis - diff);
        } else {
            System.out.println(timeMillis);
        }
    }


    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-28 11:18
     * @Description: 注意：month是从0开始的，而月份是从1开始的，所以month需要加一。
     * @Param: []
     * @return: void
     */
    @Test
    public void test4() {
        //已由当前日期和时间初始化：
        Calendar rightNow = Calendar.getInstance(); // 子类对象
        // 获取年
        int year = rightNow.get(Calendar.YEAR);
        // 获取月
        int month = rightNow.get(Calendar.MONTH);
        // 获取日
        int date = rightNow.get(Calendar.DATE);
        //获取当前小时
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        //获取当前分钟
        int minute = rightNow.get(Calendar.MINUTE);
        //获取当前秒
        int second = rightNow.get(Calendar.SECOND);
        //获取当前毫秒
        int millSecond = rightNow.get(Calendar.MILLISECOND);
        //获取上午下午
        int moa = rightNow.get(Calendar.AM_PM);
        if (moa == 1)
            System.out.println("下午");
        else
            System.out.println("上午");

        System.out.println(year + "年" + (month + 1) + "月" + date + "日" + hour + "时" + minute + "分" + second + "秒" + millSecond + "毫秒");
        //+ 五年
        rightNow.add(Calendar.YEAR, 5);
        //- 十天
        rightNow.add(Calendar.DATE, -10);
        int year1 = rightNow.get(Calendar.YEAR);
        int date1 = rightNow.get(Calendar.DATE);
        System.out.println(year1 + "年" + (month + 1) + "月" + date1 + "日" + hour + "时" + minute + "分" + second + "秒" + millSecond + "毫秒");
    }

    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-28 15:58
     * @Description: Long类型转String
     * @Param: []
     * @return: void
     */
    @Test
    public void test5() {
        Long timeMillis = System.currentTimeMillis();
        // 24小时
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(timeMillis));
        // 12小时
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd hh:mm:ss").format(timeMillis));
    }

    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-29 10:14
     * @Description: date1.after(date), 当date1大于date2时，返回true，当小于等于时，返回false；
     * @Description: date1.before(date)，当date1小于date2时，返回true，当大于等于时，返回false；
     * @Description: 若要校验date2必须比date1小，且不能相等时，使用 !date1.after(date2);
     * @Param: []
     * @return: void
     */
    @Test
    public void test6() {
        Date now = new Date();
        Date now1 = new Date();
        System.out.println(now);
        System.out.println(now1);
        Calendar calendar = Calendar.getInstance();
        //加1个小时
        calendar.add(Calendar.HOUR_OF_DAY, +1);
        Date now2 = calendar.getTime();
        System.out.println(now2);
        //now2 > now  true
        boolean after = now2.after(now);
        System.out.println(after);
        //now2 < now  false
        boolean before = now2.before(now);
        System.out.println(before);
        //now1 > now  false
        boolean after1 = now1.after(now);
        System.out.println(after1);
        //now1 < now  false
        boolean before1 = now1.before(now);
        System.out.println(before1);
    }

    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-29 10:28
     * @Description: 小于 时，返回 -1
     * @Description: 等于 时，返回 0
     * @Description: 大于 时，返回 1
     * @Param: []
     * @return: void
     */
    @Test
    public void test7() {
        BigDecimal b1 = new BigDecimal(101);
        BigDecimal b2 = new BigDecimal(100);
        BigDecimal b3 = new BigDecimal(100);
        BigDecimal b4 = new BigDecimal(0);


        //b1 >= b2
        if (b1.compareTo(b2) >= 0) {
            System.out.println("b1 >= b2");
        }
        //b1 > b2
        if (b1.compareTo(b2) == 1) {
            System.out.println("b1 > b2");
        }

        //b2 >= b3
        if (b2.compareTo(b3) >= 0) {
            System.out.println("b2 >= b3");
        }
        //b2 = b3
        if (b2.compareTo(b3) == 0) {
            System.out.println("b2 = b3");
        }

        //b4 = 0  BigDecimal b4 = new BigDecimal(0);
        if (b4.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("b4 = 0");
        }
    }

    /**
    * @Author: Rigid_Shuai
    * @Date: 2019-10-29 10:42
    * @Description: 加法 add()函数        减法subtract()函数
    * @Description: 乘法multiply()函数    除法divide()函数      绝对值abs()函数
    * @Description:  https://blog.csdn.net/haiyinshushe/article/details/82721234
    * @Param: []
    * @return: void
    */
    @Test
    public  void test8(){
        BigDecimal num1 = new BigDecimal(0.005);
        BigDecimal num2 = new BigDecimal(1000000);
        BigDecimal num3 = new BigDecimal(-1000000);
        //尽量用字符串的形式初始化
        BigDecimal num12 = new BigDecimal("0.005");
        BigDecimal num22 = new BigDecimal("1000000");
        BigDecimal num32 = new BigDecimal("-1000000");

        //加法
        BigDecimal result1 = num1.add(num2);
        BigDecimal result12 = num12.add(num22);
        //减法
        BigDecimal result2 = num1.subtract(num2);
        BigDecimal result22 = num12.subtract(num22);
        //乘法
        BigDecimal result3 = num1.multiply(num2);
        BigDecimal result32 = num12.multiply(num22);
        //绝对值
        BigDecimal result4 = num3.abs();
        BigDecimal result42 = num32.abs();
        //除法
        BigDecimal result5 = num2.divide(num1,20,BigDecimal.ROUND_HALF_UP);
        BigDecimal result52 = num22.divide(num12,20,BigDecimal.ROUND_HALF_UP);

        System.out.println("加法用value结果："+result1);
        System.out.println("加法用string结果："+result12);

        System.out.println("减法value结果："+result2);
        System.out.println("减法用string结果："+result22);

        System.out.println("乘法用value结果："+result3);
        System.out.println("乘法用string结果："+result32);

        System.out.println("绝对值用value结果："+result4);
        System.out.println("绝对值用string结果："+result42);

        System.out.println("除法用value结果："+result5);
        System.out.println("除法用string结果："+result52);

        //加法用value结果：1000000.005000000000000000104083408558608425664715468883514404296875
        //加法用string结果：1000000.005
        //减法value结果：-999999.994999999999999999895916591441391574335284531116485595703125
        //减法用string结果：-999999.995
        //乘法用value结果：5000.000000000000104083408558608425664715468883514404296875000000
        //乘法用string结果：5000.000
        //绝对值用value结果：1000000
        //绝对值用string结果：1000000
        //除法用value结果：199999999.99999999583666365766
        //除法用string结果：200000000.00000000000000000000
    }
}
