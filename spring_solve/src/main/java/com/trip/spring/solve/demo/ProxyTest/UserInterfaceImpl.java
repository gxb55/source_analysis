package com.trip.spring.solve.demo.ProxyTest;

/**
 * @author xbguo
 * @createTime 2022年10月25日 21:33:00
 */
public class UserInterfaceImpl implements UserInterface{
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String getName(String name) {
        return name;
    }
}
