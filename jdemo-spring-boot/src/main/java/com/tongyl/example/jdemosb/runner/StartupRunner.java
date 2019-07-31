package com.tongyl.example.jdemosb.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

/**
 * @author Created by Tunyl on 2019/7/30.
 * @version 1.0
 */
public class StartupRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(StartupRunner.class);
    @Override
    public void run(String... args) throws Exception {
        logger.info("hello world");
    }
}
