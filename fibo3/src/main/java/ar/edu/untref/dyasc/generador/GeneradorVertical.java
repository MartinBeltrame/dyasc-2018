package ar.edu.untref.dyasc.generador;

public class GeneradorVertical extends Generador {

	@Override
	public String generarRespuesta(int numero, int[] serie) {

		String respuesta = "fibo<" + numero + ">:";

		for (int i = 0; i < serie.length; i++) {
			respuesta += "\n" + serie[i];
		}
		return respuesta;
	}
}
