package ar.edu.untref.dyasc.dominio;

import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.generador.Generador;
import ar.edu.untref.dyasc.generador.GeneradorHorizontal;
import ar.edu.untref.dyasc.generador.GeneradorHorizontalInvertida;
import ar.edu.untref.dyasc.generador.GeneradorSumatoriaHorizontal;
import ar.edu.untref.dyasc.generador.GeneradorSumatoriaVertical;
import ar.edu.untref.dyasc.generador.GeneradorVertical;
import ar.edu.untref.dyasc.generador.GeneradorVerticalInvertida;
import ar.edu.untref.dyasc.salida.Archivo;
import ar.edu.untref.dyasc.salida.ISalida;
import ar.edu.untref.dyasc.salida.Pantalla;
import ar.edu.untref.dyasc.utilidades.Constantes;

public class ServicioFibonacci {

	private Map<String, Generador> generadores = new HashMap<>();
	private Map<String, ISalida> salidas = new HashMap<>();

	private Fibonacci fibonacci;

	public ServicioFibonacci(String nombreArchivo) {

		fibonacci = new Fibonacci();

		generadores.put(Constantes.OPCION_VD, new GeneradorVertical());
		generadores.put(Constantes.OPCION_VI, new GeneradorVerticalInvertida());
		generadores.put(Constantes.OPCION_VDS, new GeneradorSumatoriaVertical());
		generadores.put(Constantes.OPCION_VIS, new GeneradorSumatoriaVertical());
		generadores.put(Constantes.OPCION_HD, new GeneradorHorizontal());
		generadores.put(Constantes.OPCION_HI, new GeneradorHorizontalInvertida());
		generadores.put(Constantes.OPCION_HDS, new GeneradorSumatoriaHorizontal());
		generadores.put(Constantes.OPCION_HIS, new GeneradorSumatoriaHorizontal());

		salidas.put(Constantes.MODO_ARCHIVO, new Archivo(nombreArchivo));
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
