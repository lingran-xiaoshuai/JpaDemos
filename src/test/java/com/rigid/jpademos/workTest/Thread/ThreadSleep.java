package com.rigid.jpademos.workTest.Thread;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

/**
 * @Tool: Created with IntelliJ IDEA
 * @Program: JpaDemos
 * @Description: 线程休眠
 * @Author: Rigid_Shuai
 * @Create: 2019-10-29 15:08:08
 */
public class ThreadSleep extends Thread {
    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            System.out.println(getName() + ":" + x + ",日期：" + FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
            // 睡眠
            // 困了，我稍微休息1秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadSleep ts1 = new ThreadSleep();
        ThreadSleep ts2 = new ThreadSleep();
        ThreadSleep ts3 = new ThreadSleep();

        ts1.setName("林青霞");
        ts2.setName("林志玲");
        ts3.setName("林志颖");

        ts1.start();
        ts2.start();
        ts3.start();
    }
}