package sch.web.stu.managerImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import sch.core.util.DateUtil;
import sch.web.dao.UserDao;
import sch.web.dao.impl.SchDaoImpl;
import sch.web.stu.manager.StuInfoManager;

@Service
@Scope("prototype")
public class StuInfoManagerImpl extends SchDaoImpl implements StuInfoManager  {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Map<String, Object> processMain(Map<String, Object> param) {
		Map<String, Object> rtn = userDao.select_stu(param);
		String date = DateUtil.CDtoMD(String.valueOf(rtn.get("stu_birthday")));
		rtn.put("stu_birthday", date.replace("-", "/"));		
		return rtn;
	}

}
