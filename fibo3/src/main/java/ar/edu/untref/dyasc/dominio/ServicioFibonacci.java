package ar.edu.untref.dyasc.dominio;

import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.salida.Archivo;
import ar.edu.untref.dyasc.salida.GeneradorHorizontal;
import ar.edu.untref.dyasc.salida.GeneradorHorizontalInvertida;
import ar.edu.untref.dyasc.salida.GeneradorSumatoriaHorizontal;
import ar.edu.untref.dyasc.salida.GeneradorSumatoriaVertical;
import ar.edu.untref.dyasc.salida.GeneradorVertical;
import ar.edu.untref.dyasc.salida.GeneradorVerticalInvertida;
import ar.edu.untref.dyasc.salida.Generador;
import ar.edu.untref.dyasc.salida.ISalida;
import ar.edu.untref.dyasc.salida.Pantalla;
import ar.edu.untref.dyasc.utilidades.Constantes;

public class ServicioFibonacci {

	private Map<String, Generador> generadores = new HashMap<>();
	private Map<String, ISalida> salidas = new HashMap<>();

	private Fibonacci fibonacci = new Fibonacci();

	public ServicioFibonacci() {

		generadores.put(Constantes.OPCION_VD, new GeneradorVertical());
		generadores.put(Constantes.OPCION_VI, new GeneradorVerticalInvertida());
		generadores.put(Constantes.OPCION_VDS, new GeneradorSumatoriaVertical());
		generadores.put(Constantes.OPCION_VIS, new GeneradorSumatoriaVertical());

		generadores.put(Constantes.OPCION_HD, new GeneradorHorizontal());
		generadores.put(Constantes.OPCION_HI, new GeneradorHorizontalInvertida());
		generadores.put(Constantes.OPCION_HDS, new GeneradorSumatoriaHorizontal());
		generadores.put(Constantes.OPCION_HIS, new GeneradorSumatoriaHorizontal());

		salidas.put(Constantes.MODO_ARCHIVO, new Archivo("salida.txt"));
		salidas.put(Constantes.MODO_PANTALLA, new Pantalla());
	}

	public String obtenerRespuesta(String opcion, int numero) {

		int[] serie = fibonacci.serieDe(numero);
		return generadores.get(opcion).generarRespuesta(numero, serie);
	}

	public void generarSalida(String opcion, String respuesta) {
		salidas.get(opcion).procesar(respuesta);
	}
}
