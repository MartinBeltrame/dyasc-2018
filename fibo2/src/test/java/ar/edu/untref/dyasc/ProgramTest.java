package ar.edu.untref.dyasc;

import org.junit.Test;
import org.junit.Assert;

public class ProgramTest {

	@Test
	public void fibonacciDe0() {
		int resultado = Program.fibonacciDeUnNumero(0);
		Assert.assertEquals(0, resultado);
	}
	
	@Test
	public void fibonacciDe1() {
		int resultado = Program.fibonacciDeUnNumero(1);
		Assert.assertEquals(1, resultado);
	}
	
	@Test
	public void fibonacciDe2() {
		int resultado = Program.fibonacciDeUnNumero(2);
		Assert.assertEquals(1, resultado);
	}

	@Test
	public void fibonacciDe8() {
		int resultado = Program.fibonacciDeUnNumero(8);
		Assert.assertEquals(21, resultado);
	}
}
