package com.tongyl.example.jdemo;

import com.tongyl.example.jdemo.entity.User;
import com.tongyl.example.jdemo.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@MapperScan("com.tongyl.example.jdemo.mapper")
@SpringBootApplication
public class JdemoApplication implements ApplicationRunner {
    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(JdemoApplication.class, args);

       Map<String,String> data =new HashMap<>();
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        while(true) {
            User user = userMapper.getUser();
            System.out.println(user);
            Thread.sleep(3000);
        }
    }
}
