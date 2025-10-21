package excepciones;

public class RangoInvalidoException extends Exception {
	public RangoInvalidoException() {
	}
	
	public RangoInvalidoException(String message) {
		super(message);
	}
	
	public RangoInvalidoException(Throwable cause) {
		super(cause);
	}
	
	public RangoInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}
}