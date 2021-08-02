package com.trip.spring.solve.bean;


import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TulingLogAspect {

    @Pointcut(("execution(* com.trip.spring.solve.bean.TulingCalculate.*(..))"))
    public void pointCut(){}

    @Before("pointCut()")
    public void before(){

        System.out.println("Before");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取方法参数值数组
        Object[] args = joinPoint.getArgs();

        System.out.println("请求参数为"+ JSON.toJSONString(args));
        //动态修改其参数
        //注意，如果调用joinPoint.proceed()方法，则修改的参数值不会生效，必须调用joinPoint.proceed(Object[] args)
        Object result = joinPoint.proceed(args);
        System.out.println("响应结果为{}"+result);
        //如果这里不返回result，则目标对象实际返回值会被置为null
        return result;
    }

    @AfterReturning("pointCut()")
    public void AfterReturning(){
        System.out.println("AfterReturning");
    }

    @AfterThrowing("pointCut()")
    public void AfterThrowing(){
        System.out.println("AfterThrowing");
    }

    @After("pointCut()")
    public void After(){
        System.out.println("After");
    }


}
