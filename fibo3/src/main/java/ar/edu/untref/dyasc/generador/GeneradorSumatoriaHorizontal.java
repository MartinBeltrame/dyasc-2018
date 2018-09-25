package ar.edu.untref.dyasc.generador;

public class GeneradorSumatoriaHorizontal extends Generador {

	@Override
	public String generarRespuesta(int numero, int[] serie) {
		String respuesta = "fibo<" + numero + ">s: " + operaciones.sumatoria(serie);
		return respuesta;
	}
}
