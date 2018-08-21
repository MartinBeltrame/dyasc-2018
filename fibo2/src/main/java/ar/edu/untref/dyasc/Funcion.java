package ar.edu.untref.dyasc;

public class Funcion {

	public static int fibonacciDeUnNumero(int numero) {
		if (numero <= 0) {
			return 0;
		} else if (numero == 1) {
			return 1;
		} else {
			return fibonacciDeUnNumero(numero - 1) + fibonacciDeUnNumero(numero - 2);
		}
	}

	public static int[] invertirSerie(int[] serie) {

		int[] resultado = new int[serie.length];

		for (int i = 0; i < serie.length; i++) {
			resultado[i] = serie[serie.length - i - 1];
		}
		return resultado;
	}
}
