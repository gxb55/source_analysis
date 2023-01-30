package com.trip.spring.solve.bean.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @date 2023/1/30 17:17
 */
@Component
public class A {

    private B b;

    @Autowired
    public void setB(B b) {
        this.b = b;
    }

    public A() {
        System.out.println("A 创建中...");
    }


}
