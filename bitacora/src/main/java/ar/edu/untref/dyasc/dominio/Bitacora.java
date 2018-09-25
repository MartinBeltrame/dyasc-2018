package ar.edu.untref.dyasc.dominio;

import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.salida.Archivo;
import ar.edu.untref.dyasc.salida.Consola;
import ar.edu.untref.dyasc.salida.ConsolaArchivo;
import ar.edu.untref.dyasc.salida.Salida;
import ar.edu.untref.dyasc.utilidades.Identificador;

public class Bitacora {

	private ServicioBitacora servicioBitacora = new ServicioBitacora();
	private Map<TipoArgumento, Salida> salidas = new HashMap<>();

	private String argumento;
	private TipoArgumento tipo;

	public Bitacora(String argumento) {
		this.argumento = argumento;
		inicializar();
	}

	private void inicializar() {

		tipo = Identificador.obtenerTipoArgumento(argumento);
		String variableDestino = Identificador.obtenerVariableDestino(argumento);

		salidas.put(TipoArgumento.CONSOLA_Y_ARCHIVO, new ConsolaArchivo(variableDestino));
		salidas.put(TipoArgumento.CONSOLA, new Consola());
		salidas.put(TipoArgumento.ARCHIVO, new Archivo(variableDestino));
	}

	public void registrarEvento(String mensaje) {
		servicioBitacora.agregarEvento(new Evento(mensaje));
	}

	public void procesar() {
		String resultado = servicioBitacora.obtenerSalida();
		salidas.get(tipo).procesar(resultado);
	}
}
