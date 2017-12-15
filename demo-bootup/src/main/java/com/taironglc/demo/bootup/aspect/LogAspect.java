package com.taironglc.demo.bootup.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

   @Around("execution(* com.taironglc.demo.bootup.controller..*.*(..))")
   public Object around(ProceedingJoinPoint joinPoint){
       Object response = null;
       Object[] args = joinPoint.getArgs();
       Class clazz = joinPoint.getSignature().getDeclaringType();
       String method = joinPoint.getSignature().toLongString();
       try {
           logger.info("请求类:{}--方法:{}--入参:{}",clazz.getSimpleName(),method,args);
           if(args==null || args.length==0){
               response = joinPoint.proceed();
           }else{
               response = joinPoint.proceed(args);
           }
           logger.info("请求类:{}--方法:{}--响应:{}",clazz.getSimpleName(),method,response);
       } catch (Throwable e) {
           throw new RuntimeException(e);
       }
       return response;
   }
}
