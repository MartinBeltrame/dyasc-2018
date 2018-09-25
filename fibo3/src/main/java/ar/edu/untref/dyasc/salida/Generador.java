package ar.edu.untref.dyasc.salida;

import ar.edu.untref.dyasc.dominio.Operaciones;

public abstract class Generador {

	protected Operaciones operaciones = new Operaciones();

	public abstract String generarRespuesta(int numero, int[] serie);
}
