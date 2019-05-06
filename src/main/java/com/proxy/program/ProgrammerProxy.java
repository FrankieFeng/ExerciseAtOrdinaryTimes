package com.proxy.program;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2018/4/22 下午9:19
 * @modified :
 **/
public class ProgrammerProxy implements MethodInterceptor {


    /**
     * 内部持有委托类对象的引用
     */
    private Object target;

    /**
     * 创建代理类对象
     */
    public Programmer createProxy(Programmer object) {
        target = object; //创建Enhancer对象
        Enhancer enhancer = new Enhancer(); //设置要代理的目标类，以扩展功能
        enhancer.setSuperclass(this.target.getClass()); //设置单一回调对象，在回调中拦截对目标方法的调用
        enhancer.setCallback(this);// 设置类加载
        enhancer.setClassLoader(object.getClass().getClassLoader()); //创建代理对象
        return (Programmer) enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        doBefore();
        method.invoke(target, params); //调用之后处理
        doAfter();
        return null;
    }

    private void doAfter() {
        System.out.println("do after.");
    }

    private void doBefore() {
        System.out.println("do before.");
    }


}
