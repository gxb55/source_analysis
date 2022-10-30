package com.trip.spring.solve.demo.ProxyTest;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xbguo
 * @createTime 2022年10月25日 21:42:00
 */
public class CglibProxy {
    public static void main(String[] args) {


      /*  Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();*/


        UserServiceImpl target = new UserServiceImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new LogInterceptor(target));
        UserServiceImpl userService = (UserServiceImpl) enhancer.create();
        userService.login();

/*
        UserServiceImpl u = new UserServiceImpl();
        CglibProxyFactory c = new CglibProxyFactory(u);
        UserServiceImpl us = (UserServiceImpl) c.createProxy();
        us.login();*/
    }
}
class LogInterceptor implements MethodInterceptor{
    private Object object;

    public LogInterceptor() {
    }

    public LogInterceptor(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = method.invoke(object, args);
        System.out.println("cglib日志操作。。。。。。。。");
        return result;

    }

   /* public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib日志操作。。。。。。。。");
        return method.invoke(object,args);
    }*/
}