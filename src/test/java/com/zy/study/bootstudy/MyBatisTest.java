package com.zy.study.bootstudy;


import com.alibaba.fastjson.JSON;
import com.zy.study.bootstudy.entity1.TbInvoice;
import com.zy.study.bootstudy.mapper1.TbInvoiceMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {

    private static final Logger logger = LoggerFactory.getLogger(MyBatisTest.class);

    @Resource
    private TbInvoiceMapper tbInvoiceMapper;

    @Test
    public void test0(){
        List<TbInvoice> tbInvoices = tbInvoiceMapper.selectAll();

        TbInvoice tbInvoice = new TbInvoice();
        tbInvoice.setInvoiceUid(new BigDecimal(569));

    }
    
    @Test
    public void test1(){
        RowBounds rowBounds = new RowBounds(10, 100);
        List<TbInvoice> tbInvoices = tbInvoiceMapper.selectByRowBounds(null, rowBounds);
        logger.info(tbInvoices.size()+"");
    }

    @Test
    public void test2(){
        Example example = new Example(TbInvoice.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sellerTin","300000000740");

        List<TbInvoice> tbInvoices = tbInvoiceMapper.selectByExample(example);
        for(TbInvoice invoice:tbInvoices){
            logger.info(JSON.toJSONString(invoice));
        }
    }
}
