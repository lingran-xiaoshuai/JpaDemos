package com.rigid.jpademos.workTest;

import com.rigid.jpademos.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: JpaDemos
 * @description:
 * @author: Rigid_Shuai
 * @create: 2019-10-28 10:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisUtils redisUtils;

    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-28 10:26
     * @Description: has int类型的分片
     * @Param: []
     * @return: void
     */
    @Test
    public void test1() {
        int id = 5321;
        redisUtils.hincr("test" + (id / 1000), String.valueOf(id), 1);
    }

}
