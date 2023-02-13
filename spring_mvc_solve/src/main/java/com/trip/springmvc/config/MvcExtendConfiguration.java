package com.trip.springmvc.config;

import com.trip.springmvc.view.BeautyViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xbguo
 * @createTime 2023年02月11日 19:59:00
 */
@EnableWebMvc
@Configuration
public class MvcExtendConfiguration implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(new BeautyViewResolver());
    }
}
