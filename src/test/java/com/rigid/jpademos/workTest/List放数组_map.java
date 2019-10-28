package com.rigid.jpademos.workTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: JpaDemos
 * @description:
 * @author: Rigid_Shuai
 * @create: 2019-09-05 16:49
 */
public class List放数组_map {

    String json = "{\n" +
            "    \"taskInfo\": [\n" +
            "        {\n" +
            "            \"minPrice\": 100,\n" +
            "            \"giftPrice\": 10\n" +
            "        },\n" +
            "        {\n" +
            "            \"minPrice\": 200,\n" +
            "            \"giftPrice\": 20\n" +
            "        },\n" +
            "        {\n" +
            "            \"minPrice\": 500,\n" +
            "            \"giftPrice\": 40\n" +
            "        },\n" +
            "        {\n" +
            "            \"minPrice\": 1000,\n" +
            "            \"giftPrice\": 80\n" +
            "        },\n" +
            "        {\n" +
            "            \"minPrice\": 5000,\n" +
            "            \"giftPrice\": 200\n" +
            "        },\n" +
            "        {\n" +
            "            \"minPrice\": 10000,\n" +
            "            \"giftPrice\": 500\n" +
            "        },\n" +
            "        {\n" +
            "            \"minPrice\": 50000,\n" +
            "            \"giftPrice\": 1000\n" +
            "        }\n" +
            "    ],\n" +
            "    \"passType\": \"单关\",\n" +
            "    \"matchId\": \"201909021002\"\n" +
            "}";

    @Test
    public void test1() {
        //解析json(拿到活动详情)                    活动配置化文本
        JSONObject config = JSONObject.parseObject(json);
        JSONArray data = config.getJSONArray("taskInfo");
        JSONObject item;
        List<String[]> arrayList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (i == data.size() - 1) {
                item = data.getJSONObject(i);
                arrayList.add(new String[]{"X>=" + item.getString("minPrice"), item.getString("giftPrice")});
            } else {
                item = data.getJSONObject(i);
                String key = item.getString("minPrice");
                String value = item.getString("giftPrice");
                item = data.getJSONObject(i + 1);
                arrayList.add(new String[]{key + "<=X<" + item.getString("minPrice"), value});
            }
        }

        for (String[] strings : arrayList) {
            System.out.println(strings[0] + "--------------------" + strings[1]);
        }


    }

    @Test
    public void test2() {
        //转成json数组
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray data = jsonObject.getJSONArray("taskInfo");
        JSONObject item;
        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            HashMap<Object, Object> map = new HashMap<>();
            if (i == data.size() - 1) {
                item = data.getJSONObject(i);
                map.put("X>=" + item.getString("minPrice"), item.getString("giftPrice"));
            } else {
                item = data.getJSONObject(i);
                String key = item.getString("minPrice");
                String value = item.getString("giftPrice");
                item = data.getJSONObject(i + 1);
                map.put(key + "<=X<" + item.getString("minPrice"), value);

            }
            mapList.add(map);
        }

        for (Map map : mapList) {
            // 遍历map
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> entry = it.next();
                System.out.println("key: " + entry.getKey() + " -------------------- value: " +
                        entry.getValue());
            }

        }
    }

    @Test
    public void test3() {
        String json = "[{\"minPrice\":100,\"giftPrice\":10},\n" +
                " {\"minPrice\":200,\"giftPrice\":20},\n" +
                " {\"minPrice\":500,\"giftPrice\":40},\n" +
                " {\"minPrice\":1000,\"giftPrice\":80},\n" +
                " {\"minPrice\":5000,\"giftPrice\":200},\n" +
                " {\"minPrice\":10000,\"giftPrice\":500},\n" +
                " {\"minPrice\":50000,\"giftPrice\":1000}\n" +
                "]";

        //转成json数组
        JSONArray data = JSONObject.parseArray(json);
        //倒叙
        Collections.reverse(data);
        //定义价格
        BigDecimal price = new BigDecimal(100);
        //最少100奖励
        BigDecimal prices = new BigDecimal(100);
        //小于 时，返回 -1
        //等于 时，返回 0
        //大于 时，返回 1
        JSONObject item;
        if (price.compareTo(prices) >= 0) {
            for (int i = 0; i < data.size(); i++) {
                item = data.getJSONObject(i);
                if (price.compareTo(item.getBigDecimal("minPrice")) >= 0) {
                    System.out.println(item.getBigDecimal("giftPrice"));
                    break;
                }
            }
        } else {
            System.out.println("您的中奖金额不足，未能领取此任务奖励！");
        }
    }
}
