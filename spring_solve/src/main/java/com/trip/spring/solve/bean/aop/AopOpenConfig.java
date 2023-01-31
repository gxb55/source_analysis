package com.trip.spring.solve.bean.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @author xbguo
 * @createTime 2023年01月30日 21:38:00
 */
@Configuration
@EnableAspectJAutoProxy
@Import(MyAspectJAutoProxyRegistrar.class)
public class AopOpenConfig {
    public AopOpenConfig() {
        System.out.println("AopOpenConfig");
    }
}
