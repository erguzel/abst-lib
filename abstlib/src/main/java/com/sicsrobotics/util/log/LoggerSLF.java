package com.sicsrobotics.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Log SLF4J provider for generic classes
 * @param <T> Any class for log is to be used
 */
public class LoggerSLF<T> {
   private Logger _logger;

    public LoggerSLF(Class<?> clazz) {
        _logger = LoggerFactory.getLogger(clazz);
    }

    public void info(String msg){
        _logger.info(msg);
    }
    public void error(String msg){
        _logger.error(msg);
    }
    public void error(String msg, Throwable exc){_logger.error(msg,exc);}
    public void warning(String msg){
        _logger.warn(msg);
    }
    public void debug(String msg){
        _logger.debug(msg);
    }

}
