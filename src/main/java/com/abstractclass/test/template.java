package com.abstractclass.test;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-02-21 14:26
 * @modified :
 **/
public abstract class template implements iquery{

    @Override
    public void doSomeThing() {
        work();
    }

    protected abstract void work();

}
