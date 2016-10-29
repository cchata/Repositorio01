package com.ecoinnova.pe.util;

import java.sql.*;

public class DatasourceOrcl {

	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url    = "jdbc:oracle:thin:@localhost:1521:bdcchata";
	private static final String user   = "usucchata";
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
