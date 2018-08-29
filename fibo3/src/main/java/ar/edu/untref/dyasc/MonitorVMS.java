package ar.edu.untref.dyasc;

import ar.edu.untref.dyac.interfaces.IMonitor;

public class MonitorVMS implements IMonitor {

	private String respuesta;

	@Override
	public void mostrar(int numero) {

		int[] serieOriginal = new int[numero];
		respuesta = "fibo<" + numero + ">:s";

		for (int i = 0; i < numero; i++) {
			int resultado = Funciones.fibonacciDeUnNumero(i);
			serieOriginal[i] = resultado;
		}

		int sumatoria = Funciones.sumatoria(serieOriginal);
		respuesta += sumatoria;

		System.out.print(respuesta);
	}

	@Override
	public String getRespuesta() {
		return respuesta;
	}
}
