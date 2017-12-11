package com.zy.study.bootstudy.config;

import com.zy.study.bootstudy.entity.JdbcProperties;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
public class Odm {

    private static final Logger logger = LoggerFactory.getLogger(Odm.class);

    @Bean
    public DataSource dataSource(JdbcProperties properties){
        DataSource dataSource = new DataSource();

        dataSource.setUrl(properties.getUrl());
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource,JdbcProperties properties){

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setConfigLocation(resolver.getResources(properties.getMybatisConfigLocationLocation())[0]);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException(e);
        }

        return sqlSessionFactoryBean;
    }

    public MapperScannerConfigurer mapperScannerConfigurer(JdbcProperties properties){

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //扫描Mapper配置文件与接口的包名
        mapperScannerConfigurer.setBasePackage(properties.getMapperScannerConfigurerBasePackage());
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");

        return mapperScannerConfigurer;
    }
}
