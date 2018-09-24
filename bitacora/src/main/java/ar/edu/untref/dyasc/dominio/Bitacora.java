package ar.edu.untref.dyasc.dominio;

import ar.edu.untref.dyasc.salida.Archivo;
import ar.edu.untref.dyasc.salida.Consola;

public class Bitacora {

	private ServicioBitacora servicioBitacora;

	public Bitacora(ServicioBitacora servicioBitacora) {
		this.servicioBitacora = servicioBitacora;
	}

	public void registrarEvento(String argumento) {

		String resultado = servicioBitacora.obtenerSalida();

		if (argumento.length() > 16) {

			String variableDestino = argumento.substring(17, argumento.length());
			TipoArgumento tipo = TipoArgumento.identificar(variableDestino);

			switch (tipo) {
			case CONSOLA_Y_ARCHIVO:
				new Consola().procesar(resultado);

				String nombreArchivo = variableDestino.split(",")[0];
				new Archivo(nombreArchivo).procesar(resultado);
				break;

			case CONSOLA:
				new Consola().procesar(resultado);
				break;

			case ARCHIVO:
				new Archivo(variableDestino).procesar(resultado);
				break;
			}
		} else {
			new Archivo().procesar(resultado);
		}
	}
}
