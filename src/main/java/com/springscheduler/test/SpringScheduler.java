package com.springscheduler.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-02-27 14:45
 * @modified :
 **/
@Component
public class SpringScheduler {


    @Scheduled(cron="0/10 * *  * * ?")
    private void runtaskA(){
        TaskA.runA();
    }



    @Scheduled(cron="0/5 * *  * * ?")
    private void runtaskB(){
        TaskB.runB();
    }


}
