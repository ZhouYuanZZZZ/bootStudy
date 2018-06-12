package com.zy.study.bootstudy.config;

import com.zy.study.bootstudy.properties.OdmConfigProperties;
import org.activiti.engine.ProcessEngine;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;


public class ActivitiConfig {

    @Resource
    private OdmConfigProperties odmConfigProperties;

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(@Qualifier("mysqlDb1")DataSource dataSource,PlatformTransactionManager transactionManager){

        SpringProcessEngineConfiguration springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
        springProcessEngineConfiguration.setDataSource(dataSource);
        springProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
        springProcessEngineConfiguration.setTransactionManager(transactionManager);
        return springProcessEngineConfiguration;
    }

//    @Bean
//    public ProcessEngineFactoryBean processEngineFactoryBean(SpringProcessEngineConfiguration springProcessEngineConfiguration){
//        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
//        processEngineFactoryBean.setProcessEngineConfiguration(springProcessEngineConfiguration);
//        return processEngineFactoryBean;
//    }

    @Bean
    public ProcessEngine processEngine(SpringProcessEngineConfiguration springProcessEngineConfiguration){
        ProcessEngine processEngine = springProcessEngineConfiguration.buildProcessEngine();
        return processEngine;
    }
}
