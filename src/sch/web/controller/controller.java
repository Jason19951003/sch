package sch.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sch.web.dao.UserDao;

@Controller
public class controller {	
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private UserDao userDao;
	/**
	 * 方法中的參數對應到form表單中的name
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	@RequestMapping("/query2.do")
	public void query2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("進入成功");		
		List<Map<String, Object>> dataList = userDao.select();
		System.out.println(dataList);
		request.setAttribute("list", dataList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
