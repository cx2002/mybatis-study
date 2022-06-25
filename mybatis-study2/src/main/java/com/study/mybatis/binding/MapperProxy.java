package com.study.mybatis.binding;


import com.study.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description 实现关系映射，对外接口提供
 * @Author cxk
 * @Date 2022/6/24 16:11
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionID = -16656454585610L;

    private final SqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface){
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this,args);
        }
        return sqlSession.selectOne(method.getName(),args);
    }
}
