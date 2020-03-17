package com.tongyl.example.jdemomysql;

import com.tongyl.example.jdemomysql.entity.User;
import com.tongyl.example.jdemomysql.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.tongyl.example.jdemomysql.mapper")
@SpringBootApplication
public class JdemoMysqlApplication implements ApplicationRunner {


  @Autowired
  private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(JdemoMysqlApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while(true) {
            User user = userMapper.getUser();
            System.out.println(user);
            Thread.sleep(3000);
        }
    }
}
