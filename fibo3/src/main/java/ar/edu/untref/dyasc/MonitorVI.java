package ar.edu.untref.dyasc;

import ar.edu.untref.dyac.interfaces.IMonitor;

public class MonitorVI implements IMonitor {

	private String respuesta;

	@Override
	public void mostrar(int numero) {

		int[] serieOriginal = new int[numero];
		respuesta = "fibo<" + numero + ">:";

		for (int i = 0; i < numero; i++) {
			int resultado = Funciones.fibonacciDeUnNumero(i);
			serieOriginal[i] = resultado;
		}

		int[] serieInvertida = Funciones.invertirSerie(serieOriginal);
		for (int i = 0; i < numero; i++) {
			respuesta += "\n" + serieInvertida[i];
		}

		System.out.print(respuesta);
	}

	@Override
	public String getRespuesta() {
		return respuesta;
	}
}
