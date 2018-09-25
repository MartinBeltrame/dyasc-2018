package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Operaciones;

public class OperacionesDebe {

	private Operaciones operaciones;

	@Before
	public void inicializar() {
		operaciones = new Operaciones();
	}

	@Test
	public void devolver_un_array_con_el_valor_cero_para_la_serie_invertida_de_cero() {

		int[] serieDeCero = new int[1];

		int[] obtenido = operaciones.invertirSerie(serieDeCero);

		int[] esperado = { 0 };
		Assert.assertArrayEquals(esperado, obtenido);
	}

	@Test
	public void devolver_un_array_con_los_valores_invertidos_de_la_serie_de_dos() {

		int[] serieDeCero = { 0, 1, 1 };

		int[] obtenido = operaciones.invertirSerie(serieDeCero);

		int[] esperado = { 1, 1, 0 };
		Assert.assertArrayEquals(esperado, obtenido);
	}

	@Test
	public void devolver_un_array_con_los_valores_invertidos_de_la_serie_de_cinco() {

		int[] serieDeCero = { 0, 1, 1, 2, 3, 5, 8 };

		int[] obtenido = operaciones.invertirSerie(serieDeCero);

		int[] esperado = { 8, 5, 3, 2, 1, 1, 0 };
		Assert.assertArrayEquals(esperado, obtenido);
	}

}
