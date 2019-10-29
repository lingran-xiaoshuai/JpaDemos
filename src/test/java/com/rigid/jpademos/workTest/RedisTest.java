package com.rigid.jpademos.workTest;

import com.rigid.jpademos.utils.RedisUtils;
import io.lettuce.core.codec.CRC16;
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
 * @description: redis分片储存数据
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
        // 每次加1,做计数用
        redisUtils.hincr("test" + (id / 1000), String.valueOf(id), 1);
        // 根据key item 查询 value
        System.out.println(redisUtils.hget("test" + (id / 1000), String.valueOf(id)));
    }

    @Test
    public void test2() {
        String text = "哈哈";
        // 每次加1
//        redisUtils.hincr(CRC16, text, 1);
//        // 根据key item 查询 value
//        System.out.println(redisUtils.hget(, text);
    }

}
