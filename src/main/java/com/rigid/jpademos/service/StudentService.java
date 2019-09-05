package com.rigid.jpademos.service;

import com.rigid.jpademos.entity.StudntEntity;

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
    List<StudntEntity> findAllStudent();

    /**
     * 根据id查找数据
     *
     * @param id
     * @return
     */
    StudntEntity findById(int id);

    /**
     * 添加数据(对象)
     *
     * @param studntEntity
     */
    void studentAdd(StudntEntity studntEntity);

    /**
     * 删除数据
     *
     * @param studntEntity
     */
    void deleteStudent(StudntEntity studntEntity);
}


