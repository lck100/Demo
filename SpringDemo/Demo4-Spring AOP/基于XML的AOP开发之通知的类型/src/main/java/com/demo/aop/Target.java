package com.demo.aop;

public class Target implements TargetInterface {
    public void method() {
        int i=1/0;// 人为制造异常
        System.out.println("Target running...");
    }
}
