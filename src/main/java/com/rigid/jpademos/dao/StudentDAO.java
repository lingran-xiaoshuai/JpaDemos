package com.rigid.jpademos.dao;

import com.rigid.jpademos.entity.StudntEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @tool: Created with IntelliJ IDEA
 * @program: jpademos
 * @description: (一定要继承JpaRepository < StudntEntity, Integer >, JpaSpecificationExecutor < StudntEntity >)
 * @author: Rigid
 * @create: 2019-08-26 11:09
 */
public interface StudentDAO extends JpaRepository<StudntEntity, Integer>, JpaSpecificationExecutor<StudntEntity> {
    /**
     * 继承JpaRepository已提供很多默认查询方法,所以不是复杂查询不用再写接口
     */

}
