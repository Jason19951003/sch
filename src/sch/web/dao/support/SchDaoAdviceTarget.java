package sch.web.dao.support;

import sch.core.dao.support.SchTransactionManager;
import sch.web.dao.SchDao;

public interface SchDaoAdviceTarget {
	SchDao getDao();
	
	void setDao(SchDao schDao);
	
	SchTransactionManager getSchTransactionManager();
	
	void setSchTransactionManager(SchTransactionManager schTransactionManager);
}
