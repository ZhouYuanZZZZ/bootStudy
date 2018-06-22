package com.zy.study.testSpring.bean;

import org.springframework.stereotype.Component;

@Component
public class TestBean0 {

    public TestBean0(){
        System.out.println("TestBean0 constructor");
        name = "zzzz";
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
