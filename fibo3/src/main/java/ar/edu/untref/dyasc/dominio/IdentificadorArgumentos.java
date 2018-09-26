package ar.edu.untref.dyasc.dominio;

import ar.edu.untref.dyasc.utilidades.Constantes;

public class IdentificadorArgumentos {

	public String[] identificar(String[] args) {

		int tamanio = args.length;
		String[] resultado = new String[2];

		String opcion = Constantes.OPCION_HD;
		String modo = Constantes.MODO_PANTALLA;

		if (tamanio == 2) {
			opcion = args[0];
		} else if (tamanio == 3) {
			opcion = args[0];
			if (args[1].equals(Constantes.SUMATORIA)) {
				opcion = args[0] + args[1];
			} else if (args[1].contains(Constantes.MODO_ARCHIVO)) {
				modo = Constantes.MODO_ARCHIVO;
			}
		} else if (tamanio == 4) {
			opcion = args[0];
			if (args[1].equals(Constantes.SUMATORIA)) {
				opcion = args[0] + args[2];
			}
			modo = Constantes.MODO_ARCHIVO;
		}

		resultado[0] = opcion;
		resultado[1] = modo;
		return resultado;
	}
}
