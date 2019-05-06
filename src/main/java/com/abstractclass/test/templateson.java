package com.abstractclass.test;

import org.springframework.stereotype.Service;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-02-21 14:27
 * @modified :
 **/
@Service
public class templateson extends template {
    @Override
    protected void work() {
        System.out.println("i am template son ");
    }
}
