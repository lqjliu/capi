package com.caru.db;

import java.sql.*;
import java.util.*;
import java.math.*;
import java.lang.reflect.*;
import java.lang.ref.*;
import java.lang.reflect.*;
import sun.jdbc.odbc.JdbcOdbcDriver;
import java.util.*;
import java.lang.Object;
import java.net.URL;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author unascribed
 * @version 1.0
 */

public class DBAgent {
	private static ConnectionPool connectionPool = new ConnectionPool();

	private Connection connection = null;

	/**
	 * gain connection from connectionpool
	 */
	public Connection getConnection() throws SQLException {
		return this.connectionPool.getConnection();
	}

	/**
	 * commit the Transaction with connection
	 */

	public void commitTransaction() throws Exception {
		if (!this.isInTransaction) {
			throw new Exception("Transaction is not begin");
		}
		this.connection.commit();
		this.isInTransaction = false;
		this.connection.setAutoCommit(true);
		this.connection.close();
	}

	/**
	 * rollback the Transaction with connection
	 */
	public void rollbackTransaction() throws Exception {
		if (!this.isInTransaction) {
			throw new Exception("Transaction is not begin");
		}
		this.connection.rollback();
		this.isInTransaction = false;
		this.connection.setAutoCommit(true);
		this.connection.close();
	}

	/**
	 * overload the finalize of object to close the connection to db
	 * 
	 * @throws Throwable
	 */
	public void finalize() throws Throwable {
		if (this.connection != null) {
			this.connection.close();
			this.connection = null;
		}
	}

	/**
	 * insert Object to corresponding table
	 * 
	 * @param o
	 * @throws SQLException
	 * @throws Exception
	 */
	public void insert(Object o) throws SQLException, Exception {
		Class c = o.getClass();
		Method[] m = c.getMethods();

		Vector data = new Vector();
		String insertColumn = "";
		String insertValue = "";
		for (int i = 0; i < m.length; i++) {
			String methodName = m[i].getName();
			if (methodName.indexOf("get") == 0
					&& !methodName.equals("getClass")) {
				String isHasMethod = methodName.replaceFirst("get", "isHas");
				Boolean b = (Boolean) c.getMethod(isHasMethod, null).invoke(o,
						null);
				if (b.booleanValue()) {
					Object value = m[i].invoke(o, null);
					data.addElement(value);
					String columnName = methodName.replaceFirst("get", "");
					insertColumn += (columnName + ",");
					insertValue += "?,";
				}
			}
		}
		String sql = null;
		if (insertColumn.length() > 0) {
			insertColumn = insertColumn.substring(0, insertColumn.length() - 1);
			insertValue = insertValue.substring(0, insertValue.length() - 1);
			String tableName = c.getField("TABLE_NAME").get(o).toString();
			sql = "insert into " + tableName + "(" + insertColumn + ")values("
					+ insertValue + ")";
		}

		// System.out.println("sql = " + sql);
		// insert data to DB
		Connection con = null;
		PreparedStatement ps = null;
		try {
			if (sql != null) {
				// if (this.isInTransaction) {
				// System.out.println("In Transaction");
				con = this.connection;
				// }
				// else {
				// System.out.println("Not In Transaction");
				// con = this.getConnection();
				// }
				// System.out.println("exec sql = " + sql);
				ps = con.prepareStatement(sql);

				for (int i = 0; i < data.size(); i++) {
					Object value = data.elementAt(i);
					if (value instanceof java.util.Date) {
						value = new java.sql.Timestamp(((java.util.Date) value)
								.getTime());
					}
					ps.setObject(i + 1, value);
				}
				ps.executeUpdate();
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
			// if (!this.isInTransaction && con != null) {
			// con.close();
			// }
		}
	}

	/**
	 * delete Object of corresponding table
	 * 
	 * @param o
	 * @throws SQLException
	 * @throws Exception
	 */

	public void delete(Object o) throws SQLException, Exception {
		Class c = o.getClass();
		Method[] m = c.getMethods();
		// Generate sql
		Vector whereData = new Vector();
		String whereColumn = "";
		for (int i = 0; i < m.length; i++) {
			String methodName = m[i].getName();
			if (methodName.indexOf("get") == 0
					&& !methodName.equals("getClass")) {
				String isHasMethod = methodName.replaceFirst("get", "isHas");
				Boolean b = (Boolean) c.getMethod(isHasMethod, null).invoke(o,
						null);
				if (b.booleanValue()) {
					Object value = m[i].invoke(o, null);
					String columnName = methodName.replaceFirst("get", "");
					whereData.addElement(value);
					whereColumn += (" " + columnName + "=? and");
				}
			}
		}
		String sql = null;
		if (whereColumn.length() > 0) {
			whereColumn = whereColumn.substring(0, whereColumn.length() - 3);
			String tableName = c.getField("TABLE_NAME").get(o).toString();
			sql = "delete from " + tableName + " where " + whereColumn;
		}
		// delete data from DB
		Connection con = null;
		PreparedStatement ps = null;
		try {
			if (sql != null) {
				// if (this.isInTransaction) {
				con = this.connection;
				// }
				// else {
				// con = this.getConnection();
				// }
				//System.out.println("exec sql = " + sql);
				ps = con.prepareStatement(sql);
				for (int i = 0; i < whereData.size(); i++) {
					Object value = whereData.elementAt(i);
					if (value instanceof java.util.Date) {
						value = new java.sql.Timestamp(((java.util.Date) value)
								.getTime());
					}
					ps.setObject(i + 1, value);

				}
				ps.executeUpdate();
			}
		}

		finally {
			if (ps != null) {
				ps.close();
			}
			// if (!this.isInTransaction && con != null) {
			// con.close();
			// }
		}

	}

	/**
	 * update Object of corresponding table
	 * 
	 * @param o
	 * @throws SQLException
	 * @throws Exception
	 */

	public void update(Object o) throws SQLException, Exception {
		Class c = o.getClass();
		Method[] m = c.getMethods();
		// Generate sql
		Vector updateData = new Vector();
		Vector whereData = new Vector();
		String updateColumn = "";
		String whereColumn = "";
		for (int i = 0; i < m.length; i++) {
			String methodName = m[i].getName();
			if (methodName.indexOf("get") == 0
					&& !methodName.equals("getClass")) {
				String isHasMethod = methodName.replaceFirst("get", "isHas");
				Boolean b = (Boolean) c.getMethod(isHasMethod, null).invoke(o,
						null);
				if (b.booleanValue()) {
					Object value = m[i].invoke(o, null);
					String columnName = methodName.replaceFirst("get", "");
					String isWhere = methodName.replaceFirst("get", "isWhere");
					Boolean isWhereFlag = (Boolean) c.getMethod(isWhere, null)
							.invoke(o, null);

					if (!isWhereFlag.booleanValue()) {
						updateData.addElement(value);
						updateColumn += (columnName + "=?,");
					} else {
						whereData.addElement(value);
						whereColumn += (" " + columnName + "=? and");
					}
				}
			}
		}
		String sql = null;
		if (updateColumn.length() > 0) {
			updateColumn = updateColumn.substring(0, updateColumn.length() - 1);
			if (whereColumn.length() > 0) {
				whereColumn = whereColumn
						.substring(0, whereColumn.length() - 3);
			}
			String tableName = c.getField("TABLE_NAME").get(o).toString();
			sql = "update " + tableName + " set " + updateColumn;
			if (whereColumn.length() > 0) {
				sql += (" where " + whereColumn);
			}
		}
		//System.out.println("sql = " + sql);
		// update data from DB
		Connection con = null;
		PreparedStatement ps = null;
		try {
			if (sql != null) {
				// if (this.isInTransaction) {
				con = this.connection;
				// }
				// else {
				// con = this.getConnection();
				// }
				ps = con.prepareStatement(sql);
				//System.out.println("exec sql = " + sql);
				for (int i = 0; i < updateData.size(); i++) {
					Object value = updateData.elementAt(i);
					if (value instanceof java.util.Date) {
						value = new java.sql.Timestamp(((java.util.Date) value)
								.getTime());
					}
					ps.setObject(i + 1, value);
				}

				int pos = updateData.size();
				for (int i = 0; i < whereData.size(); i++) {
					Object value = whereData.elementAt(i);
					if (value instanceof java.util.Date) {
						value = new java.sql.Timestamp(((java.util.Date) value)
								.getTime());
					}
					ps.setObject(pos + i + 1, value);

				}
				ps.executeUpdate();
			}
		}

		finally {
			if (ps != null) {
				ps.close();
			}
			// if (!this.isInTransaction && con != null) {
			// con.close();
			// }
		}

	}

	public void update(Object o,String additionWhere) throws SQLException, Exception {
		Class c = o.getClass();
		Method[] m = c.getMethods();
		// Generate sql
		Vector updateData = new Vector();
		Vector whereData = new Vector();
		String updateColumn = "";
		String whereColumn = "";
		for (int i = 0; i < m.length; i++) {
			String methodName = m[i].getName();
			if (methodName.indexOf("get") == 0
					&& !methodName.equals("getClass")) {
				String isHasMethod = methodName.replaceFirst("get", "isHas");
				Boolean b = (Boolean) c.getMethod(isHasMethod, null).invoke(o,
						null);
				if (b.booleanValue()) {
					Object value = m[i].invoke(o, null);
					String columnName = methodName.replaceFirst("get", "");
					String isWhere = methodName.replaceFirst("get", "isWhere");
					Boolean isWhereFlag = (Boolean) c.getMethod(isWhere, null)
							.invoke(o, null);

					if (!isWhereFlag.booleanValue()) {
						updateData.addElement(value);
						updateColumn += (columnName + "=?,");
					} else {
						whereData.addElement(value);
						whereColumn += (" " + columnName + "=? and");
					}
				}
			}
		}
		String sql = null;
		if (updateColumn.length() > 0) {
			updateColumn = updateColumn.substring(0, updateColumn.length() - 1);
			if (whereColumn.length() > 0) {
				whereColumn = whereColumn
						.substring(0, whereColumn.length() - 3);
				whereColumn += (" and " + additionWhere);
			}
			
			String tableName = c.getField("TABLE_NAME").get(o).toString();
			sql = "update " + tableName + " set " + updateColumn;
			if (whereColumn.length() > 0) {
				sql += (" where " + whereColumn);
			}
		}
		System.out.println("sql = " + sql);
		// update data from DB
		Connection con = null;
		PreparedStatement ps = null;
		try {
			if (sql != null) {
				// if (this.isInTransaction) {
			
				con = this.connection;
				// }
				// else {
				// con = this.getConnection();
				// }
				ps = con.prepareStatement(sql);
				//System.out.println("exec sql = " + sql);
				for (int i = 0; i < updateData.size(); i++) {
					Object value = updateData.elementAt(i);
					if (value instanceof java.util.Date) {
						value = new java.sql.Timestamp(((java.util.Date) value)
								.getTime());
					}
					ps.setObject(i + 1, value);
				}

				int pos = updateData.size();
				for (int i = 0; i < whereData.size(); i++) {
					Object value = whereData.elementAt(i);
					if (value instanceof java.util.Date) {
						value = new java.sql.Timestamp(((java.util.Date) value)
								.getTime());
					}
					ps.setObject(pos + i + 1, value);

				}
				ps.executeUpdate();
			}
		}

		finally {
			if (ps != null) {
				ps.close();
			}
			// if (!this.isInTransaction && con != null) {
			// con.close();
			// }
		}

	}	
	
	
	public Object select(Object o) throws SQLException, Exception {
		Class c = o.getClass();
		Method[] m = c.getMethods();
		// Generate sql
		Vector whereData = new Vector();
		String whereColumn = "";
		for (int i = 0; i < m.length; i++) {
			String methodName = m[i].getName();
			if (methodName.indexOf("get") == 0
					&& !methodName.equals("getClass")) {
				String isHasMethod = methodName.replaceFirst("get", "isHas");
				Boolean b = (Boolean) c.getMethod(isHasMethod, null).invoke(o,
						null);
				if (b.booleanValue()) {
					Object value = m[i].invoke(o, null);
					String columnName = methodName.replaceFirst("get", "");
					whereData.addElement(value);
					whereColumn += (" " + columnName + "=? and");
				}
			}
		}
		String sql = null;
		if (whereColumn.length() > 0) {
			whereColumn = whereColumn.substring(0, whereColumn.length() - 3);
			String tableName = c.getField("TABLE_NAME").get(o).toString();
			sql = "select * from " + tableName + " where " + whereColumn;
		}
		// update data from DB
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			if (sql != null) {
				if (this.isInTransaction) {
					con = this.connection;
				} else {
					con = this.getConnection();
				}
				//System.out.println("exec sql = " + sql);
				ps = con.prepareStatement(sql);
				for (int i = 0; i < whereData.size(); i++) {
					Object value = whereData.elementAt(i);
					if (value instanceof java.util.Date) {
						value = new java.sql.Timestamp(((java.util.Date) value)
								.getTime());
					}
					ps.setObject(i + 1, value);

				}
				rs = ps.executeQuery();
				int columnCount = rs.getMetaData().getColumnCount();
				if (rs.next()) {
					for (int i = 0; i < columnCount; i++) {
						String columnName = rs.getMetaData().getColumnName(
								i + 1).toUpperCase();
						String setMethod = "set" + columnName.substring(0, 1)
								+ columnName.substring(1).toLowerCase();
						Object value = rs.getObject(i + 1);
						String getMethod = setMethod.replaceFirst("set", "get");
						Class columnType = c.getMethod(getMethod, null)
								.getReturnType();
						if (columnType.getName().equals("long")) {
							if (value != null) {
								value = new Long(Long.parseLong(value
										.toString()));
							}
						} else if (columnType.getName().equals(
								"java.lang.String")) {
							if (value != null) {
								value = value.toString();
							}
						} else if (columnType.getName()
								.equals("java.util.Date")) {
							if (value != null) {
								value = (java.util.Date) value;
							}
						} else if (columnType.getName().equals("int")) {
							if (value != null) {
								value = Integer.valueOf(value.toString());
							}
						} else if (columnType.getName().equals("double")) {
							if (value != null) {
								value = Double.valueOf(value.toString());
							}
						} else if (columnType.getName().equals("float")) {
							if (value != null) {
								value = Float.valueOf(value.toString());
							}
						}

						Class[] agrType = new Class[1];
						agrType[0] = columnType;
						Object[] agrO = new Object[1];
						agrO[0] = value;
						if (value != null) {
							c.getMethod(setMethod, agrType).invoke(o, agrO);
						}
					}
				} else {
					return null;
				}
			} else {
				return null;
			}
		}

		finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			// if (!this.isInTransaction && con != null) {
			// con.close();
			// }
		}

		return o;
	}

	public Object select(Object o,String sql) throws SQLException, Exception {
		Class c = o.getClass();
		Method[] m = c.getMethods();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			if (sql != null) {
				if (this.isInTransaction) {
					con = this.connection;
				} else {
					con = this.getConnection();
				}
				//System.out.println("exec sql = " + sql);
				ps = con.prepareStatement(sql);

				rs = ps.executeQuery();
				int columnCount = rs.getMetaData().getColumnCount();
				if (rs.next()) {
					for (int i = 0; i < columnCount; i++) {
						String columnName = rs.getMetaData().getColumnName(
								i + 1).toUpperCase();
						String setMethod = "set" + columnName.substring(0, 1)
								+ columnName.substring(1).toLowerCase();
						Object value = rs.getObject(i + 1);
						String getMethod = setMethod.replaceFirst("set", "get");
						Class columnType = c.getMethod(getMethod, null)
								.getReturnType();
						if (columnType.getName().equals("long")) {
							if (value != null) {
								value = new Long(Long.parseLong(value
										.toString()));
							}
						} else if (columnType.getName().equals(
								"java.lang.String")) {
							if (value != null) {
								value = value.toString();
							}
						} else if (columnType.getName()
								.equals("java.util.Date")) {
							if (value != null) {
								value = (java.util.Date) value;
							}
						} else if (columnType.getName().equals("int")) {
							if (value != null) {
								value = Integer.valueOf(value.toString());
							}
						} else if (columnType.getName().equals("double")) {
							if (value != null) {
								value = Double.valueOf(value.toString());
							}
						} else if (columnType.getName().equals("float")) {
							if (value != null) {
								value = Float.valueOf(value.toString());
							}
						}

						Class[] agrType = new Class[1];
						agrType[0] = columnType;
						Object[] agrO = new Object[1];
						agrO[0] = value;
						if (value != null) {
							c.getMethod(setMethod, agrType).invoke(o, agrO);
						}
					}
				} else {
					return null;
				}
			} else {
				return null;
			}
		}

		finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			// if (!this.isInTransaction && con != null) {
			// con.close();
			// }
		}

		return o;
	}
	
	
	
	private boolean isInTransaction = false;

	public void beginTransaction() throws Exception {
		this.connection = this.connectionPool.getConnection();
		this.isInTransaction = true;
		this.connection.setAutoCommit(false);
	}

	public static void main(String[] agrs) {

	}

	/***************************************************************************
	 * The following method is used by DBParser /** execute databse query with
	 * no resultset return
	 **************************************************************************/
	public void executeQuery(String sql) throws Exception {
		Connection dbConnection = this.getConnection();
		Statement stmt = dbConnection.createStatement();
		stmt.executeQuery(sql);
		stmt.close();
	}

	public void executeQuery(Vector sql) throws Exception {
		Connection dbConnection = this.getConnection();
		dbConnection.setAutoCommit(false);
		try {
			Statement stmt = dbConnection.createStatement();
			for (int i = 0; i < sql.size(); i++) {
				stmt.executeQuery(sql.elementAt(i).toString());
			}
			dbConnection.commit();
			stmt.close();
		} catch (SQLException ex) {
			dbConnection.rollback();
			throw ex;

		}
	}

	/**
	 * 
	 * @param sql
	 * @return single value of string
	 * @throws Exception
	 */
	public String selectSingleValue(String sql) throws Exception {
		Connection dbConnection = this.getConnection();
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String value = null;
		if (rs.next()) {
			value = rs.getString(1);
		}
		return value;
	}

	/**
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public Vector selectSingleRecord(String sql) throws Exception {
		Connection dbConnection = this.getConnection();
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columncount = rsmd.getColumnCount();
		Vector vdata = new Vector();
		if (rs.next()) {
			for (int i = 0; i < columncount; i++) {
				vdata.addElement(rs.getObject(i + 1));
			}
		}
		return vdata;
	}

	/**
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public Vector selectMultiRecord(String sql) throws Exception {
		Connection dbConnection = this.getConnection();
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columncount = rsmd.getColumnCount();
		Vector data = new Vector();
		while (rs.next()) {
			Vector temp = new Vector();
			for (int i = 0; i < columncount; i++) {
				temp.addElement(rs.getObject(i + 1));
			}
			data.addElement(temp);
		}
		return data;
	}

	/**
	 * 
	 * @param table
	 * @param swhere
	 * @return record count is 1
	 */
	public Hashtable getDataWithNo(String table, String swhere)
			throws Exception {
		Connection dbConnection = this.getConnection();
		Hashtable bdData = new Hashtable();
		String sql = "select * from " + table + " " + swhere;
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		String[] columnName = new String[columnCount];
		String[] columnType = new String[columnCount];

		for (int i = 0; i < columnCount; i++) {
			columnName[i] = rsmd.getColumnName(i + 1).toLowerCase();
			columnType[i] = rsmd.getColumnTypeName(i + 1).toLowerCase();
		}

		if (rs.next()) {
			for (int i = 0; i < columnCount; i++) {
				if (columnType[i].equals("date")) {
					java.util.Date date = rs.getDate((i + 1));
					if (date != null) {
						bdData.put(columnName[i], rs.getDate((i + 1)));
					}
				} else {
					String stemp = rs.getString((i + 1));
					stemp = stemp == null ? "" : stemp;
					// stemp = stemp.equals("0") ? "":stemp;
					bdData.put(columnName[i], stemp);
				}
			}
		}
		rs.close();
		stmt.close();
		return bdData;
	}

	/**
	 * 
	 * @param table
	 * @param swhere
	 * @return record count is > 1
	 */
	public Vector getData(String table) throws Exception {
		return this.getData(table, null);
	}

	/**
	 * 
	 * @param table
	 * @param swhere
	 * @return record count is > 1
	 */
	public Vector getData(String table, int begin, int end) throws Exception {
		return this.getData(table, null, begin, end);
	}

	/**
	 * 
	 * @param table
	 * @param swhere
	 * @return record count is > 1
	 */
	public Vector getData(String table, String swhere) throws Exception {
		Vector over = new Vector();
		Connection dbConnection = this.getConnection();
		Hashtable bdData = new Hashtable();
		String sql = "select * from " + table;
		if (swhere != null) {
			sql = sql + " " + swhere;

		}
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		String[] columnName = new String[columnCount];
		int[] columnTypeNo = new int[columnCount];

		for (int i = 0; i < columnCount; i++) {
			columnName[i] = rsmd.getColumnName(i + 1).toLowerCase();
			columnTypeNo[i] = rsmd.getColumnType(i + 1);
		}

		while (rs.next()) {
			bdData = new Hashtable();
			for (int i = 0; i < columnCount; i++) {
				if (columnTypeNo[i] == 91) {
					java.util.Date date = rs.getDate((i + 1));
					if (date != null) {
						bdData.put(columnName[i], rs.getDate((i + 1)));
					}
				} else {
					String stemp = rs.getString((i + 1));
					stemp = stemp == null ? "" : stemp;
					// stemp = stemp.equals("0") ? "":stemp;
					bdData.put(columnName[i], stemp);
				}
			}
			over.addElement(bdData);

		} // while
		rs.close();
		stmt.close();
		return over;
	}

	/**
	 * 
	 * @param table
	 * @param swhere
	 * @return record count is > 1
	 */
	public Vector getData(String table, String swhere, int begin, int end)
			throws Exception {
		Vector over = new Vector();
		Connection dbConnection = this.getConnection();
		Hashtable bdData = new Hashtable();
		String sql = "select * from " + table;
		if (swhere != null) {
			sql = sql + " " + swhere;

		}
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		String[] columnName = new String[columnCount];
		int[] columnTypeNo = new int[columnCount];

		for (int i = 0; i < columnCount; i++) {
			columnName[i] = rsmd.getColumnName(i + 1).toLowerCase();
			columnTypeNo[i] = rsmd.getColumnType(i + 1);
		}

		int no = 1;
		while (rs.next()) {
			if (no < begin || no > end) {
				no++;
				continue;
			}
			bdData = new Hashtable();
			for (int i = 0; i < columnCount; i++) {
				if (columnTypeNo[i] == 91) {
					java.util.Date date = rs.getDate((i + 1));
					if (date != null) {
						bdData.put(columnName[i], rs.getDate((i + 1)));
					}
				} else {
					String stemp = rs.getString((i + 1));
					stemp = stemp == null ? "" : stemp;
					// stemp = stemp.equals("0") ? "":stemp;
					bdData.put(columnName[i], stemp);
				}
			}
			over.addElement(bdData);
			no++;
		} // while
		rs.close();
		stmt.close();
		return over;
	}

	/**
	 * 
	 * @param table
	 * @param swhere
	 * @return record count is > 1
	 */
	public List selectList(String sql) throws Exception {
		return selectList(sql,-1,0);
	}

	/**
	 * 
	 * @param table
	 * @param swhere
	 * @return record count is > 1
	 */
	public List selectList(String sql, int begin, int end) throws Exception {
		List over = new ArrayList();
		Connection dbConnection = this.getConnection();
		Map bdData = new HashMap();

		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		String[] columnName = new String[columnCount];
		int[] columnTypeNo = new int[columnCount];

		for (int i = 0; i < columnCount; i++) {
			columnName[i] = rsmd.getColumnName(i + 1).toLowerCase();
			columnTypeNo[i] = rsmd.getColumnType(i + 1);
		}

		int no = 1;
		while (rs.next()) {
			if (begin != -1) {
				if (no < begin || no > end) {
					no++;
					continue;
				}
			}
			bdData = new HashMap();
			for (int i = 0; i < columnCount; i++) {
				if (columnTypeNo[i] == 91) {
					java.util.Date date = rs.getDate((i + 1));
					if (date != null) {
						bdData.put(columnName[i], rs.getDate((i + 1)));
					}
				} else {
					String stemp = rs.getString((i + 1));
					stemp = stemp == null ? "" : stemp;
					// stemp = stemp.equals("0") ? "":stemp;
					bdData.put(columnName[i], stemp);
				}
			}
			over.add(bdData);
			no++;
		} // while
		rs.close();
		stmt.close();
		return over;
	}

	
	/**
	 * 
	 * @param table
	 * @param swhere
	 * @return record count is > 1
	 */
	public List selectList(String sql, int begin, int end,String resultClass) throws Exception {
		List result = new ArrayList();
		Connection dbConnection = this.getConnection();
		Map bdData = new HashMap();

		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		int no = 0;
		int columnCount = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			if (begin != -1) {
				if (!(no >= begin && no < end)) {
					no++;
					continue;
				}
			}
			Class c = Class.forName(resultClass);
			Object vo = c.getConstructor(null).newInstance(null);
			for (int i = 0; i < columnCount; i++) {
				String columnName = rs.getMetaData().getColumnName(
						i + 1).toUpperCase();
				String setMethod = "set" + columnName.substring(0, 1)
						+ columnName.substring(1).toLowerCase();
				Object value = rs.getObject(i + 1);
				String getMethod = setMethod.replaceFirst("set", "get");
				Class columnType = c.getMethod(getMethod, null)
						.getReturnType();
				if (columnType.getName().equals("long")) {
					if (value != null) {
						value = new Long(Long.parseLong(value
								.toString()));
					}
				} else if (columnType.getName().equals(
						"java.lang.String")) {
					if (value != null) {
						value = value.toString();
					}
				} else if (columnType.getName()
						.equals("java.util.Date")) {
					if (value != null) {
						value = (java.util.Date) value;
					}
				} else if (columnType.getName().equals("int")) {
					if (value != null) {
						value = Integer.valueOf(value.toString());
					}
				} else if (columnType.getName().equals("double")) {
					if (value != null) {
						value = Double.valueOf(value.toString());
					}
				} else if (columnType.getName().equals("float")) {
					if (value != null) {
						value = Float.valueOf(value.toString());
					}
				}

				Class[] agrType = new Class[1];
				agrType[0] = columnType;
				Object[] agrO = new Object[1];
				agrO[0] = value;
				if (value != null) {
					c.getMethod(setMethod, agrType).invoke(vo, agrO);
				}
			}
			result.add(vo);
			no++;
		} // while
		rs.close();
		stmt.close();
		return result;
	}
	
	/**
	 * The following method is used by pc installed
	 * 
	 * @param id
	 * @param name
	 * @param pass1
	 * @param role
	 * @throws SQLException
	 */

	public void insertUserData(String id, String name, String pass1, String role)
			throws SQLException {
		this.connection = this.getConnection();
		PreparedStatement ps = this.connection
				.prepareStatement("insert into user values(?,?,?,?)");
		ps.setString(1, id);
		ps.setString(2, pass1);
		ps.setString(3, name);
		ps.setString(4, role);
		ps.executeUpdate();
		ps.close();
	};

	public void updateUserData(String id, String name, String pass1, String role)
			throws SQLException {
		this.connection = this.getConnection();
		PreparedStatement ps = this.connection
				.prepareStatement("update user set password = ?,userName=?,role = ? where userID = ?");
		ps.setString(1, pass1);
		ps.setString(2, name);
		ps.setString(3, role);
		ps.setString(4, id);
		ps.executeUpdate();
		ps.close();
	};

	public void insertProductTypeData(String id, String name, int type)
			throws SQLException {
		PreparedStatement ps = this.connection
				.prepareStatement("insert into productType values(?,?,?)");
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setInt(3, type);
		ps.executeUpdate();
		ps.close();
	}

	public void updateProductTypeData(String id, String name)
			throws SQLException {
		PreparedStatement ps = this.connection
				.prepareStatement("update productType set name = ? where id = ?");
		ps.setString(1, name);
		ps.setString(2, id);
		ps.executeUpdate();
		ps.close();
	}

	public void insertProductData(Vector data) throws SQLException {
		PreparedStatement ps = this.connection
				.prepareStatement("insert into product values(?,?,?,?,?,?,?,?,?)");
		for (int i = 1; i <= data.size(); i++) {
			ps.setObject(i, data.elementAt(i - 1));
		}
		ps.executeUpdate();
		ps.close();
	}

	public void updateProductData(Vector data, String id) throws SQLException {
		Statement st = this.connection.createStatement();
		String sql = "select quantity from product where id = '" + id + "'";
		ResultSet rs = st.executeQuery(sql);
		int quantity = 0;
		if (rs.next()) {
			quantity = rs.getInt(1);
		}
		rs.close();

		quantity += Integer.parseInt(data.elementAt(6).toString());
		data.removeElementAt(6);
		data.insertElementAt(new Integer(quantity), 6);
		sql = "update product set name = ?,brand = ?,spec = ?,price = ?,inputprice = ?,"
				+ " insurerepairtime = ? , quantity = ?,supplier = ? where id = ?";

		PreparedStatement ps = this.connection.prepareStatement(sql);
		for (int i = 1; i <= data.size(); i++) {
			ps.setObject(i, data.elementAt(i - 1));
		}
		ps.setString(9, id);
		ps.executeUpdate();
		ps.close();
	}

	public Vector selectData(String sql) throws SQLException {
		Statement st = this.connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		Vector data = new Vector();
		while (rs.next()) {
			Vector temp = new Vector();
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				Object o_temp = rs.getObject(i + 1);
				if (o_temp == null || o_temp.toString().equals("-1")
						|| o_temp.toString().equals("&^%")) {
					temp.addElement("");
				} else {
					temp.addElement(o_temp);
				}
			}
			data.addElement(temp);
		}
		rs.close();
		st.close();
		return data;

	}

	public String getOrderID() throws SQLException {
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyMMdd");
		String s_date = sdf.format(date);
		Statement st = this.connection.createStatement();
		ResultSet rs = st
				.executeQuery("select max(orderID) from order1 where orderID like '"
						+ s_date + "%' and isTemplate = 2 ");
		String id = "";
		if (rs.next()) {
			id = rs.getString(1);
		}
		if (id == null) {
			id = s_date + "0001";
		} else {
			id = id.substring(6);
			int i_id = Integer.parseInt(id) + 1;
			id = i_id + "";
			if (id.length() == 1) {
				id = "000" + id;
			} else if (id.length() == 2) {
				id = "00" + id;
			} else if (id.length() == 3) {
				id = "0" + id;
			}
			id = s_date + id;
		}
		rs.close();
		st.close();
		return id;

	}

	public String getTemplateID() throws SQLException {
		Statement st = this.connection.createStatement();
		ResultSet rs = st
				.executeQuery("select max(orderID) from order1 where  isTemplate = 1 ");
		String id = "0";
		if (rs.next()) {
			id = rs.getString(1);
		}
		if (id == null) {
			id = "0";
		}
		id = (Integer.parseInt(id) + 1) + "";
		rs.close();
		st.close();
		return id;
	}

	public Vector getOrderData(String s_where) throws SQLException {
		Vector data = new Vector();
		String sql = "select orderid, customerName, address, money,createID,createTime from  order1 where  ";
		if (!s_where.equals("")) {
			sql += s_where;
		}
		//System.out.println("sql = " + sql);
		Statement st = this.connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			Vector temp = new Vector();
			int colcount = rs.getMetaData().getColumnCount();
			for (int i = 0; i < colcount; i++) {
				Object o_temp = rs.getObject(i + 1);
				if (o_temp.toString().equals("-1")
						|| o_temp.toString().equals("&^%")) {
					temp.addElement("");
				} else {
					temp.addElement(o_temp);
				}
			}
			data.addElement(temp);
		}
		rs.close();
		st.close();
		return data;

	}

	public Vector getTemplateData() throws SQLException {
		Vector data = new Vector();
		String sql = "select orderid, customerName, money1 from  order1 where isTemplate = 1 order by orderid desc ";
		//System.out.println("sql = " + sql);
		Statement st = this.connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			Vector temp = new Vector();
			int colcount = rs.getMetaData().getColumnCount();
			for (int i = 0; i < colcount; i++) {
				Object o_temp = rs.getObject(i + 1);
				if (o_temp.toString().equals("-1")
						|| o_temp.toString().equals("&^%")) {
					temp.addElement("");
				} else {
					temp.addElement(o_temp);
				}
			}
			data.addElement(temp);
		}
		rs.close();
		st.close();
		return data;

	}

	public Vector getOrderChildData(String orderID) throws SQLException {
		String sql = "select product.id,orderchild.no,product.name,product.brand,product.spec,orderchild.tradeprice,orderchild.count,orderchild.sum,product.insurerepairtime from orderchild,product where orderchild.productid = product.id and orderid = ? order by orderchild.no asc";
		//System.out.println("sql = " + sql);
		PreparedStatement ps = this.connection.prepareCall(sql);
		ps.setObject(1, orderID);
		ResultSet rs = ps.executeQuery();
		Vector data = new Vector();
		Vector data_id = new Vector();
		while (rs.next()) {
			Vector temp = new Vector();
			int rowCount = rs.getMetaData().getColumnCount();
			for (int i = 0; i < rowCount; i++) {
				if (i == 0) {
					data_id.addElement(rs.getObject(1));
				} else {
					Object o_temp = rs.getObject(i + 1);
					if (o_temp.toString().equals("-1")
							|| o_temp.toString().equals("&^%")) {
						temp.addElement("");
					} else {
						temp.addElement(o_temp);
					}
				}
			}
			data.addElement(temp);
		}
		Vector overdata = new Vector();
		overdata.addElement(data_id);
		overdata.addElement(data);
		rs.close();
		ps.close();

		return overdata;

	}

	public void insertOrUpdateOrderData(Vector maindata, Vector childData,
			Vector productID, String id, boolean isOrder) throws SQLException {
		this.connection.setAutoCommit(false);
		Statement st = this.connection.createStatement();

		String insertMain = "insert into order1 values(?,?,?,?,?,?,?,?)";
		String insertChild = "insert into orderChild values(?,?,?,?,?,?)";
		PreparedStatement ps = this.connection.prepareStatement(insertMain);

		try {
			st.executeUpdate("delete from order1 where orderid = '" + id + "'");
			for (int i = 0; i < maindata.size(); i++) {
				ps.setObject(i + 1, maindata.elementAt(i));
			}
			ps.executeUpdate();

			// isert new record
			ps = this.connection.prepareStatement(insertChild);
			for (int i = 0; i < childData.size(); i++) {
				ps.setObject(1, id);
				Vector temp = (Vector) childData.elementAt(i);
				String productID1 = productID.elementAt(i).toString();
				String sql_quantity = "select count from orderchild where orderid = '"
						+ id + "' and productid = '" + productID1 + "' ";
				ResultSet rs = st.executeQuery(sql_quantity);
				int quantity_present = Integer.parseInt(temp.elementAt(5)
						.toString());
				if (rs.next()) {
					int quantity_xianqian = rs.getInt(1);
					quantity_present -= quantity_xianqian;
				}
				st.executeUpdate("delete from orderChild where orderid = '"
						+ id + "' and productID = '"
						+ productID.elementAt(i).toString() + "'");
				ps.setObject(2, temp.elementAt(0));
				ps.setObject(3, productID.elementAt(i));
				ps.setObject(4, temp.elementAt(5));
				ps.setObject(5, temp.elementAt(4));
				ps.setObject(6, temp.elementAt(6));
				ps.executeUpdate();
				// if(isOrder){
				// String id1 = productID.elementAt(i).toString();
				// this.updateProductQuantity(id1,quantity_present,false);
				// }
			}
			this.connection.commit();

		} catch (SQLException ex) {
			try {
				this.connection.rollback();

			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			throw ex;
		} finally {
			st.close();
			ps.close();
			this.connection.setAutoCommit(true);
		}
	}

	public void deleteOrderData(String id, boolean isOrder) throws SQLException {
		this.connection.setAutoCommit(false);
		Statement st = this.connection.createStatement();

		String sql_quantity = "select productid,count from orderchild where orderid = '"
				+ id + "'";
		ResultSet rs = st.executeQuery(sql_quantity);
		try {
			// while(rs.next()){
			// String productid = rs.getString(1);
			// int quantity = rs.getInt(2);
			// this.updateProductQuantity(productid,quantity,true);
			// }
			// rs.close();
			st.executeUpdate("delete from orderChild where orderid = '" + id
					+ "'");
			st.executeUpdate("delete from order1 where orderid = '" + id + "'");
			this.connection.commit();

		} catch (SQLException ex) {
			try {
				this.connection.rollback();
				rs.close();
				st.close();
				throw ex;
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
		} finally {
			st.close();
			this.connection.setAutoCommit(true);
		}
	}

	public void updateProductQuantity(String productID, int quantity,
			boolean isInput) throws SQLException {
		Statement st = this.connection.createStatement();
		String sql = "select quantity from product where id = '" + productID
				+ "'";
		ResultSet rs = st.executeQuery(sql);
		int quantity_or = 0;
		if (rs.next()) {
			quantity_or = rs.getInt(1);
		}
		rs.close();
		if (!isInput) {
			if (quantity_or < quantity) {
				st.close();
				throw new SQLException("APP产品ID: " + productID
						+ " 库存小于出货量,无法出货");
			}
		}
		if (isInput) {
			quantity = quantity_or + quantity;
		} else {
			quantity = quantity_or - quantity;

		}
		sql = "update product set quantity = " + quantity + " where id = '"
				+ productID + "'";
		st.executeUpdate(sql);
		st.close();
	}

	public void deleteData(String sql) throws SQLException {
		Statement st = this.connection.createStatement();
		st.executeUpdate(sql);
	}

	/**
	 * for the Single-Machine Release
	 * 
	 */
	private DBAgent() {
		try {
			this.connection = this.connectionPool.getConnection();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private static DBAgent dbAgent = new DBAgent();

	public static DBAgent getInstance() {
		return dbAgent;
	}

}