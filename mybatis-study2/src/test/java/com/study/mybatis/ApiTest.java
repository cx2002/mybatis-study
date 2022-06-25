package com.study.mybatis;

import com.study.mybatis.binding.MapperRegistry;
import com.study.mybatis.dao.IUserDao;
import com.study.mybatis.session.SqlSession;
import com.study.mybatis.session.SqlSessionFactory;
import com.study.mybatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;

/**
 * @description
 * @Author cxk
 * @Date 2022/6/24 17:46
 */
public class ApiTest {

    @Test
    public void testMapperProxyFactory(){
        // 注册Mapper
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMappers("com.study.mybatis.dao");
        // 获取SqlSession
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        String s = mapper.queryUserName("10001");
        System.out.println("测试结果： " + s);
    }

}
