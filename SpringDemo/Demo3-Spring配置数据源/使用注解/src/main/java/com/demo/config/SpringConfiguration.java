package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 该注解表示该类是Spring的配置类
@Configuration
// <context:component-scan base-package="com.demo"/>
// 等价于下面的注解，实现组件扫描
@ComponentScan("com.demo")
// <import resource="xxx.xml" />
// 相当于下面的注解
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {
    // 该类相当于总配置类
}
