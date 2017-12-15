package com.taironglc.demo.common.exception;


import com.taironglc.toolkit.exception.BusinessException;
import com.taironglc.toolkit.exception.enums.ExceptionSeverityEnum;

public class DemoBusinessException extends BusinessException {
	private static final long serialVersionUID = 3382634379819296143L;

	public DemoBusinessException(String message) {
        super(message);
    }
    public DemoBusinessException(DemoBusinessExceptionCode code)
    {
        super(code.getCode(), code.getText());
    }

    public DemoBusinessException(String code, String text)
    {
        super(code, text);
    }
    
    public DemoBusinessException(String code, String message, ExceptionSeverityEnum severity, Throwable e){
    	super(code,message, severity, e);
    }
}
