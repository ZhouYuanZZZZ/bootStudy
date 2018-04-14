package com.zy.study.bootstudy.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class WebConfig {


    @Bean
    public FilterRegistrationBean FilterRegistrationBean1() {
        DelegatingFilterProxy shiroFilter = new DelegatingFilterProxy();

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(shiroFilter);
        registration.addUrlPatterns("/*");
        registration.addInitParameter("targetFilterLifecycle", "true");
        registration.setName("shiroFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }

}
