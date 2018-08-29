package ar.edu.untref.dyasc;

import ar.edu.untref.dyac.interfaces.IMonitor;

public class MonitorHD implements IMonitor {

	private String respuesta;

	@Override
	public void construirRespuesta(int numero) {

		respuesta = "fibo<" + numero + ">:";

		for (int i = 0; i < numero; i++) {
			int resultado = Funciones.fibonacciDeUnNumero(i);
			respuesta += " " + resultado;
		}
	}

	@Override
	public void mostrar(int numero, String nombreArchivo) {
		construirRespuesta(numero);
		if (nombreArchivo == "") {
			System.out.print(respuesta);
		} else {
			EscritorArchivos.escribir(respuesta, nombreArchivo);
			System.out.print("fibo<" + numero + "> guardado en " + nombreArchivo);
		}
	}
}
