package ar.edu.untref.dyasc.salida;

import ar.edu.untref.dyasc.dominio.Operaciones;

public class GeneradorVerticalInvertida implements IGenerador {

	private Operaciones operaciones;

	public GeneradorVerticalInvertida(Operaciones operaciones) {
		this.operaciones = operaciones;
	}

	@Override
	public String generarRespuesta(int numero, int[] serie) {

		serie = operaciones.invertirSerie(serie);
		String respuesta = "fibo<" + numero + ">:";

		for (int i = 0; i < serie.length; i++) {
			respuesta += "\n" + serie[i];
		}
		return respuesta;
	}
}
