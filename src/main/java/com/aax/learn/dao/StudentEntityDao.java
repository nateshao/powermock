package com.aax.learn.dao;

/**
 * @date Created by 邵桐杰 on 2020/11/26 15:13
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description：
 */
@Mapper
public interface StudentEntityDao {

    int insert(@Param("pojo") StudentEntity pojo);

    int insertList(@Param("pojos") List< StudentEntity> pojo);

    List<StudentEntity> findList(@Param("pojo") StudentEntity pojo);

    StudentEntity findOne(@Param("pojo") StudentEntity pojo);

    int update(@Param("pojo") StudentEntity pojo);

    int delete(@Param("id") long id);
}
