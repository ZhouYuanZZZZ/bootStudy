package com.zy.study.bootstudy.shrio;

import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("sessionDao")
public class SessionDao extends EnterpriseCacheSessionDAO {

    @Resource
    private JavaUuidSessionIdGenerator sessionIdGenerator;

    public SessionDao(){
        super();
        this.setSessionIdGenerator(sessionIdGenerator);
    }
}
