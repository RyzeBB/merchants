package com.imooc.passbook.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {

    @Autowired
    private IMerchantsServ merchantsServ;
    @Test
    @Transactional
    public void testCreateMerchantServ(){
        CreateMerchantsRequest createMerchantsRequest = new CreateMerchantsRequest();
        createMerchantsRequest.setName("慕课Imooc-2");
        createMerchantsRequest.setLogoUrl("www.imooc.com");
        createMerchantsRequest.setBusinessLicenseUrl("www.imooc.com");
        createMerchantsRequest.setAddress("北京");
        createMerchantsRequest.setPhone("111111");
        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(createMerchantsRequest)));
    }

    @Test
    public void testDropPassTemplate(){
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(2);
        passTemplate.setTitle("title:慕课");
        passTemplate.setSummary("简介：慕课");
        passTemplate.setDesc("详情：慕课");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(true);
        passTemplate.setBackground(2);
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(),10));
        System.out.println(JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate)));
        System.out.println();
    }
}
