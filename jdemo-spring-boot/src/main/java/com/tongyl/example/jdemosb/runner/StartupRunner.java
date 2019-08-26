package com.tongyl.example.jdemosb.runner;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

/**
 * @author Created by Tunyl on 2019/7/30.
 * @version 1.0
 */
@Slf4j
public class StartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("hello world");
    }
}
