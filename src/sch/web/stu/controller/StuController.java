package sch.web.stu.controller;

import sch.web.controller.AbstractController;

public class StuController extends AbstractController {

	@Override
	public String getUserNo() {		
		return (String) this.getRequestBean().getSession().getAttribute("stu_no");
	}

	@Override
	public String getUserName() {		
		return (String) this.getRequestBean().getSession().getAttribute("stu_name");
	}

}
