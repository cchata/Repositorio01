package com.ecoinnova.pe.hibernate.util;

public class TestConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(HibernateUtil.getSessionFactory()!=null){
			System.out.println("Conexion Ok.");
		}else{
			System.out.println("Conexion Null.");
		}
	}

}
