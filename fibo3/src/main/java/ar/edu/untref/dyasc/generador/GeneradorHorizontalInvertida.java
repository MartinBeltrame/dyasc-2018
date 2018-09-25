package ar.edu.untref.dyasc.generador;

public class GeneradorHorizontalInvertida extends Generador {

	@Override
	public String generarRespuesta(int numero, int[] serie) {

		serie = operaciones.invertirSerie(serie);
		String respuesta = "fibo<" + numero + ">:";

		for (int i = 0; i < serie.length; i++) {
			respuesta += " " + serie[i];
		}
		return respuesta;
	}
}
