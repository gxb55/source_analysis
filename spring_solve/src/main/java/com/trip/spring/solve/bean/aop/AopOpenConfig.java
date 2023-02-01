package com.trip.spring.solve.bean.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xbguo
 * @createTime 2023年01月30日 21:38:00
 */
@Configuration
@EnableAspectJAutoProxy
public class AopOpenConfig {
    public AopOpenConfig() {
        System.out.println("AopOpenConfig");
    }
}
