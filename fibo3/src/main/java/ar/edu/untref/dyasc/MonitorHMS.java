package ar.edu.untref.dyasc;

import ar.edu.untref.dyac.interfaces.IMonitor;

public class MonitorHMS implements IMonitor {

	@Override
	public void mostrar(int numero) {

		int[] serieOriginal = new int[numero];
		System.out.print("fibo<" + numero + ">:s ");
		for (int i = 0; i < numero; i++) {
			int resultado = Funciones.fibonacciDeUnNumero(i);
			serieOriginal[i] = resultado;
		}

		int sumatoria = Funciones.sumatoria(serieOriginal);
		System.out.print(sumatoria);
	}
}