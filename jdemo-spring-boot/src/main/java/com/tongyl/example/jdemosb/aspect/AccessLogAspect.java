package com.tongyl.example.jdemosb.aspect;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 访问日志的切面
 *
 * @author Created by Tunyl on 2019/7/30.
 * @version 1.0
 */

@Aspect
@Component
public class AccessLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(AccessLogAspect.class);
    ThreadLocal<Long> startTime = new ThreadLocal<>();
    ObjectMapper mapper = new ObjectMapper();

    @Pointcut("execution(public * com.tongyl.example.jdemosb.controller..*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //记录请求处理的开始时间
        startTime.set(System.currentTimeMillis());
        //接收到请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录下请求访问日志
        logger.info("{}, {},  IP:{}, REQUEST PARAM :{}", request.getMethod(), request.getRequestURL().toString(), request.getRemoteAddr(), JSON.toJSONString(request.getParameterMap()));

    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturning(Object result) {
        try {
            //返回的结果如果是protobuf，则不不能使用json解析
            logger.info("RESPONSE ({}ms) : {}", (System.currentTimeMillis() - startTime.get()), result);
       // } catch (JsonProcessingException e) {
        //    e.printStackTrace();
       //     logger.error("RESPONSE log error : {}",e.getMessage());
        }finally {
            startTime.remove();
        }
    }
}
