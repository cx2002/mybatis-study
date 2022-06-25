package com.study.mybatis.dao;

/**
 * @description
 * @Author cxk
 * @Date 2022/6/24 17:57
 */
public interface IUserDao {

    String queryUserName(String uid);

    String queryUserAge(String uid);
}
