package com.trip.spring.solve.config;

/**
 * @author xbguo 郭晓兵
 * @date 2020-12-09 20:01
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.trip")
public class AppConfig {
}
