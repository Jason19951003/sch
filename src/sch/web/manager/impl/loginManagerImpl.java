package sch.web.manager.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import sch.web.dao.UserDao;
import sch.web.manager.loginManager;

@Service
@Scope("prototype")
public class loginManagerImpl implements loginManager {
	@Autowired
	private UserDao userDao;	
	
	@Override
	public Map<String, Object> stuLogin(Map<String, Object> param) {		
		return userDao.stuLogin(param);
	}

	@Override
	public Map<String, Object> tchLogin(Map<String, Object> param) {		
		return userDao.tchLogin(param);
	}

}
