package com.caru.db;

import java.sql.*;
import java.util.Properties;

import javax.naming.*;
import javax.sql.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.*;

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

public class ConnectionPool {
	Connection connection = null;

	public ConnectionPool() {
	}

	public Connection getConnection_JNDI() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		return conn;
	}

	public Connection getConnection_Oracle() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Connection con = null;
		try {
			File file = new File("oracle.properties");
			BufferedReader data = new BufferedReader(new FileReader(file));
			String url = data.readLine();
			url = url.substring("url".length() + 1);
			String username = data.readLine();
			username = username.substring("username".length() + 1);
			String password = data.readLine();
			password = password.substring("password".length() + 1);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}

	public Connection getConnection_Access1() throws SQLException {
		String urlmdb = "";
		try {
			String access = getClass().getResource("ZhangJi.mdb").toString();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			URL url_mdb = getClass().getResource("ZhangJi.mdb");
			String mdb = url_mdb.getFile();
			mdb = mdb.substring(1);
			urlmdb = "jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb);DBQ="
					+ mdb + ";readonly=false";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(urlmdb, "", "");
		return connection;
	}

	public Connection getConnection_Access() throws SQLException {
		String urlmdb = "";
		try {
			// String access = getClass().getResource("ZhangJi.mdb").toString();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// URL url_mdb = getClass().getResource("ZhangJi.mdb");
			// String mdb = url_mdb.getFile();
			// String mdb ="E:\\workspace\\MySystemSummary_bak\\ZhangJi.mdb";
			String mdb = "stock.mdb";

			urlmdb = "jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb);DBQ="
					+ mdb + ";readonly=false";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(urlmdb, "", "");
		return connection;
	}

	public Connection getConnection_MySQL() throws SQLException {
		try {
			InitialContext ic = new InitialContext();
			DataSource myDS = (DataSource) ic
					.lookup("java:comp/env/jdbc/carudb");
			Connection result = myDS.getConnection();
			return result;
		} catch (Exception ex) {
			//ex.printStackTrace();
			System.out
					.println("Getting single connection through accessing db directly");
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			String url = "jdbc:mysql://localhost:3306/carucrm?user=root&password=pass&useUnicode=true&characterEncoding=UTF-8";
			Connection connection = DriverManager.getConnection(url);
			System.out
					.println("Got single connection through accessing db directly");
			return connection;
		}
	}

	public Connection getConnection() throws SQLException {
		return getConnection_MySQL();
	}

}
