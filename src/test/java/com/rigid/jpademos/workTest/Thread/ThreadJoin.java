package com.rigid.jpademos.workTest.Thread;

/**
 * @Tool: Created with IntelliJ IDEA
 * @Program: JpaDemos
 * @Description: 线程加入
 * @Author: Rigid_Shuai
 * @Create: 2019-10-29 15:15:09
 */
public class ThreadJoin extends Thread {
    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            System.out.println(getName() + ":" + x);
        }
    }

    public static void main(String[] args) {
        ThreadJoin tj1 = new ThreadJoin();
        ThreadJoin tj2 = new ThreadJoin();
        ThreadJoin tj3 = new ThreadJoin();

        tj1.setName("李渊");
        tj2.setName("李世民");
        tj3.setName("李元霸");

        tj1.start();
        try {
            tj1.join(); //tj1结束后，其他线程才能运行。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tj2.start();
        tj3.start();
    }
}
