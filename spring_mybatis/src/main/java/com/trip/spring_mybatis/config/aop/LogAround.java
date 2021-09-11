package com.trip.spring_mybatis.config.aop;

import com.alibaba.fastjson.JSON;
import com.trip.spring_mybatis.config.annotation.Clog;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Administrator
 */
@Component
@Slf4j
@Aspect
public class LogAround {
    @Pointcut(value = "@annotation(com.trip.spring_mybatis.config.annotation.Clog)")
    public void log() {
    }

    @Before("log()")
    public void before() {
        log.info("before..");
    }

    @Around("log()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Long start = System.currentTimeMillis();

        //获取类的字节码对象，通过字节码对象获取方法信息
        Class<?> targetClass = joinPoint.getTarget().getClass();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();


        Method declaredMethod = targetClass.getDeclaredMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        String name = declaredMethod.getName();
        Clog annotation = declaredMethod.getAnnotation(Clog.class);
        String value = StringUtils.isBlank(annotation.value()) ? name : annotation.value();
        Object[] args = joinPoint.getArgs();

        log.info("method start:{} title:{} params:{}", name, value, JSON.toJSONString(args));
        Object proceed = joinPoint.proceed();
        log.info("method end:{} result:{},time:{}", name, JSON.toJSONString(proceed), (System.currentTimeMillis() - start));
        return proceed;
    }

    @After("log()")
    public void after(JoinPoint joinPoint) {
        log.info("after..");
    }

    @AfterReturning("log()")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("afterReturning..");
    }

    @AfterThrowing(value = "log()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        log.info("afterThrowing..");
    }
}
