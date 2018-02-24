package sch.web.tch.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sch.web.controller.RequestBean;
import sch.web.controller.ResponseBean;
import sch.web.controllerImpl.TchController;
import sch.web.tch.manager.ClassInfoManager;

@Controller
@RequestMapping("/ClassInfoController.do")
@Scope("prototype")
@SuppressWarnings("all")
public class ClassInfoController extends TchController {	
	@Autowired
	private ClassInfoManager ClassInfoManager;	
	
	public void processMain(RequestBean requestBean, ResponseBean responseBean, HttpServletResponse response) throws Exception {		
		Map<String, Object> param = requestBean.getResultMap();		
		List<Map<String, Object>> data = ClassInfoManager.processMain(param);
		responseBean.setData(data);
	}
}
