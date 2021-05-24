package com.demo.extend;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @author lcl100
 * @create 2021-05-24 16:39
 */
public class FindAll extends AbstractMethod {// 继承AbstractMethod类

    // 并重写injectMappedStatement方法
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        // 定义的方法名
        String methodName = "findAll";
        // 拼接SQL语句
        String sql = "select * from " + tableInfo.getTableName();// 获取表名
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return addSelectMappedStatementForTable(mapperClass, methodName, sqlSource, tableInfo);
    }
}
