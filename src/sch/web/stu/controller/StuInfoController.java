package sch.web.stu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sch.core.util.DateUtil;
import sch.web.controller.RequestBean;
import sch.web.controller.ResponseBean;
import sch.web.manager.StuInfoManager;

@Controller
@RequestMapping("/StuInfoController.do")
@Scope("prototype")
public class StuInfoController extends StuController {
	
	@Autowired
	private StuInfoManager stuInfoManager;
	
	public void processMain(RequestBean requestBean, ResponseBean responseBean) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("stu_no", this.getUserNo());
		Map<String, Object> data = stuInfoManager.processMain(param);
		String date = DateUtil.CDtoMD(String.valueOf(data.get("stu_birthday")));
		data.put("stu_birthday", date.replace("-", "/"));		
		responseBean.setData(data);		
	}
}
