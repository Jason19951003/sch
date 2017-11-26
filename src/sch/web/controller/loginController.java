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

import sch.web.manager.loginManager;

@Controller
@Scope("prototype")
@RequestMapping("/login")
public class loginController {
	@Autowired
	private loginManager loginManger;
	
	@RequestMapping("/stuLogin.do")
	public void stuLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();		
		HttpSession session = request.getSession();		
		
		String stu_no = request.getParameter("stu_no");
		String stu_password = request.getParameter("stu_password");
		
		paramMap.put("stu_no", stu_no);
		paramMap.put("stu_password", stu_password);
		Map<String, Object> rtn = loginManger.stuLogin(paramMap);
		
		if(rtn != null) {			
			session.setAttribute("stu_no", rtn.get("stu_no"));
			session.setAttribute("stu_name", rtn.get("stu_name"));
			request.getRequestDispatcher("/sch/global/index.jsp").forward(request, response);
		} else {
			request.setAttribute("ERROR", "帳號密碼錯誤");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
	
	@RequestMapping("/tchLogin.do")
	public void tchLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();		
		HttpSession session = request.getSession();		
		
		String tch_no = request.getParameter("tch_no");
		String tch_password = request.getParameter("tch_password");
		
		paramMap.put("tch_no", tch_no);
		paramMap.put("tch_password", tch_password);
		Map<String, Object> rtn = loginManger.tchLogin(paramMap);
		
		if(rtn != null) {
			session.setAttribute("tch_no", rtn.get("tch_no"));
			session.setAttribute("tch_name", rtn.get("tch_name"));
		} else {
			request.setAttribute("ERROR", "帳號密碼錯誤");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
}
