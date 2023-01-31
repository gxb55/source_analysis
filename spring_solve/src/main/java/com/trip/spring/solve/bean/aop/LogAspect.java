package com.trip.spring.solve.bean.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author xbguo
 * @createTime 2023年01月30日 21:44:00
 * 切面通知顺序
 * 1.前置通知Before
 * 2.方法执行
 * 3.AfterReturning 通知 /如果有异常则是 AfterThrowing
 * 4.After 通知
 */
@Component
@Aspect
public class LogAspect {
    @Before("execution(* com.trip.spring.solve.bean.aop.HelloService.sayHello(..))")
    public void logStart(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("logStart Before==>" + name + "...{args:" + JSON.toJSONString(joinPoint.getArgs()) + "}");

    }

    @AfterReturning(value = "execution(* com.trip.spring.solve.bean.aop.HelloService.sayHello(..))")
    public void logReturn(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("logReturn AfterReturning==>" + name + "...{args:" + JSON.toJSONString(joinPoint.getArgs()) + "}");
    }

    @After("execution(* com.trip.spring.solve.bean.aop.HelloService.sayHello(..))")
    public void logEnd(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("logEnd After==>" + name + "...{args:" + JSON.toJSONString(joinPoint.getArgs()) + "}");
    }

    @AfterThrowing("execution(* com.trip.spring.solve.bean.aop.HelloService.sayHello(..))")
    public void logError(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("logError AfterThrowing==>" + name + "...{args:" + JSON.toJSONString(joinPoint.getArgs()) + "}");
    }


    public LogAspect() {
        System.out.println("LogAspect 构造方法");
    }
}
