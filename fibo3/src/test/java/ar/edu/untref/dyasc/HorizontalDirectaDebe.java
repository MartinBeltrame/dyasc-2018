package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.salida.HorizontalDirecta;

public class HorizontalDirectaDebe {

	private static final int[] SERIE_DE_CERO = { 0 };
	private static final int[] SERIE_DE_TRES = { 0, 1, 1, 2 };
	private static final int[] SERIE_DE_CINCO = { 0, 1, 1, 2, 3, 5, 8 };
	private HorizontalDirecta horizontalDirecta;

	@Before
	public void inicializar() {
		horizontalDirecta = new HorizontalDirecta();
	}

	@Test
	public void devolver_la_respuesta_en_formato_string_de_manera_horizontal_para_el_numero_cero() {

		String obtenido = horizontalDirecta.generarRespuesta(0, SERIE_DE_CERO);

		String esperado = "fibo<0>: 0";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void devolver_la_respuesta_en_formato_string_de_manera_horizontal_para_el_numero_tres() {

		String obtenido = horizontalDirecta.generarRespuesta(3, SERIE_DE_TRES);

		String esperado = "fibo<3>: 0 1 1 2";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void devolver_la_respuesta_en_formato_string_de_manera_horizontal_para_el_numero_cinco() {

		String obtenido = horizontalDirecta.generarRespuesta(5, SERIE_DE_CINCO);

		String esperado = "fibo<5>: 0 1 1 2 3 5 8";
		Assert.assertEquals(esperado, obtenido);
	}
}
