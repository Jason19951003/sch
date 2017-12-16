package sch.web.dao.impl;

import java.sql.Connection;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import sch.core.dao.impl.AbstractDao;
import sch.web.dao.SchDao;

@Component
@Scope("prototype")
public class SchDaoImpl extends AbstractDao implements SchDao {

	@Override
	public Connection getConnection() {
		return DataSourceUtils.getConnection(this.getDataSource());
	}
}
