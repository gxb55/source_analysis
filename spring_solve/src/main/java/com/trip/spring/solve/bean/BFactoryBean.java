package com.trip.spring.solve.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class BFactoryBean implements FactoryBean<B> {
    @Override
    public B getObject() throws Exception {
        System.out.println(System.currentTimeMillis());
        return new B();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
