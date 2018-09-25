package ar.edu.untref.dyasc.dominio;

public class GeneradorHD implements IGenerador {

	private String respuesta;

	@Override
	public void construirRespuesta(int numero) {

		respuesta = "fibo<" + numero + ">:";

		for (int i = 0; i < numero; i++) {
			int resultado = Funciones.fibonacciDeUnNumero(i);
			respuesta += " " + resultado;
		}
	}

	@Override
	public String getRespuesta() {
		return respuesta;
	}
}
