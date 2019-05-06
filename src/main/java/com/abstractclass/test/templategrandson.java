package com.abstractclass.test;

import org.springframework.stereotype.Service;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-02-21 14:27
 * @modified :
 **/
@Service
public class templategrandson extends templateson {
    @Override
    public void work() {
        System.out.println("i am template grandson");
    }
}
