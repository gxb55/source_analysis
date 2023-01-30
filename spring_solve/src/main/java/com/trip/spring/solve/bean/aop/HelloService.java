package com.trip.spring.solve.bean.aop;

import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @createTime 2023年01月30日 21:42:00
 */
@Component
public class HelloService {
    public String sayHello(String name) {
        String res = "你好" + name;
        System.out.println(res);
        return res + "---" + res.length();
    }

    public HelloService() {
        System.out.println("HelloService 构造方法");
    }
}
