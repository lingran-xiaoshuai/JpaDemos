package com.rigid.jpademos.service;

import com.rigid.jpademos.dao.StudentDAO;
import com.rigid.jpademos.entity.StudntEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: jpademos
 * @description:
 * @author: Rigid
 * @create: 2019-08-26 11:14
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDAO studentDAO;

    @Override
    public List<StudntEntity> findAllStudent() {
        //DAO继承   提供很多方法自测下(百度)
        return studentDAO.findAll();
    }

    @Override
    public StudntEntity findById(int id) {
        //多种查询(百度测试)
        Optional<StudntEntity> optionalStudntEntity = studentDAO.findById(id);
        //判断不为空,否则get方法会出现异常
        if (optionalStudntEntity != null && optionalStudntEntity.isPresent()) {
            //返回对象数据(get方法)
            return optionalStudntEntity.get();
        }
        return null;
    }

    @Override
    public void studentAdd(StudntEntity studntEntity) {
        //会刷新缓存,所以无需返回值(添加成功后新的id返回到对象里面)
        studentDAO.saveAndFlush(studntEntity);
    }


    @Override
    public void deleteStudent(StudntEntity studntEntity) {
        studentDAO.delete(studntEntity);
    }


}
