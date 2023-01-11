package com.trip.spring.cc.configurate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xbguo
 * @createTime 2023年01月08日 19:33:00
 */

@Configuration
public class MyConfigurate {
    @Bean
    public Persion getPersion(){
        Persion persion = new Persion();
        persion.setName("zs");
        return persion;
    }
}
