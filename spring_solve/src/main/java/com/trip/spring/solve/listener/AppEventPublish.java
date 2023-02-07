package com.trip.spring.solve.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @date 2023/2/7 19:02
 *
 *
 * 1.org.springframework.context.annotation.AnnotationConfigUtils#registerAnnotationConfigProcessors(org.springframework.beans.factory.support.BeanDefinitionRegistry, java.lang.Object)
 * 2.EventListenerMethodProcessor ; DefaultEventListenerFactory
 */
@Component
public class AppEventPublish implements ApplicationContextAware {
    private ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }
    public void publishMsg(ApplicationEvent event){
        //ApplicationEventMulticaster
        context.publishEvent(event);
    }
}
