package com.trip.spring.solve.demo.ProxyTest;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xbguo
 * @createTime 2022年10月25日 22:14:00
 */
public class CglibProxyFactory implements MethodInterceptor {
    private Object target;
    public CglibProxyFactory(Object target){
        this.target=target;
    }

    public Object createProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib日志操作。。。。。。。。");
        return method.invoke(target,args);
    }
}
