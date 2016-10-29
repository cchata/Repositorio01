package com.ecoinnova.pe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatasourcePostgres {
	private static final String driver = "org.postgresql.Driver";
	private static final String url    = "jdbc:postgresql://128.0.4.19:5432/jiradb";
	private static final String user   = "jira";
	private static final String pwd    = "p@ssw0rd";
	
	
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
