package com.rigid.jpademos.workTest.Thread;

/**
 * @Tool: Created with IntelliJ IDEA
 * @Program: JpaDemos
 * @Description:
 * @Author: Rigid_Shuai
 * @Create: 2019-10-29 14:29:24
 */
public class MyThread2 extends Thread {
    /**
     * 该类要重写run()方法,为什么呢?
     * 不是类中的所有代码都需要被线程执行的。
     * 而这个时候，为了区分哪些代码能够被线程执行，java提供了Thread类中的run()用来包含那些被线程执行的代码。
     */

    public MyThread2() {
    }

    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            System.out.println(getName() + ":" + x);
        }
    }


    public static void main(String[] args) {
        // 创建线程对象
        // 无参构造 + setXxx()

        // MyThread2 my1 = new MyThread2();
        // MyThread2 my2 = new MyThread2();
        // //调用方法设置名称
        // my1.setName("林青霞");
        // my2.setName("刘意");
        // my1.start();
        // my2.start();
        
        //带参构造方法给线程起名字
         MyThread2 my1 = new MyThread2("林青霞");
         MyThread2 my2 = new MyThread2("刘意");
         my1.start();
         my2.start();


        //我要获取main方法所在的线程对象的名称，该怎么办呢?
        //遇到这种情况,Thread类提供了一个很好玩的方法:
        //public static Thread currentThread()返回当前正在执行的线程对象

        System.out.println(Thread.currentThread().getName());

    }
}
