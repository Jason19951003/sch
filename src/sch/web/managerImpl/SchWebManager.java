package sch.web.managerImpl;

import sch.web.dao.SchDao;
import sch.web.dao.support.SchDaoAdviceTarget;
import sch.web.manager.AbstractWebManager;

public class SchWebManager extends AbstractWebManager implements SchDaoAdviceTarget {
	
	private SchDao shcDao;
	
	@Override
	public SchDao getDao() {
		return this.shcDao;
	}

	@Override
	public void setDao(SchDao schDao) {
		this.shcDao = schDao;
	}
	
	protected void createDao(String dao) {
		
	}

}
