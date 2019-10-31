package com.rigid.jpademos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @tool: Created with IntelliJ IDEA
 * @program: jpademos
 * @description: springboot 启动入口
 * @description:  @EnableScheduling  定时器
 * @description:  @EntityScan("com.caimao.reptile.entity") 引入实体
 * @description:  @SpringBootApplication(scanBasePackages = "com.caimao.reptile") 接口
 * @author: Rigid
 * @create: 2019-08-26 11:09
 */
@SpringBootApplication
public class JpademosApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpademosApplication.class, args);
    }

}
