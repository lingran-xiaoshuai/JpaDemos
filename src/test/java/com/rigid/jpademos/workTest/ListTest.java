package com.rigid.jpademos.workTest;

import com.rigid.jpademos.entity.StudentEntity;
import com.rigid.jpademos.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: JpaDemos
 * @description: (( 旧容量 * 3) / 2) + 1  List初始化长度扩容规则 动态增长的数量变化：10->16->25->38->58->88->...
 * @author: Rigid_Shuai
 * @create: 2019-10-28 09:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ListTest {
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentService studentService;

    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-28 9:34
     * @Description: 集合的过滤和排序
     * @Param: []
     * @return: void
     */
    @Test
    public void test1() {
        StudentEntity studentEntity;
        List<StudentEntity> studentEntityList = new ArrayList<>(256);
        for (int i = 10; i > 0; i--) {
            studentEntity = new StudentEntity();
            studentEntity.setId(i);
            studentEntityList.add(studentEntity);
        }

        //过滤集合 --> item.getId() != 5
        studentEntityList = studentEntityList.stream().filter((item) ->
                item.getId() != 5 && item.getId() != 10
        ).collect(Collectors.toList());

        //输出过滤后的集合
        for (StudentEntity entity : studentEntityList) {
            logger.info(entity.toString());
        }

        //排序  ASC(默认)--> 从低到高    DESC--> 从高到低
        Collections.sort(studentEntityList, Comparator.comparing(StudentEntity::getId));

        //输出过滤排序后的集合
        for (StudentEntity entity : studentEntityList) {
            logger.info(entity.toString());
        }

        // DESC--> 从高到低
        Collections.sort(studentEntityList, Comparator.comparing(StudentEntity::getId).reversed());

        //不借助stream的排序
//        list.sort(Comparator.comparing(Integer::intValue));
//        list.sort(Comparator.comparing(Integer::intValue).reversed())

        //输出过滤排序后的集合
        for (StudentEntity entity : studentEntityList) {
            logger.info(entity.toString());
        }
    }

    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-28 10:05
     * @Description: 对象的实例化
     * @Param: []
     * @return: void
     */
    @Test
    public void test2() {
        StudentEntity studentEntity = new StudentEntity(1, "123", 1, "123");
        System.out.println(studentEntity.toString());
    }

    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-28 10:06
     * @Description: 对象实例化的缓存--> 集合
     * @Param: []
     * @return: void
     */
    @Test
    public void test3() {
        List<StudentEntity> studentEntityList = studentService.findAllStudent();
        Map<String, StudentEntity> entityMap = new HashMap<>(studentEntityList.size());
        for (StudentEntity studentEntity : studentEntityList) {
            entityMap.put(studentEntity.getId() + "-" + studentEntity.getStudentName(), studentEntity);
        }

        StudentEntity studentEntity = entityMap.get(1 + "-" + "帅");
        System.out.println(studentEntity.toString());
    }


}
