package com.taironglc.demo.common.response;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class CommonResponse<T> implements Serializable {
    private String code = "000000";
    private String msg = "成功";
    private String timeStamp = System.currentTimeMillis() + "";
    private T data;

    public CommonResponse() {
        this.code = "000000";
        this.msg = "成功";
    }

    public CommonResponse(String respCode, String respMsg)
    {
        this.code = respCode;
        this.msg = respMsg;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString()
    {
        return "CommonResponse [data=" + JSON.toJSONString(this.data) + "code=" + this.code + ", msg=" + this.msg +"]";
    }
}
