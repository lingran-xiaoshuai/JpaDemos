package com.rigid.jpademos.workTest.MultiThread;

/**
 * @Tool: Created with IntelliJ IDEA
 * @Program: JpaDemos
 * @Description:
 * @Author: Rigid_Shuai
 * @Create: 2019-10-30 09:35:45
 */
public class SellTicketRunnable2 implements Runnable {
    // 定义100张票
    private int tickets = 100;
    // 创建锁对象
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (new Object()) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建资源对象
        SellTicketRunnable2 st = new SellTicketRunnable2();
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

