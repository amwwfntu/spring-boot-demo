package com.taironglc.demo.bootup;


import com.taironglc.demo.dao.model.WhFinLog;
import com.taironglc.demo.dao.config.MyBatisConfig;
import com.taironglc.demo.dao.mapper.WhFinLogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyBatisConfig.class})
public class TestMapper {

    @Autowired
    WhFinLogMapper whFinLogMapper;

    @Test
    public void testSelectById(){
        WhFinLog log = whFinLogMapper.selectById(77604993569644544L);
        System.out.println(log.getRequestContent());
    }
    @Test
    @Transactional
    public void testSave(){
            WhFinLog log = new WhFinLog();
            log.setId(234234l);
            whFinLogMapper.save(log);
            //throw new RuntimeException();


    }

    @Test
    public void testDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR,3);
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.YEAR));
    }

    @Test
    public void testMath(){
        BigDecimal a = new BigDecimal("1234.56");
        System.out.println(a.multiply(new BigDecimal("100")).intValue());

    }
}
