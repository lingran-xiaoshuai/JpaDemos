package com.rigid.jpademos.service;

import com.rigid.jpademos.entity.StudentEntity;

import java.util.List;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: jpademos
 * @description:
 * @author: Rigid
 * @create: 2019-08-26 11:13
 */
public interface StudentService {
    /**
     * 查找全部数据
     *
     * @return
     */
    List<StudentEntity> findAllStudent();

    /**
     * 根据id查找数据
     *
     * @param id
     * @return
     */
    StudentEntity findById(int id);

    /**
     * 添加数据(对象)
     *
     * @param studentEntity
     */
    void studentAdd(StudentEntity studentEntity);

    /**
     * 删除数据
     *
     * @param studentEntity
     */
    void deleteStudent(StudentEntity studentEntity);

    /**
     *  参数查询
     * @param id
     * @param userName
     * @return
     */
    StudentEntity queryByIdAndStudentNameOrderByIdDesc(Integer id, String userName);
}


