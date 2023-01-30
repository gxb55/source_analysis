package com.trip.spring.solve.bean.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @date 2023/1/29 14:43
 */
@Component
public class HelloFactory implements FactoryBean<Hello> {
    @Override
    public Hello getObject() throws Exception {
        return new Hello();
    }

    @Override
    public Class<?> getObjectType() {
        return Hello.class;
    }
}
