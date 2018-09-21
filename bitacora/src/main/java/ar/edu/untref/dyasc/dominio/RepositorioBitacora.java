package ar.edu.untref.dyasc.dominio;

import java.util.ArrayList;
import java.util.List;

public class RepositorioBitacora {

	private List<Evento> eventos = new ArrayList<>();

	public void agregarEvento(Evento evento) {
		eventos.add(evento);
	}

	public List<Evento> getRegistro() {
		return eventos;
	}
}
