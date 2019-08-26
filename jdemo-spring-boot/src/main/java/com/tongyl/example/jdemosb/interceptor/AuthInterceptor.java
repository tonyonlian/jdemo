package com.tongyl.example.jdemosb.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 *
 * @author Created by Tunyl on 2019/8/1.
 * @version 1.0
 */
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       if(!(handler instanceof HandlerMethod)) {
           return true;
       }
       HandlerMethod method = (HandlerMethod) handler;

        log.info("method:{} , url:{}", request.getMethod(), request.getRequestURL().toString());


      return true;
    }
}
