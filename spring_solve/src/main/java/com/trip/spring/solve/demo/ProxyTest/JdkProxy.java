package com.trip.spring.solve.demo.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xbguo
 * @createTime 2022年10月25日 21:31:00
 */
public class JdkProxy {
    public static void main(String[] args) {
        Class<?>[] interfaces = {UserInterface.class};
        UserInterfaceImpl userInterface = new UserInterfaceImpl();

        UserInterface o = (UserInterface) Proxy.newProxyInstance(userInterface.getClass().getClassLoader(), interfaces, new UserProxy(userInterface));
        System.out.println(o.add(1, 2));
    }
}

class UserProxy implements InvocationHandler {
    private Object object;

    public UserProxy(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke name:"+ method.getName());
        Object invoke = method.invoke(object, args);
        return invoke;
    }
}