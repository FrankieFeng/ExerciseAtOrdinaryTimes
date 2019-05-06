package com.hello.actions;

import com.hello.interfaces.Hello;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2018/1/21 下午5:28
 * @modified :
 **/
public class ChHello implements Hello {


    private String msg = null;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ChHello(String Msg){
        this.msg = Msg;
    }
    @Override
    public String doSlution() {
        return "你好啊" + this.msg;
    }
}
