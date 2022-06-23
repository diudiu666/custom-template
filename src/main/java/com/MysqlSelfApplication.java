package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *测试启动类
 *@author :Muggle.Wang
 *Create in 8:42 2021/6/23
 */
@SpringBootApplication()
@EnableCaching
public class MysqlSelfApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlSelfApplication.class, args);
    }

}
