package ar.edu.untre.dyasc.servicios;

import java.util.List;

import ar.edu.untref.dyasc.dominio.Evento;
import ar.edu.untref.dyasc.dominio.RepositorioBitacora;

public class ServicioBitacora {

	private RepositorioBitacora repositorioBitacora;

	public ServicioBitacora(RepositorioBitacora repositorioBitacora) {
		this.repositorioBitacora = repositorioBitacora;
	}

	public String obtenerResultado() {

		List<Evento> registro = repositorioBitacora.getRegistro();

		String resultado = "";
		for (int i = 0; i < registro.size(); i++) {

			Evento evento = registro.get(i);
			resultado += evento.getMensaje() + " - " + evento.getFecha();

			if (i != registro.size() - 1) {
				resultado += "\n";
			}
		}
		return resultado;
	}
}
