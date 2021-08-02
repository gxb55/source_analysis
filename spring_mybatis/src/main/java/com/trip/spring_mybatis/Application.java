package com.trip.spring_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@MapperScan("com.trip.spring_mybatis.dao")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}
