package rf.ficheros.util;

public class MontadorSQL {

	/**
	 * Completar SQL añadiendo el nombre del campo y su valor (si se pasa)
	 * 
	 * Pensado para INSERT y UPDATES
	 * 
	 * @param salida
	 * @param nombreCampo
	 * @param valor
	 * @param separador
	 * @return
	 */

	public static String addSalida(String salida, String nombreCampo, int valor, String separador) {
		return addSalidaSencilla(salida, nombreCampo, "" + valor, separador);
	}

	public static String addSalida(String salida, String nombreCampo, double valor, String separador) {
		return addSalidaSencilla(salida, nombreCampo, "" + valor, separador);
	}

	public static String addSalida(String salida, String nombreCampo, long valor, String separador) {
		return addSalidaSencilla(salida, nombreCampo, "" + valor, separador);
	}

	public static String addSalida(String salida, String nombreCampo, String valor, String separador) {
		return addSalidaSencilla(salida, nombreCampo, "'" + valor + "'", separador);
	}

	/**
	 * Recibe un String parcialmente construida y que tiene completar
	 * 
	 * El nombre del campo se añade solo si no es nulo
	 * 
	 * A continuación del nombre del campo, se añade un signo "=" solo si se ha
	 * añadido nombre del campo
	 * 
	 * A continuación se añade el valor recibido
	 * 
	 */

	public static String addSalidaSencilla(String salida, String nombreCampo, String valor, String separador) {
		if (salida.length() > 0) {
			salida += " " + separador + " ";
			if (nombreCampo != null && nombreCampo.compareTo("") > 0) {
				salida += nombreCampo + " = ";
			}
			salida += valor;
		}
		return salida;
	}
}
