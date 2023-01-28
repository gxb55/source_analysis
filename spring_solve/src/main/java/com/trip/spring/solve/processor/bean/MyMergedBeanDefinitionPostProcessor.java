package com.trip.spring.solve.processor.bean;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @createTime 2023年01月16日 20:14:00
 * 内部的bean处理器
 */
@Component
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
    /**
     * bean定义信息的合并，在属性填充之前
     * 4
     * @param beanDefinition the merged bean definition for the bean
     * @param beanType the actual type of the managed bean instance
     * @param beanName the name of the bean
     */
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        System.out.println("MyMergedBeanDefinitionPostProcessor.postProcessMergedBeanDefinition");
    }

    public MyMergedBeanDefinitionPostProcessor() {
        System.out.println("MyMergedBeanDefinitionPostProcessor.init");

    }
}
