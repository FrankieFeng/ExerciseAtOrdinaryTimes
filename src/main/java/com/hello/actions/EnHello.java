package com.hello.actions;

import com.hello.interfaces.Hello;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2018/1/21 下午5:28
 * @modified :
 **/
public class EnHello implements Hello {

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg = null;

    @Override
    public String doSlution() {
        return "hello " + this.msg;
    }
}
