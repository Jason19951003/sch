package sch.web.tch.managerImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import sch.core.util.DateUtil;
import sch.web.dao.UserDao;
import sch.web.tch.manager.TchInfoManager;

@Service
@Scope("prototype")
public class TchInfoManagerImpl implements TchInfoManager {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Map<String, Object> processMain(Map<String, Object> param) {
		Map<String, Object> rtn = userDao.select_tch(param);		
		String date = DateUtil.CDtoMD(String.valueOf(rtn.get("tch_birthday")));
		rtn.put("tch_birthday", date.replace("-", "/"));
		return rtn;		
	}

}
