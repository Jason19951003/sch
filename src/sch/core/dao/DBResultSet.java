package sch.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBResultSet {
	private ResultSet rs 		   = null;
	private PreparedStatement ps   = null;
	private Connection con         = null;	
	private int totalCount;
	private boolean dbtemp = true;

	public DBResultSet()  {
		
	}
	
	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public void close() throws SQLException {
		if(con != null) 
			con.close();
		if(ps != null)
			ps.close();
		if(rs != null)
			rs.close();
	}
	
	public int getTotalCount() throws SQLException {
		if(dbtemp) {
			rs.beforeFirst();
		}
		rs.last();
		totalCount = rs.getRow();
		dbtemp = false;
		return totalCount;
	}
	
	public int getColumnCount() throws SQLException {
		return rs.getMetaData().getColumnCount();
	}
	
	public String getColumnName(int column) throws SQLException {
		return rs.getMetaData().getColumnName(column);
	}
	
	public boolean next() throws SQLException {
		if(dbtemp){
			return rs.next();
		}else {
			dbtemp = true;
			rs.beforeFirst();
			return rs.next();
		}				
	}
	
	public void beforeFirst() throws SQLException {		
		rs.beforeFirst();
	}
	
	public Object getArray(String param) throws SQLException {
		return rs.getArray(param);		
	}
	
	public Object getArray(int columnIndex) throws SQLException {
		return rs.getArray(columnIndex);		
	}
	
	public Object getBoolean(String param) throws SQLException {
		return rs.getArray(param);		
	}
	
	public Object getBoolean(int columnIndex) throws SQLException {
		return rs.getArray(columnIndex);		
	}
	
	public Object getBlob(String param) throws SQLException {
		return rs.getArray(param);		
	}
	
	public Object getBlob(int columnIndex) throws SQLException {
		return rs.getArray(columnIndex);		
	}
	
	public Object getClob(String param) throws SQLException {
		return rs.getArray(param);		
	}
	
	public Object getClob(int columnIndex) throws SQLException {
		return rs.getArray(columnIndex);		
	}
	
	public Object getDate(String param) throws SQLException {
		return rs.getArray(param);		
	}
	
	public Object getDate(int columnIndex) throws SQLException {
		return rs.getArray(columnIndex);		
	}
	
	public Object getDouble(String param) throws SQLException {
		return rs.getArray(param);		
	}
	
	public Object getDouble(int columnIndex) throws SQLException {
		return rs.getArray(columnIndex);		
	}
	
	public Object getFloat(String param) throws SQLException {
		return rs.getArray(param);		
	}
	
	public Object getFloat(int columnIndex) throws SQLException {
		return rs.getArray(columnIndex);		
	}
	
	public Object getInt(String param) throws SQLException {
		return rs.getArray(param);		
	}
	
	public Object getInt(int columnIndex) throws SQLException {
		return rs.getArray(columnIndex);		
	}
	
	public Object getLong(String param) throws SQLException {
		return rs.getArray(param);		
	}
	
	public Object getLong(int columnIndex) throws SQLException {
		return rs.getArray(columnIndex);		
	}
	
	public Object getObject(int columnIndex) throws SQLException {
		return rs.getObject(columnIndex);		
	}
	
	public Object getObject(String param) throws SQLException {
		return rs.getObject(param);		
	}
	
	public String getString(int columnIndex) throws SQLException {
		return rs.getString(columnIndex);		
	}
	
	public String getString(String param) throws SQLException {		
		return rs.getString(param);
	}
}
