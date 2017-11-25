package sch.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sch.web.controller.ResponseBean.ReturnType;
import sch.web.manager.loginManager;

@Controller
@Scope("prototype")
@RequestMapping("/login.do")
public class loginController extends AbstractController {
	@Autowired
	private loginManager loginManger;	
	
	public void stuLogin(RequestBean requestBean, ResponseBean responseBean) throws Exception {
		responseBean.setReturnType(ReturnType.SERVER_PAGE_FORWARD);
		Map<String, Object> paramMap = requestBean.getResultMap();
		HttpSession session = requestBean.getSession();
		
		
		Map<String, Object> rtn = loginManger.stuLogin(paramMap);
		
		if(rtn != null) {			
			session.setAttribute("stu_user", rtn.get("stu_no"));			
			responseBean.setReturnPage("/sch/global/index.jsp");
			
		} else {			
			requestBean.setAttribute("ERROR", "帳號密碼錯誤");
			responseBean.setReturnPage("/index.jsp");			
		}
	}	
	
	public void tchLogin(RequestBean requestBean, ResponseBean responseBean) throws Exception {
		responseBean.setReturnType(ReturnType.SERVER_PAGE_FORWARD);
		Map<String, Object> paramMap = requestBean.getResultMap();		
		HttpSession session = requestBean.getSession();		
		
		Map<String, Object> rtn = loginManger.tchLogin(paramMap);
		
		if(rtn != null) {
			session.setAttribute("tch_user", rtn.get("stu_no"));			
			responseBean.setReturnPage("/sch/global/index.jsp");
		} else {
			requestBean.setAttribute("ERROR", "帳號密碼錯誤");
			responseBean.setReturnPage("/index.jsp");
		}
	}
}
