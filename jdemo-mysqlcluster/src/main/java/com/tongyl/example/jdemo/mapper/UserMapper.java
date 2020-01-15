package com.tongyl.example.jdemo.mapper;

import com.tongyl.example.jdemo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * @author create by Tunyl on 2019/12/24
 * @version 1.0
 */

@Service
public interface UserMapper {
    @Select("select id,email from lt_user where email ='admin@mail.com'")
    public User getUser();
}
