package ar.edu.untref.dyasc.salida;

import ar.edu.untref.dyasc.dominio.Operaciones;

public class GeneradorSumatoriaVertical implements IGenerador {

	private Operaciones operaciones;

	public GeneradorSumatoriaVertical(Operaciones operaciones) {
		this.operaciones = operaciones;
	}

	@Override
	public String generarRespuesta(int numero, int[] serie) {
		String respuesta = "fibo<" + numero + ">s:\n" + operaciones.sumatoria(serie);
		return respuesta;
	}
}
