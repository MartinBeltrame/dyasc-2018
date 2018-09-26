package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.IdentificadorArgumentos;
import ar.edu.untref.dyasc.utilidades.Constantes;

public class IdentificadorArgumentosConTresArgumentosDebe {

	// Modo sumatoria
	private String[] TRES_ARGUMENTOS_CON_OPCION_HDS = new String[] { "-o=hd", "-m=s", "5" };
	private String[] TRES_ARGUMENTOS_CON_OPCION_HIS = new String[] { "-o=hi", "-m=s", "5" };
	private String[] TRES_ARGUMENTOS_CON_OPCION_VDS = new String[] { "-o=vd", "-m=s", "5" };
	private String[] TRES_ARGUMENTOS_CON_OPCION_VIS = new String[] { "-o=vi", "-m=s", "5" };

	// Modo lista
	private String[] TRES_ARGUMENTOS_CON_OPCION_HDL = new String[] { "-o=hd", "-m=l", "5" };
	private String[] TRES_ARGUMENTOS_CON_OPCION_HIL = new String[] { "-o=hi", "-m=l", "5" };
	private String[] TRES_ARGUMENTOS_CON_OPCION_VDL = new String[] { "-o=vd", "-m=l", "5" };
	private String[] TRES_ARGUMENTOS_CON_OPCION_VIL = new String[] { "-o=vi", "-m=l", "5" };

	// Modo archivo
	private String[] TRES_ARGUMENTOS_CON_OPCION_HD_Y_MODO_ARCHIVO = new String[] { "-o=hd", "-f=archivo.txt", "5" };
	private String[] TRES_ARGUMENTOS_CON_OPCION_HI_Y_MODO_ARCHIVO = new String[] { "-o=hi", "-f=archivo.txt", "5" };
	private String[] TRES_ARGUMENTOS_CON_OPCION_VD_Y_MODO_ARCHIVO = new String[] { "-o=vd", "-f=archivo.txt", "5" };
	private String[] TRES_ARGUMENTOS_CON_OPCION_VI_Y_MODO_ARCHIVO = new String[] { "-o=vi", "-f=archivo.txt", "5" };

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

	public void identificar_los_argumentos_con_opcion_horizontal_directa_y_modo_lista() {

		String[] resultado = identificadorArgumentos.identificar(TRES_ARGUMENTOS_CON_OPCION_HDL);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_HD, opcion);
		Assert.assertEquals(Constantes.MODO_PANTALLA, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_horizontal_inversa_y_modo_lista() {

		String[] resultado = identificadorArgumentos.identificar(TRES_ARGUMENTOS_CON_OPCION_HIL);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_HI, opcion);
		Assert.assertEquals(Constantes.MODO_PANTALLA, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_vertical_directa_y_modo_lista() {

		String[] resultado = identificadorArgumentos.identificar(TRES_ARGUMENTOS_CON_OPCION_VDL);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_VD, opcion);
		Assert.assertEquals(Constantes.MODO_PANTALLA, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_vertical_inversa_y_modo_lista() {

		String[] resultado = identificadorArgumentos.identificar(TRES_ARGUMENTOS_CON_OPCION_VIL);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_VI, opcion);
		Assert.assertEquals(Constantes.MODO_PANTALLA, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_horizontal_directa_y_modo_archivo() {

		String[] resultado = identificadorArgumentos.identificar(TRES_ARGUMENTOS_CON_OPCION_HD_Y_MODO_ARCHIVO);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_HD, opcion);
		Assert.assertEquals(Constantes.MODO_ARCHIVO, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_horizontal_inversa_y_modo_archivo() {

		String[] resultado = identificadorArgumentos.identificar(TRES_ARGUMENTOS_CON_OPCION_HI_Y_MODO_ARCHIVO);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_HI, opcion);
		Assert.assertEquals(Constantes.MODO_ARCHIVO, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_vertical_directa_y_modo_archivo() {

		String[] resultado = identificadorArgumentos.identificar(TRES_ARGUMENTOS_CON_OPCION_VD_Y_MODO_ARCHIVO);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_VD, opcion);
		Assert.assertEquals(Constantes.MODO_ARCHIVO, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_vertical_inversa_y_modo_archivo() {

		String[] resultado = identificadorArgumentos.identificar(TRES_ARGUMENTOS_CON_OPCION_VI_Y_MODO_ARCHIVO);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_VI, opcion);
		Assert.assertEquals(Constantes.MODO_ARCHIVO, modo);
	}
}
