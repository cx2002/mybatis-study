package com.study.mybatis;


import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @description 实现关系映射，对外接口提供
 * @Author cxk
 * @Date 2022/6/24 16:11
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionID = -16656454585610L;

    private final Map<String,String> sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(Map<String,String> sqlSession,Class<T> mapperInterface){
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this,args);
        }else{

            return "你的被代理了！" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
        }
    }
}
