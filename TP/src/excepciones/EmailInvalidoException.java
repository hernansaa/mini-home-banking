package excepciones;

public class EmailInvalidoException extends Exception {
    public EmailInvalidoException() {}
    
    public EmailInvalidoException(String message) {
        super(message);
    }

    public EmailInvalidoException(Throwable cause) {
        super(cause);
    }

    public EmailInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
