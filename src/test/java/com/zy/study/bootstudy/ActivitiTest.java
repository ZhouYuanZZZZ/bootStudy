package com.zy.study.bootstudy;

import com.alibaba.fastjson.JSON;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiTest {
    
    private static final Logger logger = LoggerFactory.getLogger(ActivitiTest.class);

    @Resource
    private ProcessEngine processEngine;

    @Test
    public void test0(){
        RepositoryService repositoryService = processEngine.getRepositoryService();

        DeploymentBuilder deployment = repositoryService.createDeployment();
        deployment.addClasspathResource("processes/TaxpayerConfigurationRequest.bpmn");
        deployment.addClasspathResource("processes/TaxpayerConfigurationRequest.png");
        Deployment deploy = deployment.deploy();

        logger.info(JSON.toJSONString(deploy));
    }

    @Test
    public void test1(){
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //runtimeService.startProcessInstanceByKey()

    }
}
