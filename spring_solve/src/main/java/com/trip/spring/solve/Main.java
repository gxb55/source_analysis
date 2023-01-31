package com.trip.spring.solve;

import com.trip.spring.solve.bean.aop.HelloService;
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
        annotationStart();

        // xmlStart();
    }

    private static void annotationStart() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService bean = context.getBean(HelloService.class);
        bean.sayHello("gxb");
        System.out.println(bean);

       // System.out.println(context.getBean(MyAspectJAutoProxyRegistrar.class));
    }

    private static void xmlStart() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        Customer bean = applicationContext.getBean(Customer.class);
        System.out.println(bean);
    }
}
