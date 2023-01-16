package com.trip.spring.solve.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car implements InitializingBean {
    private int num;
    private String name;

    public Car() {
        System.out.println("Car init");
    }

    @Value("${JAVA_HOME}")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car.afterPropertiesSet");
    }
}
