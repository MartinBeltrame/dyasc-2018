package ar.edu.untref.dyasc.salida;

import ar.edu.untref.dyasc.dominio.Fibonacci;
import ar.edu.untref.dyasc.dominio.Operaciones;

public class VerticalInvertida implements IGenerador {

	private String respuesta;

	@Override
	public void construirRespuesta(int numero) {

		int[] serieOriginal = new int[numero];
		respuesta = "fibo<" + numero + ">:";

		for (int i = 0; i < numero; i++) {
			int resultado = Fibonacci.fibonacciDe(i);
			serieOriginal[i] = resultado;
		}

		int[] serieInvertida = Operaciones.invertirSerie(serieOriginal);
		for (int i = 0; i < numero; i++) {
			respuesta += "\n" + serieInvertida[i];
		}
	}

	@Override
	public String getRespuesta() {
		return respuesta;
	}
}
