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
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;


    @GetMapping("/show")
    public Object show() {
        List<StudentEntity> allStudent = studentService.findAllStudent();
        return allStudent;
    }
}
