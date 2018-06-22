package com.zy.study.testSpring.bean;

import com.alibaba.fastjson.JSON;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public class TestService0{

    @Resource
    private TestBean0 bean0;

    public void init(){
        System.out.println("init method");
        System.out.println(JSON.toJSONString(bean0));
    }


    @PostConstruct
    public void afterPropertiesSet111() throws Exception {
        System.out.println("afterPropertiesSet111");
        System.out.println(JSON.toJSONString(bean0));
    }
}


