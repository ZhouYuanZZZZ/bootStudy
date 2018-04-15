package com.zy.study.bootstudy.config;

import com.zy.study.bootstudy.shrio.JdbcRealm;
import com.zy.study.bootstudy.shrio.SecondRealm;
import com.zy.study.bootstudy.shrio.SessionDao;
import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {


    @Bean
    public DefaultWebSecurityManager securityManager(ModularRealmAuthenticator authenticator,
                                                     JdbcRealm jdbcRealm,
                                                     SecondRealm secondRealm,
                                                     DefaultSessionManager sessionManager,
                                                     CookieRememberMeManager cookieRememberMeManager,
                                                     CacheManager redisCacheManager){

        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setAuthenticator(authenticator);
        //defaultWebSecurityManager.setSessionManager(sessionManager);
        defaultWebSecurityManager.setRememberMeManager(cookieRememberMeManager);
        defaultWebSecurityManager.setCacheManager(redisCacheManager);

        List<Realm> realms = new ArrayList<>();
        realms.add(jdbcRealm);
        realms.add(secondRealm);
        defaultWebSecurityManager.setRealms(realms);

        CookieRememberMeManager rememberMeManager = (CookieRememberMeManager)defaultWebSecurityManager.getRememberMeManager();
        Cookie cookie = rememberMeManager.getCookie();
        cookie.setMaxAge(10);

        return defaultWebSecurityManager;

    }

    @Bean
    public ModularRealmAuthenticator authenticator(){

        ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();

        AtLeastOneSuccessfulStrategy atLeastOneSuccessfulStrategy = new AtLeastOneSuccessfulStrategy();
        modularRealmAuthenticator.setAuthenticationStrategy(atLeastOneSuccessfulStrategy);

//        AllSuccessfulStrategy allSuccessfulStrategy = new AllSuccessfulStrategy();
//        modularRealmAuthenticator.setAuthenticationStrategy(allSuccessfulStrategy);

        return modularRealmAuthenticator;
    }

    //4. 配置 LifecycleBeanPostProcessor. 可以自定的来调用配置在 Spring IOC 容器中 shiro bean 的生命周期方法.
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){

        return new LifecycleBeanPostProcessor();
    }

    // 5. 启用 IOC 容器中使用 shiro 的注解. 但必须在配置了 LifecycleBeanPostProcessor 之后才可以使用.
    @DependsOn("lifecycleBeanPostProcessor")
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        return defaultAdvisorAutoProxyCreator;
    }

    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //    6. 配置 ShiroFilter.
    //     id 必须和 web.xml 文件中配置的 DelegatingFilterProxy 的 <filter-name> 一致.
    //      若不一致, 则会抛出: NoSuchBeanDefinitionException. 因为 Shiro 会来 IOC 容器中查找和 <filter-name> 名字对应的 filter bean.
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/loginPage");
        shiroFilterFactoryBean.setSuccessUrl("/list");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        Map<String,String> map = new HashMap<>();
        map.put("/loginPage", "anon");
        map.put("/login", "anon");
        map.put("/logout", "logout");
        map.put("/user", "roles[user]");
        map.put("/admin", "roles[admin]");
        map.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //配置sessionId生成器
    @Bean
    public JavaUuidSessionIdGenerator sessionIdGenerator(){
        return new JavaUuidSessionIdGenerator();
    }

    //sessionManager
    @Bean
    public DefaultSessionManager sessionManager(SessionDao sessionDao){

        DefaultSessionManager defaultSessionManager = new DefaultSessionManager();
        defaultSessionManager.setDeleteInvalidSessions(true);
        defaultSessionManager.setSessionDAO(sessionDao);
        defaultSessionManager.setGlobalSessionTimeout(180*1000);
        defaultSessionManager.setDeleteInvalidSessions(true);

        return defaultSessionManager;
    }

    @Bean
    public SimpleCookie rememberCookie(){

        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setMaxAge(3600*24);

        return simpleCookie;
    }

    @Bean
    public CookieRememberMeManager cookieRememberMeManager(SimpleCookie simpleCookie){

        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(simpleCookie);
        return cookieRememberMeManager;
    }



}
