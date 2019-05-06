package com.mutithread.chapter0_1;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2018/6/28 上午9:46
 * @modified :
 **/
public class PrintMessageMain {
    public static void main(String[] args) {

        new PrintThread("线程1").start();
        new PrintThread_2("线程2").run();
    }
}
