package sch.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.support.XmlWebApplicationContext;

import sch.core.util.ApplicationContextUtil;
import sch.core.util.LogUtil;

public class ContextFilter implements Filter {

	@Override
	public void destroy() {		
		
	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain chain)
			throws IOException, ServletException {
		try {
			//讀取ApplicationContext
			XmlWebApplicationContext ctx = new XmlWebApplicationContext();
			ctx.setConfigLocation("/WEB-INF/conf/web-context.xml");
			ctx.setServletContext(servletrequest.getServletContext());
			ctx.refresh();
			ApplicationContextUtil.init(ctx);
			LogUtil.info(ContextFilter.class, "init ApplicationContext success");
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.info(ContextFilter.class, "init ApplicationContext error:" + e.getMessage());
		}		
		chain.doFilter(servletrequest, servletresponse);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}
}
