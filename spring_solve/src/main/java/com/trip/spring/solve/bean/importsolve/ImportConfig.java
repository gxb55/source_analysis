package com.trip.spring.solve.bean.importsolve;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xbguo
 * @date 2023/2/1 10:55
 */
@Configuration
@Import(value = {ImportDog.class, MyAspectJAutoProxyRegistrar.class})
public class ImportConfig {
    public ImportConfig() {
        System.out.println("ImportConfig");
    }
}
