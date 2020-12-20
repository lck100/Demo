package com.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    // 前置增强方法
    public void before(){
        System.out.println("前置代码增强...");
    }

    // 后置增强方法
    public void afterReturning(){
        System.out.println("后置代码增强");
    }

    // 环绕增强方法
    public Object around(ProceedingJoinPoint pij) throws Throwable {
        System.out.println("环绕前代码增强");
        Object proceed = pij.proceed();// 切点方法
        System.out.println("环绕前代码增强");
        return proceed;
    }

    // 异常抛出通知
    public void afterThrowing(){
        System.out.println("异常抛出通知");
    }

    // 最终通知
    public void after(){
        System.out.println("最终通知");
    }
}
