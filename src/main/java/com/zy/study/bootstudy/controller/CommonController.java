package com.zy.study.bootstudy.controller;



import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommonController {

    @RequestMapping(value = "jsStudy")
    public String jsStudy(HttpServletRequest request){
        RequestContext requestContext = new RequestContext(request);

        return "jsStudy";
    }

    @RequestMapping(value = "bootstrapTable")
    public String bootStrapTableStudy(){
        return "bootstrapTable";
    }

    @RequestMapping(value = "formSerialize")
    public String formSerialize(){
        return "formSerialize";
    }
}
