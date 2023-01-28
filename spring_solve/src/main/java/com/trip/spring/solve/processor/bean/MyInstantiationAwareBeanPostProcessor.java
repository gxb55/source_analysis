package com.trip.spring.solve.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @createTime 2023年01月16日 20:12:00
 * 代理对象，如果在这里创建成功就不往下走了
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * 在创建bean之前，会给一次机会看你是否可以直接实例化出来，如果实例化出来就结束了，不往下走了
     * org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#createBean(java.lang.String, org.springframework.beans.factory.support.RootBeanDefinition, java.lang.Object[])
     * 2
     *
     * @param beanClass the class of the bean to be instantiated
     * @param beanName  the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    /**
     * 在填充属性的时候会调用，根据返回值，如果返回值是false 属性填充就结束了
     * org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#populateBean(java.lang.String, org.springframework.beans.factory.support.RootBeanDefinition, org.springframework.beans.BeanWrapper)
     *
     * @param bean     the bean instance created, with properties not having been set yet
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");

        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessProperties");

        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    public MyInstantiationAwareBeanPostProcessor() {
        System.out.println("MyInstantiationAwareBeanPostProcessor.init");

    }

}
