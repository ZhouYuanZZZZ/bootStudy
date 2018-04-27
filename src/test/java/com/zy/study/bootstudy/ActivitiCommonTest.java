package com.zy.study.bootstudy;

import com.zy.study.bootstudy.utils.FileUtil;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.NativeTaskQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ActivitiCommonTest {
    
    private static final Logger logger = LoggerFactory.getLogger(ActivitiCommonTest.class);

    private ProcessEngine processEngine;
    
    @Before
    public void setUp(){
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();

        processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
        processEngineConfiguration.setDatabaseSchemaUpdate("true");
        processEngineConfiguration.setJdbcUrl("jdbc:mysql://192.168.1.142:3306/zy?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        processEngineConfiguration.setJdbcUsername("root");
        processEngineConfiguration.setJdbcPassword("root");
        //设置是否自动更新
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

         processEngine = processEngineConfiguration.buildProcessEngine();
    }

    @After
    public void release(){
        processEngine.close();
    }

    @Test
    public void test0(){
        RepositoryService repositoryService = processEngine.getRepositoryService();

        DeploymentBuilder deployment = repositoryService.createDeployment();
        deployment.addClasspathResource("processes/TaxpayerConfigurationRequest.bpmn");
        deployment.addClasspathResource("processes/TaxpayerConfigurationRequest.png");
        Deployment deploy = deployment.deploy();

        logger.info(deploy.getId());
        logger.info(deploy.getKey());
        logger.info(deploy.getName());
    }
    
    @Test
    public void test1(){
        RuntimeService runtimeService = processEngine.getRuntimeService();
        UUID uuid = UUID.randomUUID();
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("reqUid", "reqUid:"+uuid);
        paraMap.put("identifier","identifier:"+uuid);
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("TaxpayerConfigurationRequestProcess","businessKey",paraMap);

        logger.info(instance.getDeploymentId());
        logger.info(instance.getId());
        logger.info(instance.getActivityId());
        logger.info(instance.getBusinessKey());
        logger.info(instance.getName());
    }
    
    @Test
    public void test2(){
        TaskService taskService = processEngine.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskCandidateGroup("RG:32cc7840-5079-494b-8cc3-386f2f081e71");
        List<Task> list = taskQuery.list();

        for (Task task:list){
            logger.info(task.getId());
            logger.info(task.getAssignee());
            logger.info(task.getDescription());
            logger.info(task.getName());
        }
    }

    @Test
    public void test3(){
        TaskService taskService = processEngine.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskCandidateGroup("RG:32cc7840-5079-494b-8cc3-386f2f081e71");
        List<Task> list = taskQuery.list();

        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("requestAction","approve");
        taskService.complete(list.get(0).getId(),paraMap);

    }

    @Test
    public void queryProcessDef(){
        /*
        * id key:version:random
        * name 对应流程文件process节点的name属性
        * key 对应流程文件的process节点的id属性
        * version 发布时自动生成,初始值为1,低版本向高版本升级时会累加*/

        RepositoryService repositoryService = processEngine.getRepositoryService();

        DeploymentQuery deploymentQuery = repositoryService.createDeploymentQuery();
        deploymentQuery.processDefinitionKey("TaxpayerConfigurationRequestProcess");

        List<Deployment> list = deploymentQuery.list();

        logger.info(list.size()+"");
    }

    @Test
    public void deleteDeployment(){

        RepositoryService repositoryService = processEngine.getRepositoryService();

        DeploymentQuery deploymentQuery = repositoryService.createDeploymentQuery();
        deploymentQuery.processDefinitionKey("TaxpayerConfigurationRequestProcess");
        List<Deployment> list = deploymentQuery.list();

        for (Deployment deployment:list){
            logger.info("delete:{}",deployment.getId());
            repositoryService.deleteDeployment(deployment.getId(),true);
        }


    }

    @Test
    public void viewImage(){
        RepositoryService repositoryService = processEngine.getRepositoryService();

        DeploymentQuery deploymentQuery = repositoryService.createDeploymentQuery();
        deploymentQuery.processDefinitionKey("TaxpayerConfigurationRequestProcess");
        List<Deployment> list = deploymentQuery.list();
        Deployment deployment = list.get(0);

        List<String> deploymentResourceNames = repositoryService.getDeploymentResourceNames(deployment.getId());

        String imageName = null;
        for (String name : deploymentResourceNames) {
            if (name.indexOf(".png") > 0) {
                imageName = name;
            }
        }

        if(!StringUtils.isEmpty(imageName)){
            InputStream resourceAsStream = repositoryService.getResourceAsStream(deployment.getId(), imageName);
            File file = FileUtil.createFile("C:\\Users\\zy127\\Desktop\\temp\\" + imageName);
            FileUtil.copyInputStreamToFile(resourceAsStream,file);
        }
    }
}
