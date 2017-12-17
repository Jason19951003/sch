package sch.core.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionDefinition;

import sch.core.dao.BaseDao;
import sch.core.dao.DBResultSet;
import sch.core.dao.DBResultSetList;
import sch.core.dao.Query;
import sch.core.dao.support.GenerateResult;
import sch.core.dao.support.SchTransactionManager;
import sch.core.dao.support.SqlGenerate;

public class AbstractDao implements BaseDao {
	@Autowired
	private ApplicationContext applicationContext;
	/*資料庫來源*/
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SqlGenerate sqlgenerate;
	
	@Override
	public SchTransactionManager beginTransaction() throws Exception {
		return beginTransaction(TransactionDefinition.PROPAGATION_NEVER);
	}
	
	@Override
	public SchTransactionManager beginTransaction(int propagationBehavior) throws Exception {
		return SchTransactionManager.createTransactionManager(dataSource, propagationBehavior);
	}
	
	@Override
	public SchTransactionManager beginTransaction(int propagationBehavior, int timeout) throws Exception {	
		return SchTransactionManager.createTransactionManager(dataSource, propagationBehavior, timeout);	
	}
	
	@Override
	public DBResultSet queryForDBResult(Query q) {
		DBResultSet result = null;		
		return result;
	}
	
	@Override
	public DBResultSetList queryForDBResultList(Query q) throws Exception {
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);		
			
			GenerateResult generateResult = sqlgenerate.generate(q.getSqlId(), q.getParamMap());
			
			List<Map<String, Object>> dataList = jdbcTemplate.queryForList(generateResult.getSql(), generateResult.getParams());
			
			return DBResultSetList.createDBResultSetList(dataList);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Override
	public Map<?, ?> queryForMap(Query q) throws Exception {
		DBResultSetList result = queryForDBResultList(q);
		return result.getFirstByMap();
	}
	
	@Override
	public int insert(Query q) throws Exception {
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);		
			
			GenerateResult generateResult = sqlgenerate.generate(q.getSqlId(), q.getParamMap());
			
			return jdbcTemplate.update(generateResult.getSql(), generateResult.getParams());
		} catch (Exception e) {
			throw new Exception(e);
		}
	}	


	@Override
	public int update(Query q) throws Exception {
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);		
			
			GenerateResult generateResult = sqlgenerate.generate(q.getSqlId(), q.getParamMap());
			
			return jdbcTemplate.update(generateResult.getSql(), generateResult.getParams());
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public int delete(Query q) throws Exception {
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);		
			
			GenerateResult generateResult = sqlgenerate.generate(q.getSqlId(), q.getParamMap());
			
			return jdbcTemplate.update(generateResult.getSql(), generateResult.getParams());
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public ApplicationContext getApplicationContext() {
		return this.applicationContext;
	}
	
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		
	}
	@Override
	public DataSource getDataSource() {
		return this.dataSource;
	}
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
