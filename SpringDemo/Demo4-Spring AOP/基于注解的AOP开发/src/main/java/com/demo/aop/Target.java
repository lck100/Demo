package com.demo.aop;

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {
    public void method() {
        System.out.println("Target running...");
    }
}
