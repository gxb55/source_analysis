package com.trip.spring.solve;

import com.trip.spring.solve.bean.Calculate;
import com.trip.spring.solve.bean.Person;
import com.trip.spring.solve.bean.resourceeditor.Customer;
import com.trip.spring.solve.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xbguo 郭晓兵
 * @date 2020-12-09 19:22
 */
public class Main {
    public static void main(String[] args) {
        //annotationStart();

        xmlStart();
    }

    private static void annotationStart() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person bean = context.getBean(Person.class);
        System.out.println(bean.getClass());
        Calculate calculate = context.getBean(Calculate.class);
        int add = calculate.add(1, 5);
        System.out.println("calculate.add: " + add);

        Object b = context.getBean("personFactoryBean");
        Object b1 = context.getBean("personFactoryBean");
        System.out.println(b);
        System.out.println(b1);
    }

    private static void xmlStart() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        /*Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);  */
        Customer c = (Customer) applicationContext.getBean("customer");
        System.out.println(c);
    }
}
