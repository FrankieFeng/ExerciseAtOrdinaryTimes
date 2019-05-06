package com.mutithread.chapter0_1;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2018/6/28 上午9:44
 * @modified :
 **/
public class PrintThread_2 implements Runnable{

    private String message ;

    public PrintThread_2(String message){
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(message);
        }
    }
}
