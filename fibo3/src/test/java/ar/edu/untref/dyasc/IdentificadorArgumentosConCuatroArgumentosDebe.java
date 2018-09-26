package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.IdentificadorArgumentos;
import ar.edu.untref.dyasc.utilidades.Constantes;

public class IdentificadorArgumentosConCuatroArgumentosDebe {

	// Modo sumatoria
	private String[] CUATRO_ARGUMENTOS_OPCION_HDS_Y_MODO_ARCHIVO = new String[] { "-o=hd", "-f=archivo.txt", "-m=s", "5" };
	private String[] CUATRO_ARGUMENTOS_OPCION_HIS_Y_MODO_ARCHIVO = new String[] { "-o=hi", "-f=archivo.txt", "-m=s", "5" };
	private String[] CUATRO_ARGUMENTOS_OPCION_VDS_Y_MODO_ARCHIVO = new String[] { "-o=vd", "-f=archivo.txt", "-m=s", "5" };
	private String[] CUATRO_ARGUMENTOS_OPCION_VIS_Y_MODO_ARCHIVO = new String[] { "-o=vi", "-f=archivo.txt", "-m=s", "5" };

	// Modo lista
	private String[] CUATRO_ARGUMENTOS_OPCION_HDL_Y_MODO_ARCHIVO = new String[] { "-o=hd", "-f=archivo.txt", "-m=l", "5" };
	private String[] CUATRO_ARGUMENTOS_OPCION_HIL_Y_MODO_ARCHIVO = new String[] { "-o=hi", "-f=archivo.txt", "-m=l", "5" };
	private String[] CUATRO_ARGUMENTOS_OPCION_VDL_Y_MODO_ARCHIVO = new String[] { "-o=vd", "-f=archivo.txt", "-m=l", "5" };
	private String[] CUATRO_ARGUMENTOS_OPCION_VIL_Y_MODO_ARCHIVO = new String[] { "-o=vi", "-f=archivo.txt", "-m=l", "5" };

	private IdentificadorArgumentos identificadorArgumentos;

	@Before
	public void inicializar() {
		identificadorArgumentos = new IdentificadorArgumentos();
	}

	@Test
	public void identificar_los_argumentos_con_opcion_horizontal_directa_y_sumatoria_en_modo_archivo() {

		String[] resultado = identificadorArgumentos.identificar(CUATRO_ARGUMENTOS_OPCION_HDS_Y_MODO_ARCHIVO);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_HDS, opcion);
		Assert.assertEquals(Constantes.MODO_ARCHIVO, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_horizontal_inversa_y_sumatoria_en_modo_archivo() {

		String[] resultado = identificadorArgumentos.identificar(CUATRO_ARGUMENTOS_OPCION_HIS_Y_MODO_ARCHIVO);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_HIS, opcion);
		Assert.assertEquals(Constantes.MODO_ARCHIVO, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_vertical_directa_y_sumatoria_en_modo_archivo() {

		String[] resultado = identificadorArgumentos.identificar(CUATRO_ARGUMENTOS_OPCION_VDS_Y_MODO_ARCHIVO);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_VDS, opcion);
		Assert.assertEquals(Constantes.MODO_ARCHIVO, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_vertical_inversa_y_sumatoria_en_modo_archivo() {

		String[] resultado = identificadorArgumentos.identificar(CUATRO_ARGUMENTOS_OPCION_VIS_Y_MODO_ARCHIVO);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_VIS, opcion);
		Assert.assertEquals(Constantes.MODO_ARCHIVO, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_horizontal_directa_modo_lista_y_modo_archivo() {

		String[] resultado = identificadorArgumentos.identificar(CUATRO_ARGUMENTOS_OPCION_HDL_Y_MODO_ARCHIVO);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_HD, opcion);
		Assert.assertEquals(Constantes.MODO_ARCHIVO, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_horizontal_inversa_modo_lista_y_modo_archivo() {

		String[] resultado = identificadorArgumentos.identificar(CUATRO_ARGUMENTOS_OPCION_HIL_Y_MODO_ARCHIVO);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_HI, opcion);
		Assert.assertEquals(Constantes.MODO_ARCHIVO, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_vertical_directa_modo_lista_y_modo_archivo() {

		String[] resultado = identificadorArgumentos.identificar(CUATRO_ARGUMENTOS_OPCION_VDL_Y_MODO_ARCHIVO);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_VD, opcion);
		Assert.assertEquals(Constantes.MODO_ARCHIVO, modo);
	}

	@Test
	public void identificar_los_argumentos_con_opcion_vertical_inversa_modo_lista_y_modo_archivo() {

		String[] resultado = identificadorArgumentos.identificar(CUATRO_ARGUMENTOS_OPCION_VIL_Y_MODO_ARCHIVO);
		String opcion = resultado[0];
		String modo = resultado[1];

		Assert.assertEquals(Constantes.OPCION_VI, opcion);
		Assert.assertEquals(Constantes.MODO_ARCHIVO, modo);
	}
}
