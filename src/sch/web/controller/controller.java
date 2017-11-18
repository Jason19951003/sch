package sch.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.web.dao.UserDao;
import sch.web.entity.User;

@Controller
public class controller {	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/query2.do")
	public void query2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		System.out.println(username);
		response.getWriter().print(username);
		/*List<Map<String, Object>> dataList = userDao.select();
		System.out.println(dataList);
		request.setAttribute("list", dataList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);*/
	}
	
	@RequestMapping("/query.do")
	public void query(User user) throws Exception {		
		System.out.println(user.getUsername());
		System.out.println(user.getRequset());
		/*List<Map<String, Object>> dataList = userDao.select();
		System.out.println(dataList);
		request.setAttribute("list", dataList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);*/
	}
}
