package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.IdentificadorArgumentos;
import ar.edu.untref.dyasc.utilidades.Constantes;

public class IndentificadorArgumentosConUnArgumentoDebe {

	private String[] UN_ARGUMENTOS = new String[] { "5" };

	private IdentificadorArgumentos identificadorArgumentos;

	@Before
	public void inicializar() {
		identificadorArgumentos = new IdentificadorArgumentos();
	}

	@Test
	public void identificar_los_argumentos_con_opcion_horizontal_directa() {

		String[] resultado = identificadorArgumentos.identificar(UN_ARGUMENTOS);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_HD, opcion);
		Assert.assertEquals(Constantes.MODO_PANTALLA, modo);
	}
}
