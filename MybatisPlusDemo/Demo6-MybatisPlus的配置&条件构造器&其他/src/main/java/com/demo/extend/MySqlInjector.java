package com.demo.extend;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.List;

/**
 * @author lcl100
 * @create 2021-05-24 16:36
 */
public class MySqlInjector extends DefaultSqlInjector {// 继承DefaultSqlInjector类

    // 重写里面的getMethodList()方法
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        // 获取方法列表
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        // 在列表中添加自定义的方法
        methodList.add(new FindAll());
        // 最后返回列表
        return methodList;
    }
}
