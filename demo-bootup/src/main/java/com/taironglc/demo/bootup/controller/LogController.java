package com.taironglc.demo.bootup.controller;

import com.taironglc.demo.common.response.CommonResponse;
import com.taironglc.demo.dao.model.WhFinLog;
import com.taironglc.demo.common.exception.DemoBusinessException;
import com.taironglc.demo.service.LogService;
import com.taironglc.toolkit.security.utils.AESUtil;
import com.taironglc.toolkit.security.utils.Base64;
import com.taironglc.toolkit.security.utils.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @Autowired
    LogService logService;

    @Value("${demo.name}")
    private String demoName;

    @RequestMapping("/demoname")
    public CommonResponse<String> selectById() throws DemoBusinessException {
        CommonResponse<String> response = new CommonResponse<String>();
        response.setData(demoName);
        return response;
    }
    @RequestMapping("/log/{id}")
    public CommonResponse<WhFinLog> selectById(@PathVariable Long id) throws DemoBusinessException {
        CommonResponse<WhFinLog> response = new CommonResponse<WhFinLog>();
        WhFinLog log = logService.selectById(id);
        response.setData(log);
        return response;
    }
    @RequestMapping("/log2")
    public CommonResponse<WhFinLog> selectById2() throws Exception {
		/*KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(1024);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
		System.out.println(Base64.encode(rsaPublicKey.getEncoded()));
		System.out.println(Base64.encode(rsaPrivateKey.getEncoded()));*/
            String password = "MMTTMMTTMMTTMMTT";
            String channel ="100001";
            String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDTYqY5N+UxjCwjCa2sGhE3DPOphSxb1gFJBCyaFRV0/VmJHnJl5I1tg/I0moqL4Svth+JUCEAd7r1zbiNopJgScCp1OZFm4+saWXRz1toUJlOL9hWQgFne7pms4ZMUVgLQc6TTYK343UHYFOluE3U8a85wXhlS2rFMRDmzj9nyBQIDAQAB";
            String privateKey="MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANNipjk35TGMLCMJrawaETcM86mFLFvWAUkELJoVFXT9WYkecmXkjW2D8jSaiovhK+2H4lQIQB3uvXNuI2ikmBJwKnU5kWbj6xpZdHPW2hQmU4v2FZCAWd7umazhkxRWAtBzpNNgrfjdQdgU6W4TdTxrznBeGVLasUxEObOP2fIFAgMBAAECgYEAtwilW8gdacCw+wnHWs0beOp7FZ8doMt2Q24c3LJC6RDydTtq3PWAzIJCt+/U5Xfs3HkbrZ2TPxfY7VlBybszfLiAyEFIcR3gLcql5ZuBY7Nphye3f/MeLePFQRGEx2ejKHMHKg4Tamv0EdAV0BXGhDQX+McIKi5X4aPdm/oZ12UCQQDxxz12+GcgP5j33RjwM+77LWS9czB4R62cvZ5YbZ819Z27CgDwcV80Gtt4YQttYBO3Sy7DFWeGmj9h/TsuS5EjAkEA39G+nDVREI7yN6kZ59Jq7UtSx+CJg6NfrFBl7uhFkfnmCuMh68w7UwVxMMYwUGb5pBhxpnzYzrgX0x0F5C4mtwJBANaBDecfO19BDVXasuVpLf1qqJXsPHR6I22MTY/msfoNj4MBvROVggGYUl7aumivdM6JxVMPCmpBLzqgkIDiSkECQAZxxJo80sO2SfUeUlehcGC6vXxx06PNrXCJtBWn7HDikCQaHBzs+XxPeM3dtwBppqB577PKfnedR1pVyJikV4sCQQDnr2kf1yvVYCEha9NztwTV4dSTkBvlxgVo5YLTdimNDzVOztXWDzerI0abHJ4nSf1czdEoKFpAgGBPlnU6hsxK";
            String globalId="410782198707223546";
            String mobile="15121129884";
            String realName="黄伟可";
            //1、AES 对字段加密
            String encodeGlobalId = Base64.parseByte2HexStr(AESUtil.AESEncrypt(globalId,password));
            String encodeMobile = Base64.parseByte2HexStr(AESUtil.AESEncrypt(mobile,password));
            String encodeRealName = Base64.parseByte2HexStr(AESUtil.AESEncrypt(realName,password));
            StringBuilder sb = new StringBuilder();
            sb.append(encodeGlobalId).append(encodeMobile).append(encodeRealName);
            System.out.println("1、AES加密后数据:"+sb.toString());
            //2、私钥加签
            String sign = RSAUtil.sign(sb.toString().getBytes("utf-8"),privateKey);
            System.out.println("2、私钥加签后数据:"+sign);
            //3、公钥验签
            boolean flag = RSAUtil.verify(sb.toString().getBytes("utf-8"),publicKey,sign);
            System.out.println("3、公钥验签结果:"+flag);
            //4、验签通过解密数据
            if(flag){
                String decodeGlobalId = AESUtil.AESDecrypt(Base64.parseHexStr2Byte(encodeGlobalId),password);
                String decodeMobile = AESUtil.AESDecrypt(Base64.parseHexStr2Byte(encodeMobile),password);
                String decodeRealName = AESUtil.AESDecrypt(Base64.parseHexStr2Byte(encodeRealName),password);
                System.out.println("4、身份证："+decodeGlobalId+"手机："+decodeMobile+"姓名："+decodeRealName);
            }
        return null;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }
}
