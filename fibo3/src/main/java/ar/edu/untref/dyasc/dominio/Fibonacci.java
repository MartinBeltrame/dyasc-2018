package ar.edu.untref.dyasc.dominio;

public class Fibonacci {

	public int fibonacciDe(int numero) {

		if (numero <= 0) {
			return 0;
		} else if (numero == 1) {
			return 1;
		} else {
			return fibonacciDe(numero - 1) + fibonacciDe(numero - 2);
		}
	}

	public int[] serieDe(int numero) {

		int[] serie = null;
		
		if (numero > 0) {
			serie = new int[numero + 1];

			for (int i = 0; i <= numero; i++) {
				serie[i] = fibonacciDe(i);
			}
		} else {
			serie = new int[1];
		}

		return serie;
	}
}
