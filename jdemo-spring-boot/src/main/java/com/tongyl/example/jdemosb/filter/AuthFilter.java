package com.tongyl.example.jdemosb.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *
 * 过滤器的demo
 * @author Created by Tunyl on 2019/8/1.
 * @version 1.0
 */

@Slf4j
@Component
@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String ipAddress = request.getRemoteAddr();
        log.info("Ip {}, Time {}", ipAddress, System.currentTimeMillis());
        log.info("enter into authFilter...");
        filterChain.doFilter(request,response);
        log.info("enter out authFilter ...");

    }

    @Override
    public void destroy() {

    }
}
