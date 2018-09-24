package ar.edu.untref.dyasc.dominio;

import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.salida.Archivo;
import ar.edu.untref.dyasc.salida.Consola;
import ar.edu.untref.dyasc.salida.ConsolaArchivo;
import ar.edu.untref.dyasc.salida.Salida;
import ar.edu.untref.dyasc.utilidades.FormateadorVariable;

public class Bitacora {

	private ServicioBitacora servicioBitacora;
	private Map<TipoArgumento, Salida> salidas = new HashMap<>();

	public Bitacora(ServicioBitacora servicioBitacora) {
		this.servicioBitacora = servicioBitacora;
	}

	public void registrarEvento(String argumento) {

		String resultado = servicioBitacora.obtenerSalida();

		TipoArgumento tipo = TipoArgumento.identificar(argumento);
		String variableDestino = FormateadorVariable.obtenerVariableDestino(argumento);

		salidas.put(TipoArgumento.CONSOLA_Y_ARCHIVO, new ConsolaArchivo(variableDestino));
		salidas.put(TipoArgumento.CONSOLA, new Consola());
		salidas.put(TipoArgumento.ARCHIVO, new Archivo(variableDestino));

		salidas.get(tipo).procesar(resultado);
	}
}
