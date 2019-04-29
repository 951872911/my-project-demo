package com.ping.mybatis;


import java.io.IOException;
import javax.sql.DataSource;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;


/**
* @Description: mybatisMapper配置类
* @Param:
* @return:
* @Author: pzq
* @Date:
* @throw:
*/
@Configuration
@EnableTransactionManagement
public class MybatisConfig implements TransactionManagementConfigurer {

    private static Log logger = LogFactory.getLog(MybatisConfig.class);

    @Autowired
    DataSource dataSource;

    @Value("${mybatis-plus.config-location}")
    private String configLocation;

    @Value("${mybatis-plus.mapper-locations}")
    private String mapperLocations;


    @Bean
    SqlSessionFactory sqlSessionFactory() {
        try {
            MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(this.configLocation));
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(this.mapperLocations));
            return sqlSessionFactoryBean.getObject();
        } catch (IOException e) {
            logger.warn("mybatis resolver mapper*xml is error");
            return null;
        } catch (Exception e) {
            logger.warn("mybatis sqlSessionFactoryBean create error");
            return null;
        }

    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
