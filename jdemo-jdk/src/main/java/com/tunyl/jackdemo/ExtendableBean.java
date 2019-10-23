package com.tunyl.jackdemo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author create by Tunyl on 2019/10/14
 * @version 1.0
 */
public class ExtendableBean {
    private String name;
    private Map<String,String> properties;

    @JsonAnyGetter
    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
    public static void main(String[] args) throws JsonProcessingException {
        ExtendableBean bean = new ExtendableBean();
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }
}
