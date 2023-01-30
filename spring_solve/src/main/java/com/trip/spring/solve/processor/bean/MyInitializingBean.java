package com.trip.spring.solve.processor.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @createTime 2023年01月16日 20:10:00
 * bean的初始化处理器，不带参数
 */
//@Component
public class MyInitializingBean implements InitializingBean, SmartInitializingSingleton {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyInitializingBean.afterPropertiesSet");

    }

    public MyInitializingBean() {
        System.out.println("MyInitializingBean.init");
    }

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("MyInitializingBean.afterSingletonsInstantiated,所有的bean创建完成后展示");
    }
}
