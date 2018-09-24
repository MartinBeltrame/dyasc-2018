package ar.edu.untref.dyasc.dominio;

import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.salida.Archivo;
import ar.edu.untref.dyasc.salida.Consola;
import ar.edu.untref.dyasc.salida.Salida;

public class Bitacora {

	private ServicioBitacora servicioBitacora;
	private Map<TipoArgumento, Salida> salidas = new HashMap<>();

	public Bitacora(ServicioBitacora servicioBitacora) {
		this.servicioBitacora = servicioBitacora;
	}

	public void registrarEvento(String argumento) {

		String resultado = servicioBitacora.obtenerSalida();
		String variableDestino = obtenerVariableDestino(argumento);

		TipoArgumento tipo = TipoArgumento.identificar(variableDestino);

		salidas.put(TipoArgumento.CONSOLA_Y_ARCHIVO, new Consola());
		salidas.put(TipoArgumento.CONSOLA, new Consola());
		salidas.put(TipoArgumento.ARCHIVO, new Archivo(variableDestino));

		salidas.get(tipo).procesar(resultado);
	}

	private String obtenerVariableDestino(String argumento) {
		if (argumento.length() > 16) {
			return argumento.substring(17, argumento.length());
		} else {
			return "";
		}
	}
}
