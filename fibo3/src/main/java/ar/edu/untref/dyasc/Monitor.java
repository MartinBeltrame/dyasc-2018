package ar.edu.untref.dyasc;

public class Monitor {

	/*
	 * Sin orientacion
	 */
	private static void mostrarSerieSinOrientacion(int numero) {
		System.out.print("fibo<" + numero + ">:");
		for (int i = 0; i < numero; i++) {
			int resultado = Funcion.fibonacciDeUnNumero(i);
			System.out.print(" " + resultado);
		}
	}

	/*
	 * Orientacion Horizontal e Invertida
	 */
	private static void mostrarConOrientacionHI(int numero) {

		int[] serieOriginal = new int[numero];
		System.out.print("fibo<" + numero + ">:");
		for (int i = 0; i < numero; i++) {
			int resultado = Funcion.fibonacciDeUnNumero(i);
			serieOriginal[i] = resultado;
		}

		int[] serieInvertida = Funcion.invertirSerie(serieOriginal);
		for (int i = 0; i < numero; i++) {
			System.out.print(" " + serieInvertida[i]);
		}
	}

	/*
	 * Orientacion Vertical e Invertida
	 */
	private static void mostrarConOrientacionVI(int numero) {

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

	/*
	 * Orientacion Horizontal y Directa
	 */
	private static void mostrarConOrientacionVD(int numero) {
		System.out.println("fibo<" + numero + ">:");
		for (int i = 0; i < numero; i++) {
			int resultado = Funcion.fibonacciDeUnNumero(i);
			System.out.println(resultado);
		}
	}

	public static void mostrarResultado(Integer numero, String opcion) {

		if (numero != null) {

			switch (opcion) {
			case "-o=vd":
				mostrarConOrientacionVD(numero);
				break;

			case "-o=hi":
				mostrarConOrientacionHI(numero);
				break;

			case "-o=vi":
				mostrarConOrientacionVI(numero);
				break;

			case "":
				mostrarSerieSinOrientacion(numero);
				break;

			default:
				System.out.print("Opciones no validas.");
				break;
			}
		}
	}
}
