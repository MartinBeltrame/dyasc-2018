package ar.edu.untref.dyasc.salida;

import java.util.HashMap;
import java.util.Map;

public abstract class Salida {

	protected Map<String, IGenerador> generadores = new HashMap<>();

	public Salida() {

		generadores.put("-o=vd", new GeneradorVertical());
		generadores.put("-o=vi", new GeneradorVertical());
		generadores.put("-o=hd", new GeneradorHorizontal());
		generadores.put("-o=hi", new GeneradorHorizontal());
	}

	public abstract void procesar();
}
