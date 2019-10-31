package com.rigid.jpademos.workTest.MultiThread;

/**
 * @Tool: Created with IntelliJ IDEA
 * @Program: JpaDemos
 * @Description: 实现runnable
 * @Author: Rigid_Shuai
 * @Create: 2019-10-30 09:16:54
 */
public class SellTicketRunnable1 implements Runnable {
    private  int tickets = 1000;

    @Override
    public void run() {
        while (true) {
            // t1,t2,t3三个线程
            // 这一次的tickets = 100;
            if (tickets > 0) {
                // 为了模拟更真实的场景，我们稍作休息
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");

                // 理想状态：
                // 窗口1正在出售第100张票
                // 窗口2正在出售第99张票
                // 但是呢?

                // CPU的每一次执行是一个原子性(最简单基本的)的操作：
                // 1.t1记录以前的票数100(1.5.t2记录了以前的票数100)
                // 2.t1执行tickets--99(2.5.t2执行tickets--98)
                // 3.t1输出记录的值100:窗口1正在出售第100张票
                // 4.t2输出记录的值100:窗口2正在出售第100张票
            }
        }
    }


    public static void main(String[] args) {
        // 创建资源对象
        SellTicketRunnable1 st = new SellTicketRunnable1();
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
