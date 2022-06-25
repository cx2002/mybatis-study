package com.study.mybatis.session.defaults;

import com.study.mybatis.binding.MapperRegistry;
import com.study.mybatis.session.SqlSession;
import com.study.mybatis.session.SqlSessionFactory;

/**
 * @description 默认的简单工厂实现，处理开启SqlSession时，对DefaultSqlSession的创建以及传递mapperRegistry，
 *              以便于在石笋SqlSession时获取每个代理类的映射器对象。
 * @Author cxk
 * @Date 2022/6/24 17:02
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }


    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
