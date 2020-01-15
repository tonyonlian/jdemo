package com.tongyl.example.jdemomysql.mapper;

import com.tongyl.example.jdemomysql.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * @author create by Tunyl on 2019/12/13
 * @version 1.0
 */
@Service
public interface UserMapper {
    @Select("select id,email from lt_user where email ='540340102@qq.com'")
    public User getUser();
}
