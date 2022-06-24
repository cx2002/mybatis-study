package com.study.mybatis;

import com.study.mybatis.dao.IUserDao;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @Author cxk
 * @Date 2022/6/24 16:27
 */

public class ApiTest {

    @Test
    public void testMapperProxyFactory(){
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);
        Map<String,String> sqlSession = new HashMap<>();
        sqlSession.put("com.study.mybatis.dao.IUserDao.queryUserName","模拟执行查询sql");
        sqlSession.put("com.study.mybatis.dao.IUserDao.queryUserAge","模拟查询年龄sql");
        IUserDao iUserDao = factory.newInstance(sqlSession);
        String s = iUserDao.queryUserName("1001");
        System.out.println("测试结果：" + s);
        String s1 = iUserDao.queryUserAge("1");
        System.out.println("测试结果：" + s1);

    }

}
