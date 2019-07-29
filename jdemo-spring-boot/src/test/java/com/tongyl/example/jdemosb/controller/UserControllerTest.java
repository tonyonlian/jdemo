package com.tongyl.example.jdemosb.controller;

import com.tongyl.example.jdemosb.TestAbstract;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 测试controller的方法（restfulapi的测试)
 *
 * @author Created by Tunyl on 2019/7/29.
 * @version 1.0
 */
public class UserControllerTest extends TestAbstract {
    /**
     * 测试接口，需要准备testRestTempl
     */
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;
    private URL base;

    /**
     * 资源初始化
     *
     * @throws MalformedURLException
     */
    @Before
    public void initSrc() throws MalformedURLException {
        String url = String.format("http://localhost:%d", port);
        System.out.println(String.format("port:[%d]", port));
        base = new URL(url);

    }

    //restful Api的测试示例
    @Test
    public void list() {
        ResponseEntity<String> res = restTemplate.getForEntity(base.toString() + "/user/list", String.class, "");
        System.out.println(String.format("测试结果为: %s", res.getBody()));
    }

    @After
    public void closeSrc() {
    }
}