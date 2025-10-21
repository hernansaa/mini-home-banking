package excepciones;

public class SoloNumerosException extends Exception {
	public SoloNumerosException() {
	}
	
	public SoloNumerosException(String message) {
		super(message);
	}
	
	public SoloNumerosException(Throwable cause) {
		super(cause);
	}
	
	public SoloNumerosException(String message, Throwable cause) {
		super(message, cause);
	}
}