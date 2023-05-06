package com.trip.spring_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@MapperScan(basePackages = "com.trip.spring_mybatis.dao")
@SpringBootApplication
//@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        SpringApplication.run(Application.class, args);
    }

}
