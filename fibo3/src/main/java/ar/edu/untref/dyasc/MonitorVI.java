package ar.edu.untref.dyasc;

import ar.edu.untref.dyac.interfaces.IMonitor;

public class MonitorVI implements IMonitor {

	@Override
	public void mostrar(int numero) {
		
		int[] serieOriginal = new int[numero];
		System.out.println("fibo<" + numero + ">:");
		for (int i = 0; i < numero; i++) {
			int resultado = Funcion.fibonacciDeUnNumero(i);
			serieOriginal[i] = resultado;
		}

		int[] serieInvertida = Funcion.invertirSerie(serieOriginal);
		for (int i = 0; i < numero; i++) {
			System.out.println(" " + serieInvertida[i]);
		}
	}
}
