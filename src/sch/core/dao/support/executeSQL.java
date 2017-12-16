package sch.core.dao.support;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import sch.core.dao.DBResultSetList;
import sch.core.dao.Query;

@Component
@Scope("prototype")
public class executeSQL {
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	private ApplicationContext applicationContext;

	private DefaultTransactionDefinition def;
	
	private TransactionStatus status;
	
	private SqlSessionFactory sqlSessionFactory;
	
	public executeSQL() {
		System.out.println(this.applicationContext);
		System.out.println(transactionManager);		
	}
	
	public static executeSQL createExecuteSQL(ApplicationContext applicationContext) {
		executeSQL execute = new executeSQL();
		execute.setApplicationContext(applicationContext);
		return execute;
	}
	
	public DBResultSetList queryForDBResultSetList(Query q) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();;
		try {			 
			List<Map<String, Object>> data = session.selectList(q.getSqlId(), q.getParamMap());
			return DBResultSetList.createDBResultSetList(data);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		} finally {
			session.close();
		}
	}

	/**
	 * @return the applicationContext
	 */
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * @param applicationContext the applicationContext to set
	 */	
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	/**
	 * @return the transactionManager
	 */
	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	/**
	 * @param transactionManager the transactionManager to set
	 */
	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	/**
	 * @return the def
	 */
	public DefaultTransactionDefinition getDef() {
		return def;
	}

	/**
	 * @param def the def to set
	 */
	public void setDef(DefaultTransactionDefinition def) {
		this.def = def;
	}

	/**
	 * @return the status
	 */
	public TransactionStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	/**
	 * @return the sqlSessionFactory
	 */
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	/**
	 * @param sqlSessionFactory the sqlSessionFactory to set
	 */
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
}
