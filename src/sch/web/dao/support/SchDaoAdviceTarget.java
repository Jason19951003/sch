package sch.web.dao.support;

import sch.web.dao.SchDao;

public interface SchDaoAdviceTarget {
	SchDao getDao();
	
	void setDao(SchDao schDao);
}
