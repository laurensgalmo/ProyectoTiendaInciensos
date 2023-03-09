package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import es.rf.tienda.util.Validator;

class ValidatorTest {

	final String TEXTO_BUENO = "Laura Galvez Moya";
	final String TEXTO_MALO = "es0es un text! málo&";
	final String MOVIL_BUENO = "644545678";
	final String MOVIL_MALO = "01234567891011121314151617181920";
	final String EMAIL_BUENO = "test@gmail.com";
	final String DNI_BUENO = "12.111.111-A";
	final String DNI_MALO = "45464748Z";
	final String TEXTO_LONG_BUENO = "hhhhhhhhhhhhaaaahaha";
	final String TEXTO_LONG_MALO = "A";
	final String TEXTO_LONGMAX_BUENO = "10caracter";
	final String TEXTO_LONGMAX_MALO = "Esto supera la longitud maxima";
	final String PASS = "Laura@contraseña1";
	final String PASS_MALA = "lauracontrase ña";
	final LocalDate FECHA_BUENA = LocalDate.of(2023, 01, 26);
	final LocalDate FECHA_MIN = LocalDate.of(2020, 06, 26);
	final LocalDate FECHA_MAX = LocalDate.of(2023, 06, 27);
	final String FECHA_NO_VALIDA = "12-12-2020";
	final String FECHA2_NO_VALIDA = "2020-12-20";
	final String FECHA_VALIDA = "12/12/2020";
	final String CODIGO_BUENO = "IN325";
	final String CODIGO_MALO = "in325";
	final String CODIGO2_MALO = "INNN325";

	@Test
	void testCodigoProducto() {
		assertTrue(Validator.codigoProducto(CODIGO_BUENO));
		assertFalse(Validator.codigoProducto(CODIGO_MALO));
		assertFalse(Validator.codigoProducto(CODIGO2_MALO));
	}

	@Test
	void testIsAlfanumeric() {
		assertTrue(Validator.isAlfanumeric(TEXTO_BUENO));
		assertFalse(Validator.isAlfanumeric(TEXTO_MALO));
	}

	@Test
	void testCumplePhoneNumber() {
		assertTrue(Validator.cumplePhoneNumber(MOVIL_BUENO));
		assertFalse(Validator.cumplePhoneNumber(MOVIL_MALO));
	}

	@Test
	void testIsEmailValido() {
		assertTrue(Validator.isEmailValido(EMAIL_BUENO));
	}

	@Test
	void testCumpleDNI() {
		assertTrue(Validator.cumpleDNI(DNI_BUENO));
		assertFalse(Validator.cumpleDNI(DNI_MALO));
	}

	@Test
	void testCumpleRangoIntIntInt() {
		assertTrue(Validator.cumpleRango(12, 10, 19));
		assertFalse(Validator.cumpleRango(12, 12, 12));
		assertFalse(Validator.cumpleRango(12, 10, 1));
	}

	@Test
	void testCumpleRangoDoubleIntInt() {
		assertFalse(Validator.cumpleRango(20.12, 10, 19));
		assertFalse(Validator.cumpleRango(20.20, 21, 30));
		assertTrue(Validator.cumpleRango(20.20, 12, 30));
	}

	@Test
	void testCumpleLongitudMin() {
		assertTrue(Validator.cumpleLongitudMin(TEXTO_LONG_BUENO, 20));
		assertFalse(Validator.cumpleLongitudMin(TEXTO_LONG_MALO, 20));
	}

	@Test
	void testCumpleLongitudMax() {
		assertTrue(Validator.cumpleLongitudMax(TEXTO_LONGMAX_BUENO, 10));
		assertFalse(Validator.cumpleLongitudMax(TEXTO_LONGMAX_MALO, 3));
	}

	@Test
	void testCumpleLongitud() {
		assertFalse(Validator.cumpleLongitud(TEXTO_LONGMAX_BUENO, 16, 20));
		assertTrue(Validator.cumpleLongitud(TEXTO_LONGMAX_BUENO, 10, 20));
	}

	@Test
	void testValDateMin() {
		assertTrue(Validator.valDateMin(FECHA_BUENA, FECHA_MIN));
		assertFalse(Validator.valDateMin(FECHA_MIN, FECHA_BUENA));
	}

	@Test
	void testValDateMax() {
		assertTrue(Validator.valDateMax(FECHA_BUENA, FECHA_MAX));
		assertFalse(Validator.valDateMax(FECHA_MAX, FECHA_BUENA));
	}

	@Test
	void testEsFechaValida() {
		assertFalse(Validator.esFechaValida(FECHA_NO_VALIDA));
		assertFalse(Validator.esFechaValida(FECHA2_NO_VALIDA));
		assertTrue(Validator.esFechaValida(FECHA_VALIDA));
	}

	@Test
	void testEsPasswordValida() {
		assertTrue(Validator.esPasswordValida(PASS));
		assertFalse(Validator.esPasswordValida(PASS_MALA));
	}

}
