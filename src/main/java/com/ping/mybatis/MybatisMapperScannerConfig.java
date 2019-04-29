package com.ping.mybatis;





import org.mybatis.spring.mapper.MapperScannerConfigurer;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
* @Description: mybatisMapperScanner配置类
* @Param:
* @return:
* @Author: pzq
* @Date:
* @throw:
*/
@Configuration
@AutoConfigureAfter({MybatisConfig.class})
public class MybatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //扫描该路径下的dao
        mapperScannerConfigurer.setBasePackage("*.**.mapper");
        return mapperScannerConfigurer;
    }

}
