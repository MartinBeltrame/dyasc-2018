package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Fibonacci;

public class FibonacciDebe {

	private Fibonacci fibonacci;

	@Before()
	public void inicializar() {
		fibonacci = new Fibonacci();
	}

	@Test
	public void devolver_cero_para_cero() {

		int resultado = fibonacci.fibonacciDe(0);

		Assert.assertEquals(0, resultado);
	}

	@Test
	public void devolver_uno_para_uno() {

		int resultado = fibonacci.fibonacciDe(1);

		Assert.assertEquals(1, resultado);
	}

	@Test
	public void devolver_dos_para_tres() {

		int resultado = fibonacci.fibonacciDe(3);

		Assert.assertEquals(2, resultado);
	}

	@Test
	public void devolver_cinco_para_cinco() {

		int resultado = fibonacci.fibonacciDe(5);

		Assert.assertEquals(5, resultado);
	}

	@Test
	public void devolver_la_serie_de_cero() {

		int[] obtenido = fibonacci.serieDe(0);

		int[] esperado = { 0 };
		Assert.assertArrayEquals(esperado, obtenido);
	}

	@Test
	public void devolver_la_serie_de_2() {

		int[] obtenido = fibonacci.serieDe(2);

		int[] esperado = { 0, 1 };
		Assert.assertArrayEquals(esperado, obtenido);
	}

	@Test
	public void devolver_la_serie_de_5() {

		int[] obtenido = fibonacci.serieDe(5);

		int[] esperado = { 0, 1, 1, 2, 3 };
		Assert.assertArrayEquals(esperado, obtenido);
	}
}
