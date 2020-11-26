package com.aax.learn.service;

import com.aax.learn.dao.StudentEntityDao;
import com.aax.learn.entity.StudentEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2020/11/26 15:16
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description：
 */
@Service
public class StudentService {

    @Resource
    private StudentEntityDao studentEntityDao;

    public StudentEntity insert(StudentEntity entity){
        studentEntityDao.insert(entity);
        return this.findOne(entity);
    }

    public int insertList(List<StudentEntity> entities){
        return studentEntityDao.insertList(entities);
    }

    public List<StudentEntity> findList(StudentEntity entity){
        return studentEntityDao.findList(entity);
    }

    public StudentEntity findOne(StudentEntity entity){
        return studentEntityDao.findOne(entity);
    }

    public StudentEntity update(StudentEntity entity){
        studentEntityDao.update(entity);
        return this.findOne(entity);
    }

    public StudentEntity delete(long id){
        studentEntityDao.delete(id);
        StudentEntity entity = new StudentEntity();
        entity.setId(id);
        return this.findOne(entity);
    }
}
