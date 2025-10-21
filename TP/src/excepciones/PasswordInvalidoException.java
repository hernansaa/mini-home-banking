package excepciones;

public class PasswordInvalidoException extends Exception {

    public PasswordInvalidoException() {}

    public PasswordInvalidoException(String message) {
        super(message);
    }

    public PasswordInvalidoException(Throwable cause) {
        super(cause);
    }

    public PasswordInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
