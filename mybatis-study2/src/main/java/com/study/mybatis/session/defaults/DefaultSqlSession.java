package com.study.mybatis.session.defaults;

import com.study.mybatis.binding.MapperRegistry;
import com.study.mybatis.session.SqlSession;

/**
 * @description
 * @Author cxk
 * @Date 2022/6/24 16:56
 */
public class DefaultSqlSession implements SqlSession {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！方法：" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！方法：" + statement + "，入参：" + parameter.toString());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type,this);
    }
}
