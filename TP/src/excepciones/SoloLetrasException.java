package excepciones;

public class SoloLetrasException extends Exception {
	public SoloLetrasException() {
	}
	
	public SoloLetrasException(String message) {
		super(message);
	}
	
	public SoloLetrasException(Throwable cause) {
		super(cause);
	}
	
	public SoloLetrasException(String message, Throwable cause) {
		super(message, cause);
	}
}