package cn.soboys.kenx.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBack {
    private final static Logger logger = LoggerFactory.getLogger(LogBack.class);

    public static void main(String[] args) {
        logger.error("logback error测试");
        logger.info("logback info测试");
        logger.debug("logback debug测试");
    }
}
