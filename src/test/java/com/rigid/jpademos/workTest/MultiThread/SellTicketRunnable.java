package com.rigid.jpademos.workTest.MultiThread;

import org.apache.commons.lang3.time.FastDateFormat;

/**
 * @Tool: Created with IntelliJ IDEA
 * @Program: JpaDemos
 * @Description: 实现runnable
 * @Author: Rigid_Shuai
 * @Create: 2019-10-30 09:16:54
 */
public class SellTicketRunnable implements Runnable {

    // 定义100张票
    // 为了让多个线程对象共享这100张票，我们其实应该用静态修饰
    private static int tickets = 100;

    @Override
    public void run() {
        // 定义100张票
        // 每个线程进来都会走这里，这样的话，每个线程对象相当于买的是自己的那100张票，这不合理，所以应该定义到外面
        // int tickets = 100;
        // 是为了模拟一直有票
        while (true) {
            if (tickets > 0) {
                String format = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss ms").format(System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票 -->" + format);
            }
        }
    }

    public static void main(String[] args) {
        // 创建资源对象
        SellTicketRunnable st = new SellTicketRunnable();
        // 创建三个线程对象
        Thread t1 = new Thread(st, "窗口1");
        Thread t2 = new Thread(st, "窗口2");
        Thread t3 = new Thread(st, "窗口3");

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
