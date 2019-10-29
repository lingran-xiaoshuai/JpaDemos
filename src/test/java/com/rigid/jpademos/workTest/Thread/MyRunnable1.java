package com.rigid.jpademos.workTest.Thread;

/**
 * @Tool: Created with IntelliJ IDEA
 * @Program: JpaDemos
 * @Description:
 * @Author: Rigid_Shuai
 * @Create: 2019-10-29 14:42:53
 */
public class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            // 实现接口的方式，不能直接使用Thread类的方法了，但可以间接使用
            System.out.println(Thread.currentThread().getName() + ":" + x);
        }

    }

    public static void main(String[] args) {
        // 创建MyRunnable类的对象
        MyRunnable1 my = new MyRunnable1();
        // 创建Thread类的对象，并把C步骤的对象作为构造参数传递
        //Thread(Runnable target);

        // Thread t1 = new Thread(my);
        // Thread t2 = new Thread(my);
        // t1.setName("林青霞");
        // t2.setName("刘意");

        //Thread(Runnable target,String name);
        Thread t1 = new Thread(my, "林青霞");
        Thread t2 = new Thread(my, "刘意");
        t1.start();
        t2.start();

    }
}
