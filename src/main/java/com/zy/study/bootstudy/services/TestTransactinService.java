package com.zy.study.bootstudy.services;

import com.zy.study.bootstudy.entity.City;
import com.zy.study.bootstudy.entity1.TbTaxpayer;
import com.zy.study.bootstudy.entity1.TbTaxpayerExample;
import com.zy.study.bootstudy.mapper.CityMapper;
import com.zy.study.bootstudy.mapper1.TbTaxpayerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestTransactinService implements ITestTransactinService {

    @Resource
    private CityMapper cityMapper;

    @Resource
    private TbTaxpayerMapper tbTaxpayerMapper;

    private static final Logger logger = LoggerFactory.getLogger(TestTransactinService.class);

    @Transactional
    public void test0(){
        City city = cityMapper.selectByPrimaryKey(1);
        city.setName("xxxx");
        cityMapper.updateByPrimaryKeySelective(city);

        TbTaxpayerExample tbTaxpayerExample = new TbTaxpayerExample();
        TbTaxpayerExample.Criteria criteria = tbTaxpayerExample.createCriteria();
        criteria.andTinEqualTo("300000000662");
        List<TbTaxpayer> tbTaxpayers = tbTaxpayerMapper.selectByExample(tbTaxpayerExample);

        TbTaxpayer tbTaxpayer = tbTaxpayers.get(0);
        tbTaxpayer.setNameInEnglish("xxxx");
        tbTaxpayerMapper.updateByPrimaryKeySelective(tbTaxpayer);

    }
}
