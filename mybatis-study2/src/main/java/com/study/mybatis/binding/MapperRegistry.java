package com.study.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import com.study.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description
 * @Author cxk
 * @Date 2022/6/24 16:47
 */
public class MapperRegistry {

    /**
     * 将已添加的映射器代理加入到HashMap中
     */
    private final Map<Class<?>,MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession){
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null){
            throw new RuntimeException("Type " + type +"is not known to the MapperRegistry");
        }
        return mapperProxyFactory.newInstance(sqlSession);
    }

    public <T> void addMapper(Class<T> type){
        // 接口才进行注册操作
        if (type.isInterface()){
            if (hasMapper(type)){
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            // 注册映射器到代理工厂
            knownMappers.put(type,new MapperProxyFactory<>(type));
        }
    }

    /**
     * 扫描添加包内的所有映射器
     * @param packageName
     */
    public void addMappers(String packageName){
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        mapperSet.forEach(this::addMapper);
    }

    private <T> boolean hasMapper(Class<T> type){
        return knownMappers.containsKey(type);
    }
}
