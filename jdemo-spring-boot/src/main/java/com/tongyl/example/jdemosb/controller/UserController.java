package com.tongyl.example.jdemosb.controller;

import com.tongyl.example.jdemosb.entity.Result;
import com.tongyl.example.jdemosb.entity.User;
import com.tongyl.example.jdemosb.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Created by Tunyl on 2019/7/26.
 * @version 1.0
 */
@RestController
@RequestMapping("/user/*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("list")
    public Result list(){
        List<User> list = userService.list();
        return Result.ok().setData(list);
    }

}
