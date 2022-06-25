package com.study.mybatis.session;

/**
 * @description
 * @Author cxk
 * @Date 2022/6/24 16:51
 */
public interface SqlSession {

    /**
     * 根据指定的sqlID获取一条记录的封装对象
     * @param statement sqlID
     * @return Mapped Object 封装之后的对象
     * @param <T> 封装之后的对象类型
     */
    <T> T selectOne(String statement);

    /**
     * 根据指定的sqlID 获取一条记录的封装对象，只不过这个方允许我们可以给sql传递一些参数，
     * 一般在实际使用中，这个参数传递的是pojo，或者MPa或者immutableMap
     * @param statement
     * @param parameter
     * @return
     * @param <T>
     */
    <T> T selectOne(String statement,Object parameter);

    /**
     * 得到映射器，这个巧妙的使用了泛型，使得类型安全
     * @param type
     * @return
     * @param <T>
     */
    <T> T getMapper(Class<T> type);
}
