package com.rigid.jpademos.workTest.MultiThread;

/**
 * @Tool: Created with IntelliJ IDEA
 * @Program: JpaDemos
 * @Description: 模拟电影院抢票继承Thread
 * @Author: Rigid_Shuai
 * @Create: 2019-10-29 15:36:26
 */
public class SellTicket extends Thread {
    // 定义100张票
    // 为了让多个线程对象共享这100张票，我们其实应该用静态修饰
    private static int tickets = 10000;

    @Override
    public void run() {
        // 定义100张票
        // 每个线程进来都会走这里，这样的话，每个线程对象相当于买的是自己的那100张票，这不合理，所以应该定义到外面
        // int tickets = 100;
        // 是为了模拟一直有票
        while (true) {
            if (tickets > 0) {
                System.out.println(getName() + "正在出售第" + (tickets--) + "张票");
            }
        }
    }

    public static void main(String[] args) {
        // 创建三个线程对象
        SellTicket st1 = new SellTicket();
        SellTicket st2 = new SellTicket();
        SellTicket st3 = new SellTicket();

        // 给线程对象起名字
        st1.setName("窗口1");
        st2.setName("窗口2");
        st3.setName("窗口3");
        //优先级
        //st2.setPriority(8);
        // 启动线程
        st1.start();
        st2.start();
        st3.start();
    }
}