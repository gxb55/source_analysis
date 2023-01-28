package com.trip.spring.solve.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @author xbguo
 * @createTime 2023年01月16日 20:15:00
 * 创建代理对象的时候会用到这个后置处理器
 */
@Component
public class MySmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
    /**
     * 推断bean类型，针对还未实例化的bean
     * 1
     * @param beanClass the raw class of the bean
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("MySmartInstantiationAwareBeanPostProcessor.predictBeanType");
        return SmartInstantiationAwareBeanPostProcessor.super.predictBeanType(beanClass, beanName);
    }

    /**
     * 实例化的时候会通过这个方法来走构造函数，如果没有定义则走即的，如果定义了，则走定义的
     * 3.
     * @param beanClass the raw class of the bean (never {@code null})
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
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
