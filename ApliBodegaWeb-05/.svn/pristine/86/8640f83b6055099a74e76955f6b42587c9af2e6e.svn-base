package com.ecoinnova.pe.util;

import java.sql.SQLException;

public class TestConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			if(DatasourceSqlServer.getConnection()!= null){
				System.out.println("Conexion Ok.");
			}else{
				System.out.println("Conexion Ok.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
