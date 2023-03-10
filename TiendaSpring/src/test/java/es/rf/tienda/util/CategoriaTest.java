package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CategoriaTest {

	final String NOMBRE_BUENO = "inciensoRosas";
	final String NOMBRE_DOS_BUENO = "inciensoRosas inciensoRosasinciensoRosas";
	final String NOMBRE_MALO = "inciensoderosas~~";
	final String NOMBRE_DOS_MALO = "inciensoRosasinciensoRosasinciensoRosasinciensoRosasinciensoRosasinciensoRosasinciensoRosasinciensoRosasinciensoRosas";
	final String DESCRIPCION_BUENA = "incie nso";
	final String DESCRIPCION_DOS_BUENA = "EstoTambienEsUnaDescripcion10";
	final String DESCRIPCION_MALA = "Esto no es alfanumérico";
	final String DESCRIPCION_DOS_MALA = "EstoTampoco$";

	@Test
	void testNombreCategoria() {
		assertTrue(CategoriaUtil.nombreAlfanumerico(NOMBRE_BUENO));
		assertTrue(CategoriaUtil.nombreAlfanumerico(NOMBRE_DOS_BUENO));
		assertFalse(CategoriaUtil.nombreAlfanumerico(NOMBRE_MALO));
		assertFalse(CategoriaUtil.nombreAlfanumerico(NOMBRE_DOS_MALO));
	}

	@Test
	void testDescripcionCategoria() {
		assertTrue(CategoriaUtil.descAlfanumerico(DESCRIPCION_BUENA));
		assertTrue(CategoriaUtil.descAlfanumerico(DESCRIPCION_DOS_BUENA));
		assertFalse(CategoriaUtil.descAlfanumerico(DESCRIPCION_MALA));
		assertFalse(CategoriaUtil.descAlfanumerico(DESCRIPCION_DOS_MALA));
	}
}
