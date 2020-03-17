package com.tongyl.jdemo.stormtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author create by Tunyl on 2020/1/7
 * @version 1.0
 */
public class DTest {
    private static final Logger log = LoggerFactory.getLogger(DTest.class);

    public static void main(String[] args) {
        System.out.println(123);
        System.err.println(1233344);
        log.debug("ddddebug");
        log.warn("dddwarn");
        log.info("这是一个测试");
        log.error("dddd");
    }
}
