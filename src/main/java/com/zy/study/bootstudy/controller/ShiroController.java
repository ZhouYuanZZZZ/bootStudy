package com.zy.study.bootstudy.controller;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShiroController {

    private static final Logger logger = LoggerFactory.getLogger(ShiroController.class);

    @ResponseBody
    @RequestMapping("/putDataIntoSession")
    public boolean putDataIntoSession(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("zy","081115");

        return true;
    }

    @ResponseBody
    @RequestMapping("/getSessionData")
    public boolean getSessionData(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();

        logger.info(session.getId().toString());
        logger.info(session.getHost());
        logger.info(session.getTimeout()+"");
        logger.info(session.getAttribute("zy")+"");
        logger.info("session:[{}]", JSON.toJSONString(session));

        return true;
    }

    @RequestMapping("/unauthorized")
    public String unauthorized() {

        return "shiro/unauthorized";
    }

    @RequestMapping("/user")
    public String user() {

        return "shiro/user";
    }

    @RequestMapping("/admin")
    public String admin() {

        return "shiro/admin";
    }

    @RequestMapping("/loginPage")
    public String loginPage() {

        return "loginPage";
    }

    @RequestMapping("/list")
    public String list() {

        return "list";
    }
}
