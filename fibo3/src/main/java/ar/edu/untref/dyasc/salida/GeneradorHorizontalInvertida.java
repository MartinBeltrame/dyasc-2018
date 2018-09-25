package ar.edu.untref.dyasc.salida;

import ar.edu.untref.dyasc.dominio.Operaciones;

public class GeneradorHorizontalInvertida implements IGenerador {

	private Operaciones operaciones;

	public GeneradorHorizontalInvertida(Operaciones operaciones) {
		this.operaciones = operaciones;
	}

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
