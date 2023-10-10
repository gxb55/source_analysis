package com.example.my_start.config;

import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @date 2023/10/10 18:51
 */
@Component
public class MyStartAutoConfiguration {
    public MyStartAutoConfiguration() {
        System.out.println("MyStartAutoConfiguration start");
    }
}
