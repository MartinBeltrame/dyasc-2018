package ar.edu.untref.dyasc.salida;

import ar.edu.untref.dyasc.dominio.Fibonacci;
import ar.edu.untref.dyasc.dominio.Operaciones;

public class VerticalSumatoria implements IGenerador {

	private String respuesta;

	@Override
	public void construirRespuesta(int numero) {

		int[] serieOriginal = new int[numero];
		respuesta = "fibo<" + numero + ">s:\n";

		for (int i = 0; i < numero; i++) {
			int resultado = Fibonacci.fibonacciDe(i);
			serieOriginal[i] = resultado;
		}

		int sumatoria = Operaciones.sumatoria(serieOriginal);
		respuesta += sumatoria;
	}

	@Override
	public String getRespuesta() {
		return respuesta;
	}
}
