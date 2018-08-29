package ar.edu.untref.dyasc;

import ar.edu.untref.dyac.interfaces.IGenerador;

public class GeneradorVD implements IGenerador {

	private String respuesta = "";

	@Override
	public void construirRespuesta(int numero) {

		respuesta = "fibo<" + numero + ">:\n";

		for (int i = 0; i < numero; i++) {
			int resultado = Funciones.fibonacciDeUnNumero(i);
			respuesta += resultado + "\n";
		}
	}

	@Override
	public String getRespuesta() {
		return respuesta;
	}
}
