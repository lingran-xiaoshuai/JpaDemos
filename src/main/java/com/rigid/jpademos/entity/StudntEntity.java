package com.rigid.jpademos.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: jpademos
 * @description:
 * @author: Rigid
 * @create: 2019-08-26 11:05
 */
@Entity   //标记该实体映射到数据库表
@Table(name = "studnt", catalog = "jpatest")  //通过name属性指定映射到数据库表的表名
public class StudntEntity {
    private int id;
    private String studntName;
    private Integer studentAge;
    private String studentSex;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "studnt_name", nullable = false, length = 255)
    public String getStudntName() {
        return studntName;
    }

    public void setStudntName(String studntName) {
        this.studntName = studntName;
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
    @Column(name = "student_sex", nullable = true, length = 255)
    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    @Override
    public String toString() {
        return "StudntEntity{" +
                "id=" + id +
                ", studntName='" + studntName + '\'' +
                ", studentAge=" + studentAge +
                ", studentSex='" + studentSex + '\'' +
                '}';
    }
}
