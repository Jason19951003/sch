package sch.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.PropertyConfigurator;

public class LogFilter implements Filter{

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
		String location = config.getInitParameter("location");
		PropertyConfigurator.configure(location);
	}

}
