package com.hsd.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2018/10/29
 */
public class TestLog4j {
    public   static   void  main(String[] args)  {
        PropertyConfigurator.configure( "D:\\workspace\\hsd-demo\\src\\main\\resources\\log4j.properties" );
        Logger logger  =  Logger.getLogger(TestLog4j. class );
        logger.info("this is info message");
        logger.debug("this is debug message");
        logger.warn("this is warn message");
        logger.error("this is error message");
    }
}
