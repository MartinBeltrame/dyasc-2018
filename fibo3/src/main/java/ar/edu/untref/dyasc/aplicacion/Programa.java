package ar.edu.untref.dyasc.aplicacion;

import ar.edu.untref.dyasc.dominio.IdentificadorArgumentos;
import ar.edu.untref.dyasc.dominio.ServicioFibonacci;

public class Programa {

	public static void main(String[] args) {

		int tamanio = args.length;

		if (tamanio > 0 && tamanio <= 4) {

			Integer numero = Integer.valueOf(args[tamanio - 1]);

			ServicioFibonacci servicioFibonacci = new ServicioFibonacci();
			IdentificadorArgumentos identificadorArgumentos = new IdentificadorArgumentos();

			String[] argumentos = identificadorArgumentos.identificar(args);
			String opcion = argumentos[0];
			String modo = argumentos[1];

			String respuesta = servicioFibonacci.obtenerRespuesta(opcion, numero);
			servicioFibonacci.generarSalida(modo, respuesta);
		}
	}
}
