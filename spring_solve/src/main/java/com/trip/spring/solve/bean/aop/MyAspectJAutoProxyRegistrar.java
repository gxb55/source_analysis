package com.trip.spring.solve.bean.aop;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xbguo
 * @createTime 2023年01月31日 22:15:00
 */
public class MyAspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar {
    public MyAspectJAutoProxyRegistrar() {
        System.out.println("MyAspectJAutoProxyRegistrar");
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
      System.out.println("MyAspectJAutoProxyRegistrar.registerBeanDefinitions");
    }
}
