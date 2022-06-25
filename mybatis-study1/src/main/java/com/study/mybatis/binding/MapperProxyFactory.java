package com.study.mybatis.binding;


import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @description 代理工厂将代理的创建操作封装了一层，如果不进行封装则需要每次使用Proxy.new方法创建实例对象
 * @Author cxk
 * @Date 2022/6/24 16:21
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String,String> sqlSession){
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession,mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},mapperProxy);
    }
}
