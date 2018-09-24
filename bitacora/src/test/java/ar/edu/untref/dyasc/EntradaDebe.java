package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.entrada.Entrada;

public class EntradaDebe {

	private Entrada entrada;

	@Before
	public void inicializar() {
		entrada = new Entrada();
	}

	@Test
	public void devolver_el_texto_ingresado() {

		String resultado = entrada.leer();

		Assert.assertTrue(resultado != null);
	}
}
