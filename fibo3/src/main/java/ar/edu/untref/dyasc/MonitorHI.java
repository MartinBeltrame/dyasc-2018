package ar.edu.untref.dyasc;

import ar.edu.untref.dyac.interfaces.IMonitor;

public class MonitorHI implements IMonitor {

	@Override
	public void mostrar(int numero) {
		int[] serieOriginal = new int[numero];
		System.out.print("fibo<" + numero + ">:");
		for (int i = 0; i < numero; i++) {
			int resultado = Funciones.fibonacciDeUnNumero(i);
			serieOriginal[i] = resultado;
		}

		int[] serieInvertida = Funciones.invertirSerie(serieOriginal);
		for (int i = 0; i < numero; i++) {
			System.out.print(" " + serieInvertida[i]);
		}
	}
}
