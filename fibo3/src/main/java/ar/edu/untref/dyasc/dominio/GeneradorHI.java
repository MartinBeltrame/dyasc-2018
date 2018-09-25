package ar.edu.untref.dyasc.dominio;

public class GeneradorHI implements IGenerador {

	private String respuesta = "";

	@Override
	public void construirRespuesta(int numero) {

		int[] serieOriginal = new int[numero];
		respuesta = "fibo<" + numero + ">:";

		for (int i = 0; i < numero; i++) {
			int resultado = Funciones.fibonacciDeUnNumero(i);
			serieOriginal[i] = resultado;
		}

		int[] serieInvertida = Funciones.invertirSerie(serieOriginal);
		for (int i = 0; i < numero; i++) {
			respuesta += " " + serieInvertida[i];
		}
	}

	@Override
	public String getRespuesta() {
		return respuesta;
	}
}
