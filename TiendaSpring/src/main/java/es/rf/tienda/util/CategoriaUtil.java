package es.rf.tienda.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CategoriaUtil {

	private static final String ALFANUMERIC_NOMBRE_PATTERN = "^[a-zA-Z0-9\\s]{5,51}$";
	private static final String ALFANUMERIC_DESC_PATTERN = "^[a-zA-Z0-9\\s]{0,200}$";

	/**
	 * NOMBRE: nombreAlfanumerico
	 * 
	 * DESCRIPCIÓN: Permite verificar que el texto pasado solo contiene carácteres
	 * alfanuméricos de mínimo 5 y de máximo 50
	 * 
	 * @param texto String a verificar que solo tenga carácteres alfanuméricos
	 * 
	 * @return TRUE, si cumple solo contiene caracters alfanuméricos y FALSE en caso
	 *         contrario
	 */

	public static boolean nombreAlfanumerico(String texto) {
		Pattern pattern = Pattern.compile(ALFANUMERIC_NOMBRE_PATTERN);
		Matcher matcher = pattern.matcher(texto);
		return matcher.matches();
	}

	/**
	 * NOMBRE: descAlfanumerico
	 * 
	 * DESCRIPCIÓN: Permite verificar que el texto pasado solo contiene carácteres
	 * alfanuméricos hasta 200 carácteres
	 * 
	 * @param texto String a verificar que solo tenga carácteres alfanuméricos
	 * 
	 * @return TRUE, si cumple solo contiene caracters alfanuméricos y FALSE en caso
	 *         contrario
	 */

	public static boolean descAlfanumerico(String texto) {
		Pattern pattern = Pattern.compile(ALFANUMERIC_DESC_PATTERN);
		Matcher matcher = pattern.matcher(texto);
		return matcher.matches();
	}
}
