package com.ecoinnova.pe.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AccesoDB {

	public static Connection getConnection() throws Exception {
		Connection cn = null;

		try {
			Context c = new InitialContext();
			DataSource ds = (DataSource) c.lookup("java:comp/env/jdbc/sqlserver");
			cn = ds.getConnection();
			// System.out.println("ds: "+ds+" y cn: "+cn);
			System.out.println("Conexion Ok.");
		} catch (NamingException ex) {
			System.out.println("NamingException: " + ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	return cn;
	}

}
