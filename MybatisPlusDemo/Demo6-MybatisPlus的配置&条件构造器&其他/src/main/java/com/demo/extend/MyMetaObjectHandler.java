package com.demo.extend;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author lcl100
 * @create 2021-05-24 17:39
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 获取密码字段
        Object password = getFieldValByName("password", metaObject);
        // 判断密码字段是否为空，如果为空则进行自动填充，如果不为空则不进行自动填充
        if (null == password) {
            // 字段为空，进行填充
            setFieldValByName("password", "999999", metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
