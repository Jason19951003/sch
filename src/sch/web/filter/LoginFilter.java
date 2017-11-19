package sch.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain chain)
			throws IOException, ServletException {		
		HttpServletRequest request = (HttpServletRequest) servletrequest;
		HttpSession session = request.getSession();
		session.removeAttribute("stu_user");
		session.removeAttribute("tch_user");
		session.removeAttribute("ERROR");
		
		chain.doFilter(servletrequest, servletresponse);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

}
