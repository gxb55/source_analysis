package com.trip.spring.solve.bean.factory;

import org.springframework.beans.factory.FactoryBean;

//@Component
public class PersonFactoryBean implements FactoryBean<Emp> {
    @Override
    public Emp getObject() throws Exception {
        System.out.println(System.currentTimeMillis());
        return new Emp();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
