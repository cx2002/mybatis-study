package com.study.mybatis.dao;

/**
 * @description
 * @Author cxk
 * @Date 2022/6/24 16:26
 */
public interface IUserDao {

    String queryUserName(String uid);

    String queryUserAge(String uid);

}
