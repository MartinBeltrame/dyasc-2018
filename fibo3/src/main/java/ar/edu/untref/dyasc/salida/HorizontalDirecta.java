package ar.edu.untref.dyasc.salida;

import ar.edu.untref.dyasc.dominio.Fibonacci;

public class HorizontalDirecta implements IGenerador {

	private String respuesta;

	@Override
	public void construirRespuesta(int numero) {

		respuesta = "fibo<" + numero + ">:";

		for (int i = 0; i < numero; i++) {
			int resultado = Fibonacci.fibonacciDe(i);
			respuesta += " " + resultado;
		}
	}

	@Override
	public String getRespuesta() {
		return respuesta;
	}
}
