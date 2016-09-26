package DatosAcceso;

public class ProbarConexion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Conexion cn = new Conexion();
		if(cn.getConnection()!=null){
			System.out.println("Conexion Ok.");
		}else{
			System.out.println("No se pudo conectar.");
		}
	}

}
