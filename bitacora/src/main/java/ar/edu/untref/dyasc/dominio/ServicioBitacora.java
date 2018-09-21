package ar.edu.untref.dyasc.dominio;

import java.util.List;

public class ServicioBitacora {

	public String registrarEvento(List<Evento> registro) {
		Evento evento = registro.get(0);
		return evento.getMensaje() + " - " + evento.getFecha();
	}
}
