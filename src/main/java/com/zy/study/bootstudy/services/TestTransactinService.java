package com.zy.study.bootstudy.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestTransactinService implements ITestTransactinService {
    @Override
    public void test0() {

    }

//    @Resource
//    private CityMapper cityMapper;
//
//
//
//    private static final Logger logger = LoggerFactory.getLogger(TestTransactinService.class);
//
//    @Transactional
//    public void test0(){
//        City city = cityMapper.selectByPrimaryKey(1);
//        city.setName("xxxx");
//        cityMapper.updateByPrimaryKeySelective(city);
//
//
//
//    }
}
