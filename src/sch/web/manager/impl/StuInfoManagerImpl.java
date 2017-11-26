package sch.web.manager.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import sch.web.dao.UserDao;
import sch.web.manager.StuInfoManager;

@Service
@Scope("prototype")
public class StuInfoManagerImpl implements StuInfoManager {
	
	@Autowired
	private UserDao userDao;
	@Override
	public Map<String, Object> processMain(Map<String, Object> param) {		
		return userDao.select_stu(param);
	}

}
