package es.rf.tienda.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: Clase auxiliar para validar los datos que sean introducidos en
 * la aplicación.
 * 
 * @author laura.galvez.moya
 */

public class Validator {

	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z]+$";

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@SuppressWarnings("unused")
	private final static String DNI_PATTERN = "^\\d{2}\\.\\d{3}\\.\\d{3}-[A-Za-z]$";

	private final static String PHONE_PATTERN = "[\\d ]{10,20}";

	@SuppressWarnings("unused")
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

	@SuppressWarnings("unused")
	private final static int LONGITUD_DNI = 12;

	private static final String CODIGO_PRODUCTO_PATTERN = "^[A-Z]{2}[0-9]{3}$";

	/**
	 * NOMBRE: codigoProducto
	 * 
	 * DESCRIPCIÓN: Permite verificar que el texto pasado solo contiene dos letras
	 * mayúsculas y tres numeros
	 * 
	 * @param texto String
	 * 
	 * @return TRUE, si cumple y FALSE en caso contrario
	 */

	public static boolean codigoProducto(String texto) {
		if (texto != null && texto.matches(CODIGO_PRODUCTO_PATTERN)) {
			return true;
		}

		return false;
	}

	/**
	 * NOMBRE: isAlfanumeric
	 * 
	 * DESCRIPCIÓN: Permite verificar que el texto pasado solo contiene carácteres
	 * alfanuméricos
	 * 
	 * @param texto String a verificar que solo tenga carácteres alfanuméricos
	 * 
	 * @return TRUE, si cumple solo contiene caracters alfanuméricos y FALSE en caso
	 *         contrario
	 */

	public static boolean isAlfanumeric(String texto) {
		if (texto != null && texto.matches(ALFANUMERIC_PATTERN)) {
			return true;
		}

		return false;
	}

	/**
	 * NOMBRE: cumplePhoneNumber
	 * 
	 * DESCRIPCIÓN: El phone number debe tener un total de entre 10 y 20, contando
	 * dígitos y espacios. Mínimo aceptable son 10 dígitos.
	 * 
	 * @param phoneNumber String con el número de teléfono de entre 10 y 20 dígitos
	 *                    Puede tener espacios, pero siempre con 10 dígitos como
	 *                    mínimo
	 * 
	 * @return true, si cumple todas las condiciones
	 *
	 **/

	public static boolean cumplePhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile(PHONE_PATTERN);
		return pattern.matcher(phoneNumber).matches();
	}

	/**
	 * NOMBRE: isEmailValido
	 * 
	 * DESCRIPCIÓN: Comprueba si el email tiene un formato que pueda ser válido
	 * 
	 * @param email String a comprobar
	 * 
	 * @return true, en caso que el formato sea válido
	 * 
	 */

	public static boolean isEmailValido(String email) {
		Pattern pat = Pattern.compile(EMAIL_PATTERN);
		return pat.matcher(email).matches();
	}

	/**
	 * NOMBRE: cumpleDNI
	 * 
	 * DESCRIPCIÓN: Esta función verifica que el DNI cumple el siguiente formato:
	 * xx.xxx.xxx-L
	 * 
	 * @param dni String con DNI a ser validado
	 * 
	 * @return true, si el DNI cumple el estandar nacional
	 */

	public static boolean cumpleDNI(String dni) {

		Pattern pattern = Pattern.compile(DNI_PATTERN);
		Matcher matcher = pattern.matcher(dni);
		return matcher.matches();

	}

	/**
	 * NOMBRE: cumpleRango
	 * 
	 * DESCRIPCIÓN: Comprueba que un número se necuentra entre 2 valores
	 * 
	 * @param valor       (int)/(double) Número a comprobar
	 * @param valorMinimo (int) Mínimo valor aceptable
	 * @param valorMaximo (int) Máximo valor aceptable
	 * 
	 * @return true si valorMinimo < valor < valorMaximo
	 **/

	public static boolean cumpleRango(int valor, int valorMinimo, int valorMaximo) {
		if (valorMinimo < valor && valor < valorMaximo) {
			return true;
		}

		return false;
	}

	public static boolean cumpleRango(double valor, int valorMinimo, int valorMaximo) {
		if (valorMinimo < valor && valor < valorMaximo) {
			return true;
		}

		return false;
	}

	/**
	 * NOMBRE: cumpleLongitudMin
	 * 
	 * DESCRIPCIÓN: Comprobar que el texto pasado tiene una longitud de al menos x
	 * carácteres, siendo x el entero pasado como parámetro
	 * 
	 * @param texto          String texto a comprobar
	 * @param longitudMinima int que indique longitud mínima.
	 * 
	 * @return cierto, si la longitud del texto es mayor o igual que longitudMinima
	 **/

	public static boolean cumpleLongitudMin(String texto, int longitudMinima) {
		if (texto.length() >= longitudMinima) {
			return true;
		}

		return false;
	}

	/*
	 * NOMBRE: cumpleLongitudMax
	 * 
	 * DESCRIPCIÓN: Comprobar que el texto pasado tiene una longitud de, como mucho,
	 * x carácteres, siendo x el entero pasado como parámetro
	 * 
	 * @param texto String con el texto a comprobar
	 * 
	 * @param longitudMaxima int con la longitud máxima del texto
	 * 
	 * @return true, si el texto es menor o igual que la longitud máxima
	 */

	public static boolean cumpleLongitudMax(String texto, int longitudMaxima) {
		if (texto.length() <= longitudMaxima) {
			return true;
		}

		return false;
	}

	/**
	 * NOMBRE: cumpleLongitud
	 * 
	 * DESCRIPCIÓN: Comprobar que la longitud de un texto se encuentra entre unos
	 * valores m�ximos y m�nimos
	 * 
	 * @param texto          String con el texto que a validar
	 * @param longitudMinima (int) Mínima longitud del texto
	 * @param longitudMaxima (int) Máxima longitud válida para el texto
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima <=
	 *         longitudTexto <= longitudMaxima
	 **/

	public static boolean cumpleLongitud(String texto, int longitudMinima, int longitudMaxima) {
		if (longitudMinima <= texto.length() && texto.length() <= longitudMaxima) {
			return true;
		}

		return false;
	}

	/**
	 * NOMBRE: valDateMin
	 * 
	 * DESCRIPCIÓN: Valida una fecha calendar con mínimo min
	 * 
	 * @param fecha
	 * @param min
	 * @return
	 */

	public static boolean valDateMin(LocalDate fecha, LocalDate min) {
		return fecha.isAfter(min) || fecha.equals(min);

	}

	/**
	 * NOMBRE: valDateMax
	 * 
	 * DESCRIPCIÓN: Valida una fecha calendar con máximo max
	 * 
	 * @param fecha
	 * @param max
	 * @return
	 */

	public static boolean valDateMax(LocalDate fecha, LocalDate max) {
		return fecha.isBefore(max) || fecha.equals(max);

	}

	/**
	 * NOMBRE: esFechaValida
	 * 
	 * DESCRIPCIÓN: Recibe una string con formato fecha dd/mm/aaaa y comprueba el
	 * formato
	 * 
	 * @param fecha
	 * @return
	 */

	public static boolean esFechaValida(String fecha) {
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			LocalDate.parse(fecha, formatoFecha);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * NOMBRE: esPasswordValida
	 * 
	 * DESCRIPCIÓN: Comprueba que la cadena recibida cumpla con las normas de
	 * contraseña
	 * 
	 * @param password string con la contraseña introducida
	 * @return true si cumple con las especificaciones
	 */

	public static boolean esPasswordValida(String password) {
		Pattern patE = Pattern.compile(PASSWORD_PATTERN);
		return patE.matcher(password).matches();
	}
}
