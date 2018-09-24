package ar.edu.untref.dyasc.dominio;

public enum TipoArgumento {
	CONSOLA, ARCHIVO, CONSOLA_Y_ARCHIVO;

	public static TipoArgumento identificar(String variableDestino) {

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
