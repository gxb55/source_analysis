package com.trip.spring.solve.demo.ProxyTest;

/**
 * @author xbguo
 * @createTime 2022年10月25日 22:08:00
 */
public class UserServiceImpl {
    public void login() {
        System.out.println("用户登录......");
    }

    public Integer sayHello() {
        System.out.println("Hello World!!!");
        return 1;
    }
}
