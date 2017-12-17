package sch.core.dao.impl;

import java.util.Hashtable;
import java.util.Map;

import sch.core.util.ApplicationContextUtil;
import sch.web.dao.SchDao;

public class DaoFactory {
	private Map<String, SchDao> daoCacheMap = new Hashtable<String, SchDao>();
	
	/**
	 * @param daoMap
	 */
	public void setDaoCacheMap(Map<String, SchDao> daoMap) {
		daoCacheMap = daoMap;
	}
	
	/**
	 * @return
	 */
	public static DaoFactory getDaoFactory() {
		return (DaoFactory)ApplicationContextUtil.getInstance().getBean("daoFactory");
	}
	
	public SchDao createDao(String dsType) throws Exception {
		SchDao schDao = daoCacheMap.get(dsType);
		if(schDao != null) {
			return schDao;
		} else {
			throw new Exception(" ### dao not found, dsType[" + dsType + "] ###");
		}
	}
	
	
}
