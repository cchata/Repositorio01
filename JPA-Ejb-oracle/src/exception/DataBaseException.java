package exception;

public class DataBaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	

	public DataBaseException(){
		super();
	}
	
	public DataBaseException(String mensaje){
		super(mensaje);
	}
	
	public DataBaseException(String mensaje, Throwable cause){
		super(mensaje, cause);
	}
	
	public DataBaseException(Throwable cause){
		super(cause);
	}

}
