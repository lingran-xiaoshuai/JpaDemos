package com.rigid.jpademos.workTest;

import com.rigid.jpademos.entity.StudentEntity;
import com.rigid.jpademos.service.StudentService;
import com.rigid.jpademos.utils.SpringContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: JpaDemos
 * @description:
 * @author: Rigid_Shuai
 * @create: 2019-10-28 13:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {

    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-28 13:37
     * @Description: spring Bean手动装配
     * @Param: []
     * @return: void
     */
    @Test
    public void test1() {
        //spring Bean手动装配
        StudentService studentService = SpringContextUtil.getBean(StudentService.class);

        List<StudentEntity> allStudent = studentService.findAllStudent();

        System.out.println(allStudent.toString());

    }

    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-28 13:39
     * @Description: 路径找到类
     * @Param: []
     * @return: void
     */
    @Test
    public void test2() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //路径找到类(模块打包,否则ClassNotFoundException异常)
        Class cls = Class.forName("com.rigid.jpademos.workTest.TimeTest");
        //如果调用这个方法的class或接口 与 参数cls表示的类或接口相同，或者是参数cls表示的类或接口的父类，则返回true
        if (TimeTest.class.isAssignableFrom(cls)) {
            //类型转换
            TimeTest timeTest = (TimeTest) cls.newInstance();
            timeTest.test4();
        }
    }


}
