package com.study.mybatis.session;

/**
 * @description
 * @Author cxk
 * @Date 2022/6/24 17:02
 */
public interface SqlSessionFactory {

    /**
     * 打开一个session会话
     * @return
     */
    SqlSession openSession();

}
