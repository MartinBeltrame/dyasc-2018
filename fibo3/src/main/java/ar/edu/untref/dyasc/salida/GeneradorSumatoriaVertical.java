package ar.edu.untref.dyasc.salida;

public class GeneradorSumatoriaVertical extends Generador {

	@Override
	public String generarRespuesta(int numero, int[] serie) {
		String respuesta = "fibo<" + numero + ">s:\n" + operaciones.sumatoria(serie);
		return respuesta;
	}
}
