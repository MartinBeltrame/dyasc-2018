package ar.edu.untref.dyasc.dominio;

import ar.edu.untref.dyasc.salida.Archivo;
import ar.edu.untref.dyasc.salida.Consola;

public class Bitacora {

	private ServicioBitacora servicioBitacora;

	public Bitacora(ServicioBitacora servicioBitacora) {
		this.servicioBitacora = servicioBitacora;
	}

	public void registrarEvento(String argumento) {

		String variableDestino = argumento.substring(17, argumento.length());
		String resultado = servicioBitacora.obtenerResultado();
		
		TipoArgumento tipo = TipoArgumento.identificarTipo(variableDestino);

		switch (tipo) {
		case CONSOLA_Y_ARCHIVO:
			new Consola().registrar(resultado);

			String nombreArchivo = variableDestino.split(",")[0];
			new Archivo(nombreArchivo).registrar(resultado);
			break;

		case CONSOLA:
			new Consola().registrar(resultado);
			break;

		case ARCHIVO:
			new Archivo(variableDestino).registrar(resultado);
			break;
		}
	}
}
