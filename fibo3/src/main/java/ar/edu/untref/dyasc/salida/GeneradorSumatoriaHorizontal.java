package ar.edu.untref.dyasc.salida;

import ar.edu.untref.dyasc.dominio.Operaciones;

public class GeneradorSumatoriaHorizontal implements IGenerador {

	private Operaciones operaciones;

	public GeneradorSumatoriaHorizontal(Operaciones operaciones) {
		this.operaciones = operaciones;
	}

	@Override
	public String generarRespuesta(int numero, int[] serie) {
		String respuesta = "fibo<" + numero + ">s: " + operaciones.sumatoria(serie);
		return respuesta;
	}
}
