package com.rigid.jpademos.workTest.Thread;

import org.apache.commons.lang3.time.FastDateFormat;

/**
 * @Tool: Created with IntelliJ IDEA
 * @Program: JpaDemos
 * @Description: 线程终止
 * @Author: Rigid_Shuai
 * @Create: 2019-10-29 15:27:10
 */
public class ThreadStop extends Thread {

    @Override
    public void run() {
        System.out.println("开始执行：" + FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));

        // 我要休息10秒钟，亲，不要打扰我哦
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // e.printStackTrace();
            System.out.println("线程被终止了");
        }
        System.out.println("结束执行：" + FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
    }

    /**
     * public final void stop():让线程停止，过时了，但是还可以使用。
     * public void interrupt():中断线程。 把线程的状态终止，并抛出一个InterruptedException。
     */
    public static void main(String[] args) {
        ThreadStop ts = new ThreadStop();
        ts.start();
        // 你超过三秒不醒过来，我就干死你
        try {
            Thread.sleep(3000);
            //ts.stop();
            ts.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
