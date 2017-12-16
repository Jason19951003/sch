package sch.web.dao;

import java.sql.Connection;
import sch.core.dao.BaseDao;

public interface SchDao extends BaseDao {
	/**
	 * 
	 * @return
	 */
	Connection getConnection();
}
