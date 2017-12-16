package sch.web.tch.managerImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import sch.core.dao.DBResultSetList;
import sch.core.dao.Query;
import sch.web.dao.ClassDao;
import sch.web.managerImpl.SchWebManager;
import sch.web.tch.manager.ClassInfoManager;

@Service
@Scope("prototype")
public class ClassInfoManagerImpl extends SchWebManager implements ClassInfoManager {
	@Autowired
	private ClassDao classDao;
	
	@Override
	public List<Map<String, Object>> processMain(Map<String, Object> param) throws Exception {		
		DBResultSetList dataList = this.getDao().queryForDBResultList(
				Query.creatQueryBySqlId("sch.web.dao.ClassDao.query", param));
		return (List<Map<String, Object>>) dataList.getDatalist();
	}

}
