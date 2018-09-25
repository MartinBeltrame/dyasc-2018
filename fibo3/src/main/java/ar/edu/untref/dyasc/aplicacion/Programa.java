package ar.edu.untref.dyasc.aplicacion;

import ar.edu.untref.dyasc.dominio.ServicioFibonacci;
import ar.edu.untref.dyasc.utilidades.Constantes;

public class Programa {

	public static void main(String[] args) {

		int tamanio = args.length;

		if (tamanio > 0 && tamanio <= 4) {

			Integer numero = Integer.valueOf(args[tamanio - 1]);

			ServicioFibonacci servicioFibonacci = new ServicioFibonacci();

			String opcion = Constantes.OPCION_HD;
			String modo = Constantes.MODO_PANTALLA;

			switch (tamanio) {
				case 2:
					opcion = args[0];
					break;
				case 3:
					opcion = args[0];
					if (args[1].equals(Constantes.SUMATORIA)) {
						opcion = args[0] + args[1];
					} else if (args[1].contains(Constantes.MODO_ARCHIVO)) {
						modo = Constantes.MODO_ARCHIVO;
					}
					break;
				case 4:
					opcion = args[0];
					if (args[1].equals(Constantes.SUMATORIA)) {
						opcion = args[0] + args[2];
					}
					modo = Constantes.MODO_ARCHIVO;
					break;
			}

			String respuesta = servicioFibonacci.obtenerRespuesta(opcion, numero);
			servicioFibonacci.generarSalida(modo, respuesta);
		}
	}
}
