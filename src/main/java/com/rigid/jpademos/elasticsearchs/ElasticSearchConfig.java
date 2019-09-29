package com.rigid.jpademos.elasticsearchs;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: CaimaoReptile
 * @description: 处理与redis架包的冲突问题
 * @description: https://blog.csdn.net/qq_39996837/article/details/88777599
 * @author: Rigid_Shuai
 * @create: 2019-09-20 11:05
 */
@Configuration
public class ElasticSearchConfig {

    @PostConstruct
    void init() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }
}
