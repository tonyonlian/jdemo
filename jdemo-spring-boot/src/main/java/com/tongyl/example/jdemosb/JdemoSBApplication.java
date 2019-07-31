package com.tongyl.example.jdemosb;

import com.tongyl.example.jdemosb.runner.StartupRunner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Created by Tunyl on 2019/7/26.
 * @version 1.0
 */

@SpringBootApplication
// 此注解表示动态扫描DAO接口所在包，实际上不加下面这条语句也可以找到
@MapperScan("com.tongyl.example.jdemosb.dao")
public class JdemoSBApplication {
    public static void main(String[] args) {
        SpringApplication.run(JdemoSBApplication.class, args);
    }

    /**
     * 启动后执行代码StartupRunner的run方法
     * @return
     */
    @Bean
    public StartupRunner schedulerRunner() {
        return new StartupRunner();
    }
}
