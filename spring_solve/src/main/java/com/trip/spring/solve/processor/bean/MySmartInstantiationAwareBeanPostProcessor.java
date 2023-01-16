package com.trip.spring.solve.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @author xbguo
 * @createTime 2023年01月16日 20:15:00
 */
@Component
public class MySmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("MySmartInstantiationAwareBeanPostProcessor.predictBeanType");
        return SmartInstantiationAwareBeanPostProcessor.super.predictBeanType(beanClass, beanName);
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("MySmartInstantiationAwareBeanPostProcessor.determineCandidateConstructors");
        return SmartInstantiationAwareBeanPostProcessor.super.determineCandidateConstructors(beanClass, beanName);
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        System.out.println("MySmartInstantiationAwareBeanPostProcessor.getEarlyBeanReference");
        return SmartInstantiationAwareBeanPostProcessor.super.getEarlyBeanReference(bean, beanName);
    }

    public MySmartInstantiationAwareBeanPostProcessor() {
        System.out.println("MySmartInstantiationAwareBeanPostProcessor.init");

    }
}
