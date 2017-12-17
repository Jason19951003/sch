package sch.core.dao.support;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class SchTransactionManager {
	private static Logger log = Logger.getLogger(SchTransactionManager.class);
	
	private DataSourceTransactionManager txManager;

	private DefaultTransactionDefinition def;
	
	private TransactionStatus status;
	
	public static SchTransactionManager createTransactionManager(DataSource ds, int propagationBehavior) {
		SchTransactionManager tx = new SchTransactionManager(ds, propagationBehavior);
		log.info(" ### create SchTransactionManager(" + tx.hashCode() + ") ... , ds=[" + ds + "], propagationBehavior=[" + propagationBehavior + "] ### ");
		return tx;
	}
	
	public static SchTransactionManager createTransactionManager(DataSource ds, int propagationBehavior, int timeout) {
		SchTransactionManager tx = new SchTransactionManager(ds, propagationBehavior, timeout);
		log.info(" ### create SchTransactionManager(" + tx.hashCode() + ") ... , ds=[" + ds + "], propagationBehavior=[" + propagationBehavior + "] ### ");
		return tx;
	}
	
	private SchTransactionManager(DataSource ds, int propagationBehavior) {
		txManager = new DataSourceTransactionManager(ds);
		def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(propagationBehavior);
		status = txManager.getTransaction(def);
	}
	
	private SchTransactionManager(DataSource ds, int propagationBehavior, int timeout) {
		txManager = new DataSourceTransactionManager(ds);
		def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(propagationBehavior);
		def.setTimeout(timeout);
		status = txManager.getTransaction(def);
	}
	
	public void commit() {
		txManager.commit(status);
	}
	
	public void rollBack() {
		txManager.rollback(status);
	}
	
	public void release() {
		if (!status.isCompleted())
			txManager.rollback(status);
	}
	
	/**
	 * @param definition
	 * @return
	 */
	public TransactionStatus getTransaction(DefaultTransactionDefinition definition) {
		status = txManager.getTransaction(definition);
		return status;
	}
	/**
	 * @return the txManager
	 */
	public DataSourceTransactionManager getTxManager() {
		return txManager;
	}

	/**
	 * @param txManager the txManager to set
	 */
	public void setTxManager(DataSourceTransactionManager txManager) {
		this.txManager = txManager;
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
}
