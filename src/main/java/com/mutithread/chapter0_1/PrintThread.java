package com.mutithread.chapter0_1;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2018/6/28 上午9:41
 * @modified :
 **/
public class PrintThread extends Thread {
    private String message ;

    public PrintThread(String message){
        this.message = message;
    }

    public void run(){
        for (int i = 0; i < 10000; i++) {
            System.out.println(message);
        }
    }


}
