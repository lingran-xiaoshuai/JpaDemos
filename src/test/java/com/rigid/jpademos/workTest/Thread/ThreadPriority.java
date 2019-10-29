package com.rigid.jpademos.workTest.Thread;

/**
 * @Tool: Created with IntelliJ IDEA
 * @Program: JpaDemos
 * @Description: 线程优先级
 * @Author: Rigid_Shuai
 * @Create: 2019-10-29 15:02:20
 */
public class ThreadPriority extends Thread {
    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            System.out.println(getName() + ":" + x);
        }
    }

    /**
     *  * 注意：
     *  *   线程默认优先级是5。
     *  *   线程优先级的范围是：1-10。
     *  *   线程优先级高仅仅表示线程获取的CPU时间片的几率高，要在次数比较多，或者多次运行的时候才能看到比较好的效果。
     *  * IllegalArgumentException:非法参数异常。
     *  * 抛出的异常表明向方法传递了一个不合法或不正确的参数。
     *  * 
     */
    public static void main(String[] args) {
        ThreadPriority tp1 = new ThreadPriority();
        ThreadPriority tp2 = new ThreadPriority();
        ThreadPriority tp3 = new ThreadPriority();

        tp1.setName("东方不败");
        tp2.setName("岳不群");
        tp3.setName("林平之");


        // 获取默认优先级
        System.out.println(tp1.getPriority());
        System.out.println(tp2.getPriority());
        System.out.println(tp3.getPriority());

        // 设置线程优先级  --> 错误 1-10
        //tp1.setPriority(100000);

        //设置正确的线程优先级
        tp1.setPriority(10);
        tp2.setPriority(1);

        tp1.start();
        tp2.start();
        tp3.start();

    }

}
