package ar.edu.untref.dyasc.dominio;

import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.salida.Archivo;
import ar.edu.untref.dyasc.salida.GeneradorHorizontal;
import ar.edu.untref.dyasc.salida.GeneradorVertical;
import ar.edu.untref.dyasc.salida.IGenerador;
import ar.edu.untref.dyasc.salida.Pantalla;
import ar.edu.untref.dyasc.utilidades.Constantes;
import ar.edu.untref.dyasc.salida.ISalida;

public class ServicioFibonacci {

	private Map<String, IGenerador> generadores = new HashMap<>();
	private Map<String, ISalida> salidas = new HashMap<>();
	private Fibonacci fibonacci = new Fibonacci();
	private Operaciones operaciones = new Operaciones();

	public ServicioFibonacci() {

		generadores.put(Constantes.OPCION_VD, new GeneradorVertical());
		generadores.put(Constantes.OPCION_VI, new GeneradorVertical());
		generadores.put(Constantes.OPCION_HD, new GeneradorHorizontal());
		generadores.put(Constantes.OPCION_HI, new GeneradorHorizontal());

		salidas.put(Constantes.MODO_ARCHIVO, new Archivo("salida.txt"));
		salidas.put(Constantes.MODO_PANTALLA, new Pantalla());
	}

	public String obtenerRespuesta(String opcion, int numero) {

		int[] serie = fibonacci.serieDe(numero);

		if (opcion.equals(Constantes.OPCION_HI) || opcion.equals(Constantes.OPCION_VI)) {
			serie = operaciones.invertirSerie(serie);
		}
		return generadores.get(opcion).generarRespuesta(numero, serie);
	}

	public void generarSalida(String opcion, String respuesta) {
		salidas.get(opcion).procesar(respuesta);
	}
}
