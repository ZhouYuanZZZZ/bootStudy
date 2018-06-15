package com.zy.study.bootstudy;


import com.alibaba.fastjson.JSON;
import com.zy.study.bootstudy.entity1.TbDevice;
import com.zy.study.bootstudy.entity1.TbInvoiceTaxpayerInfo;
import com.zy.study.bootstudy.mapper1.TbDeviceMapper;
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

    @Resource
    private TbDeviceMapper deviceMapper;

//
//    @Test
//    public void test0(){
//        List<TbInvoice> tbInvoices = tbInvoiceMapper.selectAll();
//
//        TbInvoice tbInvoice = new TbInvoice();
//        tbInvoice.setInvoiceUid(new BigDecimal(569));
//
//    }
//
//    @Test
//    public void test1(){
//        RowBounds rowBounds = new RowBounds(10, 100);
//        List<TbInvoice> tbInvoices = tbInvoiceMapper.selectByRowBounds(null, rowBounds);
//        logger.info(tbInvoices.size()+"");
//    }
//
//    @Test
//    public void test2(){
//        Example example = new Example(TbInvoice.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("sellerTin","300000000740");
//
//        List<TbInvoice> tbInvoices = tbInvoiceMapper.selectByExample(example);
//        for(TbInvoice invoice:tbInvoices){
//            logger.info(JSON.toJSONString(invoice));
//        }
//    }

    @Test
    public void test3(){
        List<TbInvoiceTaxpayerInfo> tbInvoiceTaxpayerInfos = tbInvoiceMapper.queryInvoiceWithTaxpayerInfo();

        for(TbInvoiceTaxpayerInfo tbInvoiceTaxpayerInfo:tbInvoiceTaxpayerInfos){
            logger.info(JSON.toJSONString(tbInvoiceTaxpayerInfo));
        }

    }

    @Test
    public void test4(){
        List<TbInvoiceTaxpayerInfo> tbInvoiceTaxpayerInfos = tbInvoiceMapper.queryInvoiceWithTaxpayerInfo1();

        for(TbInvoiceTaxpayerInfo tbInvoiceTaxpayerInfo:tbInvoiceTaxpayerInfos){
            logger.info(JSON.toJSONString(tbInvoiceTaxpayerInfo));
        }
    }

    @Test
    public void test5(){
        long start1 = System.currentTimeMillis();
        List<TbInvoiceTaxpayerInfo> tbInvoiceTaxpayerInfos = tbInvoiceMapper.queryInvoiceWithTaxpayerInfo();
        long end1 = System.currentTimeMillis();
        logger.info((end1-start1)+"");

        long start2 = System.currentTimeMillis();
        List<TbInvoiceTaxpayerInfo> tbInvoiceTaxpayerInfos1 = tbInvoiceMapper.queryInvoiceWithTaxpayerInfo1();
        long end2 = System.currentTimeMillis();
        logger.info((end2-start2)+"");
    }

    @Test
    public void test6(){
        List<TbDevice> tbDevices = deviceMapper.queryDeviceWithInvoice();
        for(TbDevice device:tbDevices){
            if(device.getInvoices() != null){
                logger.info("SN:{} --- Count:{}",device.getSerialNo(),device.getInvoices().size());
            }
        }
    }

    @Test
    public void test7(){
        List<TbDevice> tbDevices = deviceMapper.queryDeviceWithInvoice1();
        for(TbDevice device:tbDevices){
            if(device.getInvoices() != null){
                logger.info("SN:{} --- Count:{}",device.getSerialNo(),device.getInvoices().size());
            }
        }
    }
}
