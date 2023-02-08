package com.trip.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author xbguo
 * @createTime 2023年02月08日 21:50:00
 */
@Configuration
@ComponentScan(value = {"com.trip.springmvc"}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
}, useDefaultFilters = false)
public class SpringMVCConfig {
}
