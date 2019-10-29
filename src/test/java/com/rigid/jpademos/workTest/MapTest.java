package com.rigid.jpademos.workTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: JpaDemos
 * @description: map集合key value的判断
 * @author: Rigid_Shuai
 * @create: 2019-10-28 15:05
 */
public class MapTest {

    /**
     * @Author: Rigid_Shuai
     * @Date: 2019-10-28 15:07
     * @Description: 判断map中有指定的key--> boolean
     * @Param: []
     * @return: void
     */
    @Test
    public void test1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("123", 123);
        map.put("456", 456);

        //判断map中有无指定的key
        boolean b = map.containsKey("789");
        System.out.println(b);

        //判断map中有无指定的value
        boolean b1 = map.containsValue(789);
        System.out.println(b1);

        //移除指定的key
        map.remove("123");
        System.out.println(map.get("123"));
        System.out.println(map.get("456"));

    }
}
