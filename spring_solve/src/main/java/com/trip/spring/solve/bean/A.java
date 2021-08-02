package com.trip.spring.solve.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    @Autowired
    private B b;

    public A() {
        System.out.println("hi im A");
    }
}
