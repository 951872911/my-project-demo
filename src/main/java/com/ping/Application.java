package com.ping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
* @Description: 启动类
* @Param:
* @return:
* @Author: pzq
* @Date: 2019-04-14
* @throw:
*/
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "*.**.mapper")
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
