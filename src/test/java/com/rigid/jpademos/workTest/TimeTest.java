package com.rigid.jpademos.workTest;

import com.caimao.common.utils.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Calendar;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: JpaDemos
 * @description:
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

    @Test
    public void test5() {

    }
}
