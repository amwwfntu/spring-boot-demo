package com.taironglc.demo.bootup;


import com.taironglc.demo.dao.model.WhFinLog;
import com.taironglc.demo.dao.config.MyBatisConfig;
import com.taironglc.demo.dao.mapper.WhFinLogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyBatisConfig.class})
public class TestMapper {

    @Autowired
    WhFinLogMapper whFinLogMapper;

    @Test
    public void testSelectById(){
        WhFinLog log = whFinLogMapper.selectById(52948729086599168L);
        System.out.println(log.getRequestContent());
    }
}
