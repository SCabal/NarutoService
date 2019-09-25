package exceptions;

public class ExceptionNoEncontrada extends Exception {	
	public ExceptionNoEncontrada(String msg) {
		super(msg +" que esta buscando, no ha sido encontrada");
	}
	
}
