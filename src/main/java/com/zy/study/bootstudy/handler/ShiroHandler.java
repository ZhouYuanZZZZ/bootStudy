package com.zy.study.bootstudy.handler;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShiroHandler {

    private static final Logger logger = LoggerFactory.getLogger(ShiroHandler.class);

    @RequestMapping("login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password){

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // rememberme
            token.setRememberMe(true);
            try {
                logger.info("before login");
                // 执行登录.
                currentUser.login(token);
                logger.info("after login");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            // 所有认证时异常的父类.
            catch (AuthenticationException ae) {
               logger.warn("AuthenticationException",ae);
            }
        }

        return "redirect:/list";
    }
}
