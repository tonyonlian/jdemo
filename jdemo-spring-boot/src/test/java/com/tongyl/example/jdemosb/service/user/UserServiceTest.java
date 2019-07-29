package com.tongyl.example.jdemosb.service.user;

import com.tongyl.example.jdemosb.TestAbstract;
import com.tongyl.example.jdemosb.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 服务层方法的测试示例
 *
 * @author Created by Tunyl on 2019/7/26.
 * @version 1.0
 */
public class UserServiceTest extends TestAbstract {


    @Autowired
    private UserService userService;


    //普通方法的测试示例
    @Test
    public void list() {
        List<User> list = userService.list();
        Assert.assertEquals(1, list.size());
    }


}