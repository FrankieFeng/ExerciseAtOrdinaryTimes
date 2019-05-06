package com.cache.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-01-31 11:03
 * @modified :
 **/
@Component
@Aspect
public class RedisLockAspect {

    private static Logger logger = LoggerFactory.getLogger(RedisLockAspect.class);

    @Value("redis://10.237.78.33:6379")
    String address;

    @Around("execution(* com.cache.test..*(..))&& @annotation(RedisLock)")
    public Object lock(ProceedingJoinPoint point) throws Throwable {
        RLock lock = null;
        Object object = null;
        logger.info("into Aspect!");
        try {
            RedisLock redisLock = getDistRedisLockInfo(point);
            RedisUtils redisUtils = RedisUtils.getInstance();
            RedissonClient redissonClient = redisUtils.createClient(address, null);
            String lockKey = redisUtils.getLockKey(point, redisLock.lockKey());

            lock = redisUtils.getRLock(redissonClient, lockKey);
            if (lock != null) {
                Boolean status = lock.tryLock(redisLock.maxSleepMills(), redisLock.keepMills(), TimeUnit.MILLISECONDS);
                if (status) {
                    object = point.proceed();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return object;
    }

    private RedisLock getDistRedisLockInfo(ProceedingJoinPoint point) {
        try {
            MethodSignature methodSignature = (MethodSignature) point.getSignature();
            Method method = methodSignature.getMethod();
            return method.getAnnotation(RedisLock.class);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return null;
    }


}
