package com.trip.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbguo
 * @createTime 2023年02月07日 21:46:00
 */
@Configuration
@ComponentScan(value = {"com.trip.springmvc"},
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class, RestController.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = {SpringMVCConfig.class})
})
public class SpringConfig {
}
