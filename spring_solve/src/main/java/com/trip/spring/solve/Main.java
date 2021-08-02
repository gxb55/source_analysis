package com.trip.spring.solve;

import com.trip.spring.solve.bean.Person;
import com.trip.spring.solve.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xbguo 郭晓兵
 * @date 2020-12-09 19:22
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person bean = context.getBean(Person.class);
        System.out.println(bean.getClass());
       /* Calculate calculate = context.getBean(Calculate.class);
        int add = calculate.add(1, 5);
        System.out.println("calculate.add: " + add);*/
    }
}
