package ar.edu.untref.dyasc.salida;

import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.dominio.TipoArgumento;

public abstract class Salida {

	protected Map<String, TipoArgumento> opciones = new HashMap<>();
	protected Map<TipoArgumento, IGenerador> generadores = new HashMap<>();

	public Salida() {

		opciones.put("-o=vd", TipoArgumento.VERTICAL_DIRECTA);
		opciones.put("-o=vi", TipoArgumento.VERTICAL_INVERTIDA);
		opciones.put("-o=hd", TipoArgumento.HORIZONTAL_DIRECTA);
		opciones.put("-o=hi", TipoArgumento.HORIZONTAL_INVERTIDA);

		generadores.put(TipoArgumento.VERTICAL_DIRECTA, new VerticalDirecta());
		generadores.put(TipoArgumento.VERTICAL_INVERTIDA, new VerticalInvertida());
		generadores.put(TipoArgumento.HORIZONTAL_DIRECTA, new HorizontalDirecta());
		generadores.put(TipoArgumento.HORIZONTAL_INVERTIDA, new HorizontalInvertida());
	}

	public abstract void procesar();
}
