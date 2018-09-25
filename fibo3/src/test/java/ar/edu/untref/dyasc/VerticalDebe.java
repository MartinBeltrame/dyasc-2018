package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.salida.Vertical;

public class VerticalDebe {

	private static final int[] SERIE_DE_CERO = { 0 };
	private static final int[] SERIE_DE_TRES = { 0, 1, 1, 2 };
	private static final int[] SERIE_DE_CINCO = { 0, 1, 1, 2, 3, 5, 8 };
	private Vertical vertical;

	@Before
	public void inicializar() {
		vertical = new Vertical();
	}

	@Test
	public void devolver_la_respuesta_en_formato_string_de_manera_vertical_para_el_numero_cero() {

		String obtenido = vertical.generarRespuesta(0, SERIE_DE_CERO);

		String esperado = "fibo<0>:\n"
				+ "0";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void devolver_la_respuesta_en_formato_string_de_manera_vertical_para_el_numero_tres() {

		String obtenido = vertical.generarRespuesta(3, SERIE_DE_TRES);

		String esperado = "fibo<3>:\n"
				+ "0\n"
				+ "1\n"
				+ "1\n"
				+ "2";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void devolver_la_respuesta_en_formato_string_de_manera_vertical_para_el_numero_cinco() {

		String obtenido = vertical.generarRespuesta(5, SERIE_DE_CINCO);

		String esperado = "fibo<5>:\n"
				+ "0\n"
				+ "1\n"
				+ "1\n"
				+ "2\n"
				+ "3\n"
				+ "5\n"
				+ "8";
		Assert.assertEquals(esperado, obtenido);
	}
}
