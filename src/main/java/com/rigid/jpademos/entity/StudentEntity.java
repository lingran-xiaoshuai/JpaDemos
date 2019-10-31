package com.rigid.jpademos.entity;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Tool: Created with IntelliJ IDEA
 * @Program: JpaDemos
 * @Description:  通过name属性指定映射到数据库表的表名
 * @Author: Rigid_Shuai
 * @Create: 2019-10-31 09:02:50
 */
@Entity
@Table(name = "student", catalog = "jpatest")
public class StudentEntity implements Serializable {
    private int id;
    private String studentName;
    private Integer studentAge;
    private String studentSex;

    public StudentEntity() {
    }

    public StudentEntity(int id, String studentName, Integer studentAge, String studentSex) {
        this.id = id;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentSex = studentSex;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "student_name", nullable = true, length = 255)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "student_age", nullable = true)
    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    @Basic
    @Column(name = "student_sex", nullable = true)
    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
