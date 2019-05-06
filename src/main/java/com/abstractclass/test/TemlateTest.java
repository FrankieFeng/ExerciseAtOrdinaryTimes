package com.abstractclass.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-02-21 14:31
 * @modified :
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class TemlateTest {
    @Autowired
    iquery templateson;

    @Test
    public void testWork(){
        templateson.doSomeThing();
    }
}
