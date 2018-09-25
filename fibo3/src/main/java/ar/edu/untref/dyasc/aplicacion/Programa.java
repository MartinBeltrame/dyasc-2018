package ar.edu.untref.dyasc.aplicacion;

import ar.edu.untref.dyasc.salida.Pantalla;

public class Programa {

	private static final String MODO_ARCHIVO = "-f=";
	private static final String MODO_FUNCIONAMIENTO = "-m=";

	public static void main(String[] args) {

		int tamanio = args.length;
		
		Pantalla monitor = new Pantalla();

		if (tamanio > 0 && tamanio <= 4) {

			Integer numero = Integer.valueOf(args[tamanio - 1]);

			if (tamanio == 1) {
				monitor.mostrarResultado(numero, "", "");
			} else if (tamanio == 2) {
				monitor.mostrarResultado(numero, args[0], "");
			} else {
				
				if (args[1].contains(MODO_FUNCIONAMIENTO)) {
					String opcion = args[0];
					String modo = args[1];
					monitor.mostrarResultadoConModo(numero, opcion, modo, "");
				} else if (args[1].contains(MODO_ARCHIVO)) {
					String opcion = args[0];
					String nombreArchivo = args[1];
					String modo = args[2];
					monitor.mostrarResultadoConModo(numero, opcion, modo, nombreArchivo);
				}
			}
		}
	}
}
