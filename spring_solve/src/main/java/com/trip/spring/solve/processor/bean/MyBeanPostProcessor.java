package com.trip.spring.solve.processor.bean;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @createTime 2023年01月16日 20:08:00
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public MyBeanPostProcessor() {
        System.out.println("MyBeanPostProcessor.init");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("MyBeanPostProcessor.postProcessAfterInitialization");
        return bean;
    }
}
