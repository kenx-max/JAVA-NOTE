package cn.soboys.logback;


import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBack {
    private final static Logger logger = LoggerFactory.getLogger(LogBack.class);

    public static void main(String[] args) {
        logger.error("logback error测试");
        logger.warn("logback warn 测试");
        logger.info("logback info测试");
        logger.debug("logback debug测试");
        logger.trace("logback trace测试");
    }

}

class logBack1 {
    private final static Logger logger = LoggerFactory.getLogger(LogBack.class);

    public static void main(String[] args) {
        // 打印内部的状态
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }
}

