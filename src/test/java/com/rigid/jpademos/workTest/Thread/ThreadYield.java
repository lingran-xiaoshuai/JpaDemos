package com.rigid.jpademos.workTest.Thread;

/**
 * @Tool: Created with IntelliJ IDEA
 * @Program: JpaDemos
 * @Description: 线程礼让
 * @Author: Rigid_Shuai
 * @Create: 2019-10-29 15:20:03
 */
public class ThreadYield extends Thread {

    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            System.out.println(getName() + ":" + x);
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        ThreadYield ty1 = new ThreadYield();
        ThreadYield ty2 = new ThreadYield();
        ty1.setName("林青霞");
        ty2.setName("刘意");
        ty1.start();
        ty2.start();
    }
}