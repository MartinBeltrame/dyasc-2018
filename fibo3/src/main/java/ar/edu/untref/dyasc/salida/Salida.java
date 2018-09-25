package ar.edu.untref.dyasc.salida;

import java.util.HashMap;
import java.util.Map;

public abstract class Salida {

	private Map<String, IGenerador> generadores = new HashMap<>();
	private Map<String, Salida> salidas = new HashMap<>();

	public Salida() {

		generadores.put("-o=vd", new GeneradorVertical());
		generadores.put("-o=vi", new GeneradorVertical());
		generadores.put("-o=hd", new GeneradorHorizontal());
		generadores.put("-o=hi", new GeneradorHorizontal());

		salidas.put("-f=", new Archivo("salida.txt"));
		salidas.put("-o=", new Pantalla());
	}

	public void procesar(String opcion, int numero, int[] serie) {
		String respuesta = generadores.get(opcion).generarRespuesta(numero, serie);
		salidas.get(respuesta).procesar(respuesta);
	}

	public abstract void procesar(String respuesta);
}
