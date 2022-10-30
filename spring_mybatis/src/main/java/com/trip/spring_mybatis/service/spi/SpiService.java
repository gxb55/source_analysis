package com.trip.spring_mybatis.service.spi;

import org.springframework.context.annotation.Configuration;

/**
 * @author xbguo
 * @createTime 2022年05月31日 14:29:00
 */
@Configuration
public class SpiService implements SpiInterface{
    public SpiService() {
        System.out.println("init");
    }
}
