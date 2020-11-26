package com.aax.learn.controller;

import com.aax.learn.common.RestfulPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @date Created by 邵桐杰 on 2020/11/26 15:12
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description：
 */
@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = RestfulPath.getStudents)
    public List<StudentEntity> getStudents(StudentEntity req) {
        return studentService.findList(req);
    }

    @PostMapping(value = RestfulPath.postStudent, consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentEntity create(@RequestBody StudentEntity req) {
        return studentService.insert(req);
    }

    @PutMapping(value = RestfulPath.putStudent, consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentEntity update(@RequestBody StudentEntity req) {
        return studentService.update(req);
    }

    @DeleteMapping(value = RestfulPath.deleteStudent)
    public StudentEntity delete(@PathVariable("id") long id) {
        return studentService.delete(id);
    }
}
