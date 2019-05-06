package com.springscheduler.test;

import org.joda.time.DateTime;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-02-27 14:45
 * @modified :
 **/
public class TaskB {

    public static void runB(){
        System.out.println(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println("i am task b , run once time per 5 seconds");
    }
}
