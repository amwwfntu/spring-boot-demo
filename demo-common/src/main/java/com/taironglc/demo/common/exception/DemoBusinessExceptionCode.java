package com.taironglc.demo.common.exception;

import org.apache.commons.lang3.StringUtils;

public enum DemoBusinessExceptionCode {

    RPC_ERROR("-999998", " 远程调用异常"),
    SYSTEM_ERROR("-999999", " 系统异常");

    private static final String EMPTY = "";
    private String code;
    private String text;

    private DemoBusinessExceptionCode(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public static String getText(String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (DemoBusinessExceptionCode em : values()) {
            if (em.code.equals(code)) {
                return em.text;
            }
        }
        return "";
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
