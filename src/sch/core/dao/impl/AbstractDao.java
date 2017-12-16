package sch.core.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import sch.core.dao.BaseDao;
import sch.core.dao.DBResultSet;
import sch.core.dao.DBResultSetList;
import sch.core.dao.Query;
import sch.core.dao.support.GenerateResult;
import sch.core.dao.support.MybatisSqlGenerate;
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
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	@Override
	public Map<?, ?> queryForMap(Query q) throws Exception {
		DBResultSetList result = queryForDBResultList(q);
		return result.getFirstByMap();
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
