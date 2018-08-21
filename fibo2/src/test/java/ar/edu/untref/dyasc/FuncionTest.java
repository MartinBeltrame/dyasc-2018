package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class FuncionTest {

	@Test
	public void fibonacciDe0() {
		int resultado = Funcion.fibonacciDeUnNumero(0);
		Assert.assertEquals(0, resultado);
	}

	@Test
	public void fibonacciDe1() {
		int resultado = Funcion.fibonacciDeUnNumero(1);
		Assert.assertEquals(1, resultado);
	}

	@Test
	public void fibonacciDe2() {
		int resultado = Funcion.fibonacciDeUnNumero(2);
		Assert.assertEquals(1, resultado);
	}

	@Test
	public void fibonacciDe8() {
		int resultado = Funcion.fibonacciDeUnNumero(8);
		Assert.assertEquals(21, resultado);
	}

	@Test
	public void invertirUnaSerieDeNumeros() {
		int[] original = { 0, 1, 1, 2, 3 };
		int[] resultado = Funcion.invertirSerie(original);
		int[] esperado = { 3, 2, 1, 1, 0 };
		Assert.assertArrayEquals(esperado, resultado);
	}
}
