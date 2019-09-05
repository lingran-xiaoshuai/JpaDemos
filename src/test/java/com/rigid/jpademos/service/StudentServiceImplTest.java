package com.rigid.jpademos.service;

import com.rigid.jpademos.entity.StudntEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void findAllStudent() {
        /**
         * 查找全部数据
         */
        List<StudntEntity> studntEntityList = studentService.findAllStudent();
        //数据量
        System.out.println(studntEntityList.size());
        if (studntEntityList.size() > 0) {
            //循环输出
            for (StudntEntity studntEntity : studntEntityList) {
                System.out.println(studntEntity.toString());
            }
        }
    }

    /**
     * @Author: Rigid
     * @Date: 2019-08-26 13:42
     * @Description: 根据ID查找数据
     * @Param: []
     * @return: void
     */
    @Test
    public void findStudentById() {
        StudntEntity studntEntity = studentService.findById(3);
        //输出
        if (studntEntity != null) {
            System.out.println(studntEntity.toString());
        } else {
            System.out.println("数据不存在!");
        }
    }

    /**
     * @Author: Rigid
     * @Date: 2019-08-26 13:42
     * @Description: 添加数据
     * @Param: []
     * @return: void
     */
    @Test
    public void studentAdd() {
        //实例化对象
        StudntEntity studntEntity = new StudntEntity();
        studntEntity.setStudntName("丽莉");
        studntEntity.setStudentAge(22);
        studntEntity.setStudentSex("2");
        //调用方法
        studentService.studentAdd(studntEntity);
        //集合里面自增的数据返回了(刷循缓存)
        if (studntEntity.getId() > 0) {
            System.out.println("添加成功!");
        } else {
            System.out.println("添加失败!");
        }
    }


    /**
     * @Author: Rigid
     * @Date: 2019-08-26 13:53
     * @Description: 删除数据
     * @Param: []
     * @return: void
     */
    @Test
    public void deleteStudentById() {
        //实例化对象
        StudntEntity studntEntity = new StudntEntity();
        Integer id = 2;
        studntEntity.setId(id);

        //调用方法(存在删除)
        if (studentService.findById(id) != null) {
            //删除方法
            studentService.deleteStudent(studntEntity);
            if (studentService.findById(id) == null) {
                System.out.println("删除成功!");
            } else {
                System.out.println("删除失败!");
            }
        } else {
            System.out.println("数据不存在!");
        }


    }


    @Test
    public void 截取字符串() {

        /**
         * 截取title里面的数据
         * 截取title里面的数据
         */

        String text1 = "<span id='acrPopover'  title='4.0 out of 5 stars'>";
        String text2 = "<span id=\"acrPopover\"  \" title=\"4.0 out of 5 stars\">";

        System.out.println(text1.split("title=")[1].replace("'", "").replace(">", ""));
        System.out.println(text2.split("title=")[1].replace("\"", "").replace(">", ""));

        /**
         * ------------正则截取
         * ------------正则截取
         */

        String text3 = "（责任编辑：黄莺）";
        String authorTest = "(?<=责任编辑：).{1,5}(?=）)";
        //String pattern = "(?<=责任编辑：).*(?=）)";
        // 创建 Pattern 对象
        Pattern pattern = Pattern.compile(authorTest);
        // 现在创建 matcher 对象
        Matcher matcher = pattern.matcher(text3);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }

        //正向后瞻 (?<=pattern) 匹配前面是pattern的字符串
        //正向预测(?=pattern),即查找一个字符串，该字符串的后边接有符合pattern条件的子字符串，但此pattern为非匹配捕获，即不需要获取以供以后使用

        String text4 = "<span id='acrPopover'  title='4.0 out of 5 stars'>";
        String authorTest1 = "(?<=title=').*(?='>)";
        // 创建 Pattern 对象
        Pattern pattern1 = Pattern.compile(authorTest1);
        // 现在创建 matcher 对象
        Matcher matcher1 = pattern1.matcher(text4);
        if (matcher1.find()) {
            System.out.println(matcher1.group());
        }
    }


}