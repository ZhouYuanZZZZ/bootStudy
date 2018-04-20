package com.zy.study.bootstudy.services;

import com.zy.study.bootstudy.entity.City;
import com.zy.study.bootstudy.mapper.CityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@Service
public class CityService {

    private static final Logger logger = LoggerFactory.getLogger(CityService.class);

    @Resource
    private PlatformTransactionManager transactionManager;

    @Resource
    private CityMapper cityMapper;


    public void modifyCity(){
        //设置属性的默认属性
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        //设置事务的传播行为，此处是设置为开启一个新事物
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        //设置事务的隔离级别，此处是读已经提交
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        //获取事务状态对象
        TransactionStatus transactionStatus = (TransactionStatus) transactionManager.getTransaction(definition);
       try {
           City city = new City();
           city.setId(1);
           city.setPopulation(6);
           cityMapper.updateByPrimaryKeySelective(city);
           transactionManager.commit(transactionStatus);
       }catch (Exception e){
           logger.error(e.toString());
           transactionManager.rollback(transactionStatus);
       }
    }
}
