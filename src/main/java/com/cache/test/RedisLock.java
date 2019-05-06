package com.cache.test;

import java.lang.annotation.*;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-01-31 11:02
 * @modified :
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RedisLock {

    /**
     *   * 锁的key
     *   * 如果想添加非固定锁，可以在参数上添加@P4jSynKey注解，但是本参数是必写选项<br/>
     *   * redis key的拼写规则为 "DistRedisLock+" + lockKey + @RedisLOckKey<br/>
     *  
     */
    String lockKey();

    /**
     *   * 持锁时间
     *   * 单位毫秒,默认5秒<br/>
     *  
     */
    long keepMills() default 5 * 1000;

    /**
     *   * 没有获取到锁时，等待时间
     *   * @return
     *  
     */
    long maxSleepMills() default 120 * 1000;

}
