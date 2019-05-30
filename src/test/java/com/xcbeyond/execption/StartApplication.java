package com.xcbeyond.execption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 测试启动Tomcat容器类
 * @Auther: xcbeyond
 * @Date: 2019/5/28 16:54
 */
@SpringBootApplication
public class StartApplication {
    public static void main(String[] agrs) {
        SpringApplication.run(StartApplication.class,agrs);
    }
}