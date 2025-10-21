package excepciones;

public class CombinacionLetrasNumerosException extends Exception {
	public CombinacionLetrasNumerosException() {
	}
	
	public CombinacionLetrasNumerosException(String message) {
		super(message);
	}
	
	public CombinacionLetrasNumerosException(Throwable cause) {
		super(cause);
	}
	
	public CombinacionLetrasNumerosException(String message, Throwable cause) {
		super(message, cause);
	}
}