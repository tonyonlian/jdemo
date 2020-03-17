package com.tongyl.example.jdemosb.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import com.tongyl.example.jdemosb.TestAbstract;
import com.tongyl.example.jdemosb.entity.protoentity.user_info;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

/**
 * @author create by Tunyl on 2020/1/20
 * @version 1.0
 */
public class UserProtoControllerTest extends TestAbstract {
    @Autowired
    private RestTemplate restTemplate;
    @Test
    public void getUserInfo()  {
        //headers 请求头
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/x-protobuf");

        //body 请求body
        //  MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        //  requestBody.add("roundid", "1");
        // requestEntity ：请求体
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<MultiValueMap>(null, requestHeaders);
        ResponseEntity<user_info> res = restTemplate.postForEntity("https://localhost:8443/proto/user_info", requestEntity,user_info.class );
        user_info user = res.getBody();
        System.out.println(user.getName());

    }
}