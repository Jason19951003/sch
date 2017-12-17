package sch.web.managerImpl;

import sch.core.dao.impl.DaoFactory;
import sch.core.dao.support.SchTransactionManager;
import sch.web.dao.SchDao;
import sch.web.dao.support.SchDaoAdviceTarget;
import sch.web.manager.AbstractWebManager;

public class SchWebManager extends AbstractWebManager implements SchDaoAdviceTarget {
	
	private SchDao shcDao;
	
	private SchTransactionManager tx;
	
	@Override
	public SchDao getDao() {
		return this.shcDao;
	}

	@Override
	public void setDao(SchDao schDao) {
		this.shcDao = schDao;
	}
	
	protected SchDao createDao(String dsType) throws Exception {
		SchDao dao = DaoFactory.getDaoFactory().createDao(dsType);
		return dao;
	}

	@Override
	public SchTransactionManager getSchTransactionManager() {		
		return tx;
	}

	@Override
	public void setSchTransactionManager(SchTransactionManager schTransactionManager) {
		this.tx = schTransactionManager;		
	}

}
