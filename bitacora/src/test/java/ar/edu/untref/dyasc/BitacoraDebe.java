package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BitacoraDebe {

	private Bitacora bitacora;

	@Before
	public void inicializar() {
		bitacora = new Bitacora();
	}

	@Test
	public void agregar_un_nuevo_evento_a_la_bitacora() {

		bitacora.agregarEvento("Evento 1");

		Assert.assertTrue(!bitacora.getRegistro().isEmpty());
	}
}
