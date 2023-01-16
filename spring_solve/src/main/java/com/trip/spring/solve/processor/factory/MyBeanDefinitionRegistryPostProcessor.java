package com.trip.spring.solve.processor.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @createTime 2023年01月16日 20:16:00
 *
 * 1.这个类是beanFactory的后置处理器
 * 2.在refresh方法中会先处理 BeanDefinitionRegistryPostProcessor 根据注解的优先级来处理（PriorityOrdered Ordered ）
 * 3.会执行beanFactoryPostProcessor的接口即 postProcessBeanFactory，其中的优先级跟上面一样
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory");

    }

    public MyBeanDefinitionRegistryPostProcessor() {
        System.out.println("MyBeanDefinitionRegistryPostProcessor.init");

    }
}
