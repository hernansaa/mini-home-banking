//package excepciones;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        // --- Texto no vacío ---
//        try {
//            System.out.println("TEST: Validación de texto vacío (válido).");
//            String input = "Hola";
//            System.out.println("Input: \"" + input + "\"");
//            String texto = Validador.validarTextoNoVacio(input);
//            System.out.println("Texto válido: " + texto);
//        } catch (TextoVacioException e) {
//            System.out.println("Error: " + e);
//        }
//
//        try {
//            System.out.println("\nTEST: Validación de texto vacío (inválido).");
//            String input = "";
//            System.out.println("Input: \"" + input + "\"");
//            String texto = Validador.validarTextoNoVacio(input);
//            System.out.println("Texto inválido: " + texto);
//        } catch (TextoVacioException e) {
//            System.out.println("Error: " + e);
//        }
//
//        // --- Número no negativo ---
//        try {
//            System.out.println("\nTEST: Validación de número no negativo (válido).");
//            int input = 124;
//            System.out.println("Input: " + input);
//            int numeroValido = Validador.validarNumeroNoNegativo(input);
//            System.out.println("Número válido: " + numeroValido);
//        } catch (NumeroNegativoException e) {
//            System.out.println("Error: " + e);
//        }
//
//        try {
//            System.out.println("\nTEST: Validación de número no negativo (inválido).");
//            int input = -23;
//            System.out.println("Input: " + input);
//            int numeroInvalido = Validador.validarNumeroNoNegativo(input);
//            System.out.println("Número válido: " + numeroInvalido);
//        } catch (NumeroNegativoException e) {
//            System.out.println("Error: " + e);
//        }
//
//        // --- Solo números ---
//        try {
//            System.out.println("\nTEST: Validación de solo números (válido).");
//            String input = "12345";
//            System.out.println("Input: \"" + input + "\"");
//            String numero = Validador.validarSoloNumeros(input);
//            System.out.println("Número válido: " + numero);
//        } catch (SoloNumerosException e) {
//            System.out.println("Error: " + e);
//        }
//
//        try {
//            System.out.println("\nTEST: Validación de solo números (inválido).");
//            String input = "12a45";
//            System.out.println("Input: \"" + input + "\"");
//            String numero = Validador.validarSoloNumeros(input);
//            System.out.println("Número válido: " + numero);
//        } catch (SoloNumerosException e) {
//            System.out.println("Error: " + e);
//        }
//
//        // --- Solo letras ---
//        try {
//            System.out.println("\nTEST: Validación de solo letras (válido).");
//            String input = "Java";
//            System.out.println("Input: \"" + input + "\"");
//            String letras = Validador.validarSoloLetras(input);
//            System.out.println("Texto válido: " + letras);
//        } catch (SoloLetrasException e) {
//            System.out.println("Error: " + e);
//        }
//
//        try {
//            System.out.println("\nTEST: Validación de solo letras (inválido).");
//            String input = "Java123";
//            System.out.println("Input: \"" + input + "\"");
//            String letras = Validador.validarSoloLetras(input);
//            System.out.println("Texto válido: " + letras);
//        } catch (SoloLetrasException e) {
//            System.out.println("Error: " + e);
//        }
//
//        // --- Rango ---
//        try {
//            System.out.println("\nTEST: Validación de rango (válido).");
//            int input = 25;
//            System.out.println("Input: " + input);
//            int edad = Validador.validarNumeroEnRango(input, 18, 99);
//            System.out.println("Edad válida: " + edad);
//        } catch (RangoInvalidoException e) {
//            System.out.println("Error: " + e);
//        }
//
//        try {
//            System.out.println("\nTEST: Validación de rango (inválido).");
//            int input = 15;
//            System.out.println("Input: " + input);
//            int edad = Validador.validarNumeroEnRango(input, 18, 99);
//            System.out.println("Edad válida: " + edad);
//        } catch (RangoInvalidoException e) {
//            System.out.println("Error: " + e);
//        }
//        
//     // --- Letras y Números ---
//        try {
//            System.out.println("\nTEST: Validación de letras y números (válido).");
//            String input = "Java123";
//            System.out.println("Input: \"" + input + "\"");
//            String resultado = Validador.validarLetrasYNumeros(input);
//            System.out.println("Texto válido: " + resultado);
//        } catch (CombinacionLetrasNumerosException e) {
//            System.out.println("Error: " + e);
//        }
//
//        try {
//            System.out.println("\nTEST: Validación de letras y números (inválido).");
//            String input = "Java-123!";
//            System.out.println("Input: \"" + input + "\"");
//            String resultado = Validador.validarLetrasYNumeros(input);
//            System.out.println("Texto válido: " + resultado);
//        } catch (CombinacionLetrasNumerosException e) {
//            System.out.println("Error: " + e);
//        }
//
//    }
//}
