package com.hsd.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2018/10/29
 */
public class LogTest {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.info("hello world");
    }
}
