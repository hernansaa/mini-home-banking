package excepciones;

public class Validador {
	
	public static String validarTextoNoVacio(String texto) throws TextoVacioException {
		if(texto.length() == 0 || texto == " ") {
			throw new TextoVacioException("El texto esta vacio lo cual es invalido.");
		}
		return texto;
	}
	
	public static int validarNumeroNoNegativo(int numero) throws NumeroNegativoException {
		if(numero < 0) {
			throw new NumeroNegativoException("El numero no puede ser negativo");
		}
		return numero;
	}
	
	public static String validarSoloLetras(String texto) throws SoloLetrasException {
        if (!texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new SoloLetrasException("El texto solo debe contener letras");
        }
        return texto;
    }
	
	public static String validarSoloNumeros(String texto) throws SoloNumerosException {
		if (!texto.matches("\\d+")) {
            throw new SoloNumerosException("El texto contiene caracteres no numéricos");
        }
        return texto;
    }
	
	public static String validarLetrasYNumeros(String texto) throws CombinacionLetrasNumerosException {
	    if (!texto.matches("[a-zA-Z0-9]+")) {
	        throw new CombinacionLetrasNumerosException("El texto contiene caracteres inválidos (solo letras y números permitidos)");
	    }
	    return texto;
	}

	
	public static int validarNumeroEnRango(int numero, int minimo, int maximo) throws RangoInvalidoException {
		if (numero < minimo || numero > maximo) {
			throw new RangoInvalidoException("El numero debe estar entre " + minimo + " y" + maximo);
		}
		return numero;
	}
	
	public static String validarEmail(String email) throws EmailInvalidoException {
	    String patronEmail = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
	    if (!email.matches(patronEmail)) {
	        throw new EmailInvalidoException("El formato del correo electrónico es inválido.");
	    }
	    return email;
	}
	
	public static String validarPassword(String password) throws PasswordInvalidoException {
	    if (password == null || password.trim().isEmpty()) {
	        throw new PasswordInvalidoException("La contraseña no puede estar vacía.");
	    }

	    if (password.length() < 6) {
	        throw new PasswordInvalidoException("La contraseña debe tener al menos 6 caracteres.");
	    }

	    // Verifica que contenga al menos una letra y un número
	    if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d).+$")) {
	        throw new PasswordInvalidoException("La contraseña debe contener letras y números.");
	    }

	    return password;
	}
}
