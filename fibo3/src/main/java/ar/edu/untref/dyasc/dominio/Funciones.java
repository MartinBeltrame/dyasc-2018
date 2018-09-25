package ar.edu.untref.dyasc.dominio;

public class Funciones {

	public static int[] invertirSerie(int[] serie) {

		int[] resultado = new int[serie.length];

		for (int i = 0; i < serie.length; i++) {
			resultado[i] = serie[serie.length - i - 1];
		}
		return resultado;
	}

	public static int sumatoria(int[] serie) {

		int resultado = 0;

		for (int i = 0; i < serie.length; i++) {
			resultado += serie[i];
		}
		return resultado;
	}
}
