package ar.edu.untref.dyasc.utilidades;

public class FormateadorVariable {

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
}
