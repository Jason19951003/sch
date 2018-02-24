package sch.core.util;

import org.apache.log4j.Logger;

public class LogUtil {
	private static Logger logger;
	
	public static void debug(Class<? extends Object> clazz, Object message) {
		logger = Logger.getLogger(clazz);
		logger.debug(message);
	}
	
	public static void info(Class<? extends Object> clazz, Object message) {
		logger = Logger.getLogger(clazz);
		logger.info(message);
	}
	
	public static void warn(Class<? extends Object> clazz, Object message) {
		logger = Logger.getLogger(clazz);
		logger.warn(message);
	}
	
	public static void fatal(Class<? extends Object> clazz, Object message) {
		logger = Logger.getLogger(clazz);
		logger.fatal(message);
	}
	
	public static void error(Class<? extends Object> clazz, Object message) {
		logger = Logger.getLogger(clazz);
		logger.error(message);
	}
}
