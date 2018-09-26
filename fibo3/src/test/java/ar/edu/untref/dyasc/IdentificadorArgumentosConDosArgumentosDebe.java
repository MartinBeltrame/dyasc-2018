package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.IdentificadorArgumentos;
import ar.edu.untref.dyasc.utilidades.Constantes;

public class IdentificadorArgumentosConDosArgumentosDebe {

	private String[] DOS_ARGUMENTOS_CON_OPCION_HD = new String[] { "-o=hd", "5" };
	private String[] DOS_ARGUMENTOS_CON_OPCION_HI = new String[] { "-o=hi", "5" };
	private String[] DOS_ARGUMENTOS_CON_OPCION_VD = new String[] { "-o=vd", "5" };
	private String[] DOS_ARGUMENTOS_CON_OPCION_VI = new String[] { "-o=vi", "5" };

	private IdentificadorArgumentos identificadorArgumentos;

	@Before
	public void inicializar() {
		identificadorArgumentos = new IdentificadorArgumentos();
	}

	@Test
	public void identificar_los_argumentos_con_opcion_horizontal_directa() {

		String[] resultado = identificadorArgumentos.identificar(DOS_ARGUMENTOS_CON_OPCION_HD);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_HD, opcion);
		Assert.assertEquals(Constantes.MODO_PANTALLA, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_horizontal_inversa() {

		String[] resultado = identificadorArgumentos.identificar(DOS_ARGUMENTOS_CON_OPCION_HI);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_HI, opcion);
		Assert.assertEquals(Constantes.MODO_PANTALLA, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_vertical_directa() {

		String[] resultado = identificadorArgumentos.identificar(DOS_ARGUMENTOS_CON_OPCION_VD);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_VD, opcion);
		Assert.assertEquals(Constantes.MODO_PANTALLA, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_vertical_inversa() {

		String[] resultado = identificadorArgumentos.identificar(DOS_ARGUMENTOS_CON_OPCION_VI);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_VI, opcion);
		Assert.assertEquals(Constantes.MODO_PANTALLA, modo);
	}
}
