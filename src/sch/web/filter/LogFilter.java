package sch.web.filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.web.context.support.XmlWebApplicationContext;

import sch.core.util.ApplicationContextUtil;
import sch.core.util.LogUtil;
import sch.core.util.support.ApEnv;

public class LogFilter implements Filter {

	@Override
	public void destroy() {		
		
	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain chain)
			throws IOException, ServletException {
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		try {
			String location = config.getInitParameter("location");
			DOMConfigurator.configure(location);
			LogUtil.info(LogFilter.class, "init Log4j success");
			String env = config.getInitParameter("env");
			//PropertyConfigurator.configure(location);
			ApEnv.load(new FileInputStream(env));
			LogUtil.info(LogFilter.class, "init ApEnv success");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			LogUtil.info(LogFilter.class, "找不到外部設定檔" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LogUtil.info(LogFilter.class, "讀取外部設定檔" + e.getMessage());
		}
	}

}
