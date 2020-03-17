package com.tunyl.feign;

import feign.Param;
import feign.RequestLine;

/**
 * @author create by Tunyl on 2020/1/20
 * @version 1.0
 */
public interface User {
    @RequestLine("GET /user/query/{name}")
    String getUserInfo(@Param("name")String name);

}
