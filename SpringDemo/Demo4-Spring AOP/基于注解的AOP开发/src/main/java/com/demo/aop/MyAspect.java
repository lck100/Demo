package com.demo.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect // 标注当前MyAspect是一个切面类
public class MyAspect {
    // 前置方法增强
    @Before("execution(* com.demo.aop.*.*(..))")
    public void before(){
        System.out.println("前置方法增强...");
    }

    // 后置方法增强（抽取execution表达式）
    @AfterReturning("MyAspect.pointcut()")
    public void afterReturning(){
        System.out.println("后置代码增强...");
    }

    @Pointcut("execution(* com.demo.aop.*.*(..))")
    public void pointcut(){}
}
