package com.rigid.jpademos.dao;

import com.rigid.jpademos.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @tool: Created with IntelliJ IDEA
 * @program: jpademos
 * @description: (一定要继承JpaRepository < 实体类明称, 主键类型 >, JpaSpecificationExecutor < 实体类明称 >)
 * @author: Rigid
 * @create: 2019-08-26 11:09
 */
public interface StudentDAO extends JpaRepository<StudentEntity, Integer>, JpaSpecificationExecutor<StudentEntity> {
    /**
     * 继承JpaRepository已提供很多默认查询方法,所以不是复杂查询不用再写接口
     */

    StudentEntity queryByIdAndStudentNameOrderByIdDesc(int id, String userName);
}
