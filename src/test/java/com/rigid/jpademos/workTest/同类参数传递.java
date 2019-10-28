package com.rigid.jpademos.workTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: JpaDemos
 * @description:
 * @author: Rigid_Shuai
 * @create: 2019-09-05 16:32
 */
public class 同类参数传递 {

    /**
     * 如果 @Override
     * @param param
     * @return
     */
    public int test(int param) {
        return this.test(param, new HashMap<>());
    }


    public int test(int param, Map<String, Object> map) {
        map.put("a", 456);
        return param;
    }

    @Test
    public void rewardTest() {
        HashMap<String, Object> map = new HashMap<>(16);
        System.out.println(this.test(123, map));
        System.out.println(map.get("a"));

    }
}
