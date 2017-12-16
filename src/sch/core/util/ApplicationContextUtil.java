package sch.core.util;

import org.springframework.context.ApplicationContext;

public class ApplicationContextUtil {
	private static ApplicationContext applicationContext;
	
	private ApplicationContextUtil() {

	}
	public static void init(ApplicationContext applicationContext) {
		ApplicationContextUtil.applicationContext = applicationContext;
	}
	
	public static ApplicationContext getInstance() {
		if(applicationContext == null) {
			throw new RuntimeException("applicationContext not init");
		}
		return applicationContext;
	}
	
	public static void close() {
		applicationContext = null;
	}	
}
