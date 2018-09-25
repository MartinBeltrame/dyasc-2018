package ar.edu.untref.dyasc.salida;

public class GeneradorHorizontal implements IGenerador {

	private String respuesta;

	@Override
	public String generarRespuesta(int numero, int[] serie) {

		respuesta = "fibo<" + numero + ">:";

		for (int i = 0; i < serie.length; i++) {
			respuesta += " " + serie[i];
		}
		return respuesta;
	}
}
