package com.cache.test;

import java.lang.annotation.*;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-01-31 11:02
 * @modified :
 **/
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RedisLockKey {

    /**
     *   * key的拼接顺序规则
     *  
     */
    int order() default 0;

}
