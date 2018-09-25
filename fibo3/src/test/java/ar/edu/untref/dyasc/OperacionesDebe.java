package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Operaciones;

public class OperacionesDebe {

	private int[] SERIE_DE_CERO = { 0 };
	private int[] SERIE_DE_DOS = { 0, 1, 1 };
	private int[] SERIE_DE_TRES = { 0, 1, 1, 2 };
	private int[] SERIE_DE_CINCO = { 0, 1, 1, 2, 3, 5, 8 };

	private Operaciones operaciones;

	@Before
	public void inicializar() {
		operaciones = new Operaciones();
	}

	@Test
	public void devolver_un_array_con_el_valor_cero_para_la_serie_invertida_de_cero() {

		int[] obtenido = operaciones.invertirSerie(SERIE_DE_CERO);

		int[] esperado = { 0 };
		Assert.assertArrayEquals(esperado, obtenido);
	}

	@Test
	public void devolver_un_array_con_los_valores_invertidos_de_la_serie_de_dos() {

		int[] obtenido = operaciones.invertirSerie(SERIE_DE_DOS);

		int[] esperado = { 1, 1, 0 };
		Assert.assertArrayEquals(esperado, obtenido);
	}

	@Test
	public void devolver_un_array_con_los_valores_invertidos_de_la_serie_de_cinco() {

		int[] obtenido = operaciones.invertirSerie(SERIE_DE_CINCO);

		int[] esperado = { 8, 5, 3, 2, 1, 1, 0 };
		Assert.assertArrayEquals(esperado, obtenido);
	}

	@Test
	public void devolver_la_sumatoria_de_la_serie_de_cero() {

		int obtenido = operaciones.sumatoria(SERIE_DE_CERO);

		Assert.assertEquals(0, obtenido);
	}

	@Test
	public void devolver_la_sumatoria_de_la_serie_de_tres() {

		int obtenido = operaciones.sumatoria(SERIE_DE_TRES);

		Assert.assertEquals(4, obtenido);
	}
	
	@Test
	public void devolver_la_sumatoria_de_la_serie_de_cinco() {

		int obtenido = operaciones.sumatoria(SERIE_DE_CINCO);

		Assert.assertEquals(20, obtenido);
	}
}
