package com.trip.springmvc.service;

import org.springframework.stereotype.Service;

/**
 * @author xbguo
 * @createTime 2023年02月08日 21:54:00
 */
@Service
public class HelloService {
    public String sayHello(String name) {
        return "hello " + name;
    }

    public HelloService() {
        System.out.println("HelloService。。。");
    }
}
