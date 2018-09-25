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
				String opcion = Constantes.OPCION_HD;
				String respuesta = servicioFibonacci.obtenerRespuesta(opcion, numero);
				servicioFibonacci.generarSalida(Constantes.MODO_PANTALLA, respuesta);
			} else if (tamanio == 2) {
				String opcion = args[0];

				String respuesta = servicioFibonacci.obtenerRespuesta(opcion, numero);
				servicioFibonacci.generarSalida(Constantes.MODO_PANTALLA, respuesta);
			} else if (tamanio == 3) {

				String opcion = args[0] + args[1];

				String respuesta = servicioFibonacci.obtenerRespuesta(opcion, numero);
				servicioFibonacci.generarSalida(Constantes.MODO_PANTALLA, respuesta);

				// java -jar fibo.jar -o=hd -m=s 5
			}
		}
	}
}
