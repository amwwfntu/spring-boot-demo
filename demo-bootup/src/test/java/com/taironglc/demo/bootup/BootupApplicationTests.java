package com.taironglc.demo.bootup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootupApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
		System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
	}

	@Test
	public void testJson(){
		String json ="{\"code\": \"000000\",\"data\": \"{\\\"yesterdayIncome\\\":\\\"0\\\",\\\"balance\\\":\\\"30000.00\\\",\\\"totaBalance\\\":\\\"30000.00\\\",\\\"totalYield\\\":\\\"0\\\"}\",\"msg\": \"成功\",\"timeStamp\": \"1514260340037\" }";
//		JSONObject abc = JSON.parseObject(json);
//		String data = abc.getString("data");
//		AccountBalance ab = JSON.parseObject(data,AccountBalance.class);
//		System.out.println(ab);
		TestJson tj = JSON.parseObject(json,TestJson.class);
		System.out.println(tj);
	}

}
