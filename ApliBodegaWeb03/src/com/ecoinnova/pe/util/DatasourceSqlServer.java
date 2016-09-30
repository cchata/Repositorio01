package com.ecoinnova.pe.util;

import java.sql.*;

public class DatasourceSqlServer {

	private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url    = "jdbc:sqlserver://localhost:1433;databaseName=bdBodega";
	private static final String user   = "sa";
	private static final String pwd    = "root";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException, Exception {
		Connection cn = null;
		try {
			Class.forName(driver);
			cn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException ex) {
			throw ex;
		} catch (SQLException ex) {
			throw ex;
		} catch (Exception ex) {
			throw ex;
		}
		return cn;
	}

}
