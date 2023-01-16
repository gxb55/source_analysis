package com.trip.spring.solve.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:jdbc.properties"})
public class Car {
    private int num;
    @Value("$(name)")
    private String name;

    @Autowired
    private Person person;
}
