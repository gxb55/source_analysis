package com.trip.spring.solve.bean.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @date 2023/1/30 17:17
 */
@Component
public class B {
    private A a;

    public B() {
        System.out.println("B 创建中...");
    }
    @Autowired
    public void setA(A a) {
        this.a = a;
    }
    public String sayB(String name) {
        String res = "你好" + name;
        System.out.println(res);
        return res + "---" + res.length();
    }
}
