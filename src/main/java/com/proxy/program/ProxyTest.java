package com.proxy.program;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2018/4/22 下午9:28
 * @modified :
 **/
public class ProxyTest {

    @Test
    public void testCglibProxy() {
        //创建一个Programmer
        Programmer programmerA = new Programmer();
        programmerA.setName("Frank");
        //创建代理对象
        Programmer programmerProxyA = new ProgrammerProxy().createProxy(programmerA);
        programmerProxyA.code();
        //修改代理对象
        programmerProxyA.setName("Wang");
        programmerProxyA.code();
        //修改委托类对象
        programmerA.setName("Song");
        programmerProxyA.code();
    }

    @Test
    public void testCglibInterface(){
        IAgeMapper ageMapper = new IAgeMapper() {
            @Override
            public String getAge(String name) {
                return null;
            }
        };
        IAgeMapper proxyAgeMapper = new AgeMapperProxy().createProxy(ageMapper);
    }

    @Test
    public void testCompare(){
       /* List<String> list = new ArrayList<String>();
        Collections.sort(list);
        System.out.println(list);

        String a = "2018-04-23 15:33:47";
        System.out.println(a.substring(0,a.length()-3));*/


        System.out.println(new DateTime().toString("HH:mm"));
        System.out.println(DateTime.parse("2019-02-27 19:37", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm")).toString("HH:mm"));
    }

}
