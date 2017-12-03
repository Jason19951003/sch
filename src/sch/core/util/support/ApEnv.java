package sch.core.util.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApEnv {
	private static Properties prop = new Properties();
	
	public static void load(InputStream input) throws IOException {
		prop.load(input);
	}
		
	public static String get(String key) {
		return prop.getProperty(key);
	}
}
