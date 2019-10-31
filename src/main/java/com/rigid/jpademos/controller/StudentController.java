package com.rigid.jpademos.controller;

import com.rigid.jpademos.entity.StudentEntity;
import com.rigid.jpademos.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: JpaDemos
 * @description:
 * @author: Rigid_Shuai
 * @create: 2019-09-06 09:50
 */
@RestController
@RequestMapping("student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @GetMapping("findAllStudent")
    public Object findAllStudent() {
        List<StudentEntity> allStudent = studentService.findAllStudent();
        return allStudent;
    }

    @GetMapping("findById")
    public Object findById(Integer id) {
        StudentEntity allStudent = studentService.findById(id);
        return allStudent;
    }

    @GetMapping("params")
    public Object findById(Integer id, String userName) {
        StudentEntity allStudent = studentService.queryByIdAndStudentNameOrderByIdDesc(id, userName);
        return allStudent;
    }

}
