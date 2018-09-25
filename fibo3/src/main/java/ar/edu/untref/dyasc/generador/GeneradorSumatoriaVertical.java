package ar.edu.untref.dyasc.generador;

public class GeneradorSumatoriaVertical extends Generador {

	@Override
	public String generarRespuesta(int numero, int[] serie) {
		String respuesta = "fibo<" + numero + ">s:\n" + operaciones.sumatoria(serie);
		return respuesta;
	}
}
