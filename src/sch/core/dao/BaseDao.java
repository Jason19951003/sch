package sch.core.dao;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.transaction.TransactionDefinition;

public interface BaseDao {	
	/** 指出不應在交易中進行，如果有的話就丟出例外 */
	public static final int PROPAGATION_NEVER = TransactionDefinition.PROPAGATION_NEVER;	
	/** 支援現在的交易，如果沒有的話就建立一個新的交易 */
	public static final int PROPAGATION_REQUIRED = TransactionDefinition.PROPAGATION_REQUIRED;	
	/** 預設交易 TIMEOUT 時間 300 秒 */
	public static int DEFAULT_TRANSACTION_TIMEOUT = 300; 
	/**
	 * 
	 * @return
	 */
	public DataSource getDataSource();
	/**
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource);
	
	/**
	 * 
	 * @param q
	 * @return
	 */
	public DBResultSet queryForDBResult(Query q) ;
	/**
	 * 
	 * @param q
	 * @return
	 */
	public DBResultSetList queryForDBResultList(Query q) throws Exception;
	/**
	 * 
	 * @param q
	 * @return
	 */
	public Map<?, ?> queryForMap(Query q) throws Exception ;
}
