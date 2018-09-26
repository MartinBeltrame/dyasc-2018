package ar.edu.untref.dyasc.dominio;

import ar.edu.untref.dyasc.utilidades.Constantes;

public class IdentificadorArgumentos {

	private static final String SALIDA = "salida.txt";

	public String[] identificar(String[] args) {

		int cantidad = args.length;
		String[] resultado = new String[3];

		String opcion = Constantes.OPCION_HD;
		String modo = Constantes.MODO_PANTALLA;
		String nombreArchivo = SALIDA;

		if (cantidad == 2) {
			opcion = args[0];
		} else if (cantidad == 3) {
			opcion = args[0];
			if (args[1].equals(Constantes.SUMATORIA)) {
				opcion = args[0] + args[1];
			} else if (args[1].contains(Constantes.MODO_ARCHIVO)) {
				modo = Constantes.MODO_ARCHIVO;
				nombreArchivo = args[1].split("=")[1];
			}
		} else if (cantidad == 4) {
			opcion = args[0];
			if (args[2].equals(Constantes.SUMATORIA)) {
				opcion = args[0] + args[2];
			}
			modo = Constantes.MODO_ARCHIVO;
			nombreArchivo = args[1].split("=")[1];
		}

		resultado[0] = opcion;
		resultado[1] = modo;
		resultado[2] = nombreArchivo;
		return resultado;
	}
}
