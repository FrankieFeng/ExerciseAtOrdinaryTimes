package com.cache.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-01-31 11:23
 * @modified :
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")

public class AOPTest {

    @Autowired
    LockTest lockTest;

    @Test
    public void testDistLockAop() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockTest.add("***********testDistLockAop", 99);
            }).start();
        }

        TimeUnit.SECONDS.sleep(20);

    }


    @Test
    public void testDistLock() throws InterruptedException {
        lockTest.add("============testDistLock", 111111);
        TimeUnit.SECONDS.sleep(10);
    }
}
