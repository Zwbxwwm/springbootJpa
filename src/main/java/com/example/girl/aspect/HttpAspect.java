package com.example.girl.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.girl.controller..*.*(..))")
    public void log(){
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //获取Url
        logger.info("url={}",request.getRequestURI());

        //获取method
        logger.info("method={}",request.getMethod());

        //获取ip
        logger.info("ip={}",request.getRemoteAddr());

        //获取请求的类和方法
        logger.info("class_name={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //获取请求的参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("请求结束");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturn(Object object){
//        logger.info("response={}",object.toString());
    }
}
