package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.IdentificadorArgumentos;
import ar.edu.untref.dyasc.utilidades.Constantes;

public class IdentificadorArgumentosConTresArgumentosDebe {

	private String[] TRES_ARGUMENTOS_CON_OPCION_HDS = new String[] { "-o=hd", "-m=s", "5" };
	private String[] TRES_ARGUMENTOS_CON_OPCION_HIS = new String[] { "-o=hi", "-m=s", "5" };
	private String[] TRES_ARGUMENTOS_CON_OPCION_VDS = new String[] { "-o=vd", "-m=s", "5" };
	private String[] TRES_ARGUMENTOS_CON_OPCION_VIS = new String[] { "-o=vi", "-m=s", "5" };

	private IdentificadorArgumentos identificadorArgumentos;

	@Before
	public void inicializar() {
		identificadorArgumentos = new IdentificadorArgumentos();
	}

	@Test
	public void identificar_los_argumentos_con_opcion_horizontal_directa_y_sumatoria() {

		String[] resultado = identificadorArgumentos.identificar(TRES_ARGUMENTOS_CON_OPCION_HDS);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_HDS, opcion);
		Assert.assertEquals(Constantes.MODO_PANTALLA, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_horizontal_inversa_y_sumatoria() {

		String[] resultado = identificadorArgumentos.identificar(TRES_ARGUMENTOS_CON_OPCION_HIS);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_HIS, opcion);
		Assert.assertEquals(Constantes.MODO_PANTALLA, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_vertical_directa_y_sumatoria() {

		String[] resultado = identificadorArgumentos.identificar(TRES_ARGUMENTOS_CON_OPCION_VDS);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_VDS, opcion);
		Assert.assertEquals(Constantes.MODO_PANTALLA, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_vertical_inversa_y_sumatoria() {

		String[] resultado = identificadorArgumentos.identificar(TRES_ARGUMENTOS_CON_OPCION_VIS);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_VIS, opcion);
		Assert.assertEquals(Constantes.MODO_PANTALLA, modo);
	}
}
