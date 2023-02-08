package rf.ficheros.util;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class MontadorSQLTest extends TestCase {

	final String NOMBRE_DEL_CAMPO = "NombreCampo";
	final String NOMBRE_DEL_CAMPO_DOS = "NombreSegundo";
	final int VALOR_INT = 20;
	final double VALOR_DOUBLE = 111.11;
	final long VALOR_LONG = 9999;
	final String VALOR_STRING = "Esto es un texto";
	final String SALIDA = "NombreCampo = 20";
	final String SALIDA_DOS = "NombreCampo = 111.11";
	final String SALIDA_TRES = "NombreCampo = 9999";
	final String SALIDA_CUATRO = "NombreCampo = 'Esto es un texto'";
	final String SALIDA_CINCO = "NombreCampo = 20, NombreSegundi = 'Esto es un texto'";

	@Test
	public void testAddSalidaStringStringIntString() {
		String salida = "";
		salida = MontadorSQL.addSalida(salida, NOMBRE_DEL_CAMPO, VALOR_INT, ",");
		assertEquals(SALIDA.trim(), salida.trim());
	}

	@Test
	public void testAddSalidaStringStringDoubleString() {
		String salida = "";
		salida = MontadorSQL.addSalida(salida, NOMBRE_DEL_CAMPO, VALOR_DOUBLE, ",");
		assertEquals(SALIDA_DOS.trim(), salida.trim());
	}

	@Test
	public void testAddSalidaStringStringLongString() {
		String salida = "";
		salida = MontadorSQL.addSalida(salida, NOMBRE_DEL_CAMPO, VALOR_LONG, ",");
		assertEquals(SALIDA_TRES.trim(), salida.trim());
	}

	@Test
	public void testAddSalidaStringStringStringString() {
		String salida = "";
		salida = MontadorSQL.addSalida(salida, NOMBRE_DEL_CAMPO, VALOR_STRING, ",");
		assertEquals(SALIDA_CUATRO.trim(), salida.trim());
	}

	@Test
	void salidaLarga() {
		String salida = "";
		salida = MontadorSQL.addSalida(salida, NOMBRE_DEL_CAMPO, VALOR_INT, ",");
		salida = MontadorSQL.addSalida(salida, NOMBRE_DEL_CAMPO_DOS, VALOR_STRING, ",");
		assertEquals(SALIDA_CINCO.trim(), salida.trim());
	}

}
