package com.zhousui.aspect;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2017/5/28.
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
   /* @Before("execution(public * com.zhousui.controller.GirlController.*(..))")
    public void log()
    {
        System.out.println("before log");
    }

    @After("execution(public * com.zhousui.controller.GirlController.*(..))")
    public void doAfter()
    {
        System.out.println("222");
    }*/

    @Pointcut("execution(public * com.zhousui.controller.GirlController.*(..))")
    public void log()
    {
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint)
    {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("agrs={}",joinPoint.getArgs());
        // System.out.println("111");

        logger.info("11111");
    }
    @After("log()")
    public void doAfter()
    {
       // System.out.println("222");
        logger.error("2222");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object)
    {
        logger.info("return object={}",object);
    }
}
