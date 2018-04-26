package com.zy.study.bootstudy;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiTest {

    @Resource
    private ProcessEngine processEngine;

    @Test
    public void test0(){
        RepositoryService repositoryService = processEngine.getRepositoryService();
        System.out.println(repositoryService);
    }
}
