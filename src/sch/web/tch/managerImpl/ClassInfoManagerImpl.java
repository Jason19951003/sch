package sch.web.tch.managerImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import sch.web.dao.ClassDao;
import sch.web.tch.manager.ClassInfoManager;

@Service
@Scope("prototype")
public class ClassInfoManagerImpl implements ClassInfoManager {
	@Autowired
	private ClassDao classDao;

	@Override
	public List<Map<String, Object>> processMain(Map<String, Object> param) {
		List<Map<String, Object>> dataList = classDao.query(param);		
		return dataList;
	}

}
