package com.proxy.program;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2018/4/22 下午9:17
 * @modified :
 **/
public class Programmer {


    private String name;

    public void setName(String name) {
        System.out.println("Setting Name.");
        this.name = name;
    }

    public void code() {
        System.out.println(name + " is writing bugs.");
    }

}
