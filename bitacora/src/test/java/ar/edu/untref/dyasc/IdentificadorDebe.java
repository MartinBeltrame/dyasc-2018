package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.dyasc.utilidades.Identificador;

public class IdentificadorDebe {

	@Test
	public void devolver_solo_el_nombre_del_archivo_cuando_el_tipo_de_argumento_es_archivo() {

		String obtenido = Identificador.obtenerVariableDestino("bitacora.destino=bitacora.txt");

		Assert.assertEquals("bitacora.txt", obtenido);
	}

	@Test
	public void devolver_solo_el_nombre_del_archivo_txt_cuando_el_tipo_de_argumento_es_archivo_consola() {

		String obtenido = Identificador.obtenerVariableDestino("bitacora.destino=bitacora.txt,CONSOLA");

		String esperado = "bitacora.txt";
		Assert.assertEquals(esperado, obtenido);
	}
}
