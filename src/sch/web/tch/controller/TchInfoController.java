package sch.web.tch.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sch.web.controller.RequestBean;
import sch.web.controller.ResponseBean;
import sch.web.tch.manager.TchInfoManager;

@Controller
@RequestMapping("/TchInfoControllerr.do")
@Scope("prototype")
public class TchInfoController extends TchController {
	
	@Autowired
	private TchInfoManager tchInfoManager;
	
	public void processMain(RequestBean requestBean, ResponseBean responseBean, HttpServletResponse response) throws Exception {		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tch_no", this.getUserNo());
		Map<String, Object> data = tchInfoManager.processMain(param);				
		responseBean.setData(data);
	}
}
