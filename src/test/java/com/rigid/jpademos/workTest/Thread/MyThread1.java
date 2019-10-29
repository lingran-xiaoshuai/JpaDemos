package com.rigid.jpademos.workTest.Thread;

/**
 * @Tool: Created with IntelliJ IDEA
 * @Program: JpaDemos
 * @Description: java多线程
 * @Author: Rigid_Shuai
 * @Create: 2019-10-29 14:09:09
 */
public class MyThread1 extends Thread {

    @Override
    public void run() {
        // 自己写代码
        // System.out.println("好好学习，天天向上");
        // 一般来说，被线程执行的代码肯定是比较耗时的。所以我们用循环改进
        for (int x = 0; x < 200; x++) {
            System.out.println(x);
        }
    }


    public static void main(String[] args) {
        // 调用run()方法为什么是单线程的呢?
        // 因为run()方法直接调用其实就相当于普通的方法调用,所以你看到的是单线程的效果
        // 要想看到多线程的效果，就必须说说另一个方法：start()

        // 面试题：run()和start()的区别?

        // run():仅仅是封装被线程执行的代码，直接调用是普通方法
        // start():首先启动了线程，然后再由jvm去调用该线程的run()方法。

//         MyThread1 my = new MyThread1();
//         my.start();
//         my.start();
        // IllegalThreadStateException:非法的线程状态异常
        //  为什么呢?
        // 因为这个相当于是my线程被启动了两次。而不是启动两个线程。


        // 创建两个线程对象
        MyThread1 myThread1 = new MyThread1();
        MyThread1 myThread112 = new MyThread1();
        myThread1.run();
        myThread112.run();
    }
}
