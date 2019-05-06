package com.cache.test;

import org.springframework.stereotype.Component;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-01-31 11:23
 * @modified :
 **/
@Component
public class LockTest {
    private static int i = 0;

    @RedisLock(lockKey = "lockKey" ,keepMills = 5*10000 )
    public  void add(@RedisLockKey(order = 1) String key,
                    @RedisLockKey(order = 0) int key1) {
        i++;
        System.out.println("i=***************************************" + i);
    }
}
