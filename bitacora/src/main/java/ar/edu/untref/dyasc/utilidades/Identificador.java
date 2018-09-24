package ar.edu.untref.dyasc.utilidades;

import ar.edu.untref.dyasc.dominio.TipoArgumento;

public class Identificador {

	public static String obtenerVariableDestino(String argumento) {

		String resultado;

		if (argumento.length() > 16) {
			resultado = argumento.substring(17, argumento.length());
			if (resultado.contains(",")) {
				resultado = resultado.split(",")[0];
			}
		} else {
			resultado = "";
		}
		return resultado;
	}

	public static TipoArgumento obtenerTipoArgumento(String variableDestino) {

		if (variableDestino.contains(",")) {
			return TipoArgumento.CONSOLA_Y_ARCHIVO;
		} else {
			if (variableDestino.contains("CONSOLA")) {
				return TipoArgumento.CONSOLA;
			} else {
				return TipoArgumento.ARCHIVO;
			}
		}
	}
}
