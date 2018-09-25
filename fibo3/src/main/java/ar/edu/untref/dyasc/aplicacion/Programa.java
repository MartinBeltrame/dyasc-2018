package ar.edu.untref.dyasc.aplicacion;

import ar.edu.untref.dyasc.dominio.ServicioFibonacci;
import ar.edu.untref.dyasc.utilidades.Constantes;

public class Programa {

	public static void main(String[] args) {

		int tamanio = args.length;

		if (tamanio > 0 && tamanio <= 4) {

			Integer numero = Integer.valueOf(args[tamanio - 1]);

			ServicioFibonacci servicioFibonacci = new ServicioFibonacci();

			if (tamanio == 1) {
				String respuesta = servicioFibonacci.obtenerRespuesta(Constantes.OPCION_HD, numero);
				servicioFibonacci.generarSalida(Constantes.MODO_PANTALLA, respuesta);
			} else if (tamanio == 2) {
				String opcion = args[0];

				String respuesta = servicioFibonacci.obtenerRespuesta(opcion, numero);
				servicioFibonacci.generarSalida(Constantes.MODO_PANTALLA, respuesta);
			} else {

				String opcion = args[0];

				if (args[1].contains(Constantes.MODO_SUMATORIA)) {
					String modo = args[1];
					// java -jar fibo.jar -o=vd -f=salida.txt -m=s 5

				} else if (args[1].contains(Constantes.MODO_ARCHIVO)) {
					String nombreArchivo = args[1];
					String modo = args[2];
					// java -jar fibo.jar -o=vd -f=salida.txt -m=s 5

				}
			}
		}
	}
}
