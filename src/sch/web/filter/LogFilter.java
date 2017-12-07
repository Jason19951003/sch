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

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import sch.core.util.support.ApEnv;

public class LogFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain chain)
			throws IOException, ServletException {
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {		
		try {
			String location = config.getInitParameter("location");
			String env = config.getInitParameter("env");
			DOMConfigurator.configure(location);
			//PropertyConfigurator.configure(location);
			ApEnv.load(new FileInputStream(env));
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
