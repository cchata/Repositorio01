package com.ecoinnova.pe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatasourceMysql {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url    = "jdbc:mysql://localhost:3306/arquitectura";
	private static final String user   = "root";
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
