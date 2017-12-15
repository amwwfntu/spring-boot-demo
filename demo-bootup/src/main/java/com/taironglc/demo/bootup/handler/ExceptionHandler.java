package com.taironglc.demo.bootup.handler;

import com.taironglc.demo.common.exception.DemoBusinessException;
import com.taironglc.demo.common.response.CommonResponse;
import com.taironglc.demo.common.exception.DemoBusinessExceptionCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResponse handle(Exception e){
        CommonResponse response = new CommonResponse();
        if(e instanceof DemoBusinessException){
            response.setCode(((DemoBusinessException) e).getCode());
            response.setMsg(e.getMessage());
        }else{
            response.setCode(DemoBusinessExceptionCode.SYSTEM_ERROR.getCode());
            response.setMsg(DemoBusinessExceptionCode.SYSTEM_ERROR.getText());
        }
        return response;
    }
}
