package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

public class Bitacora {

	private List<String> eventos = new ArrayList<>();

	public void agregarEvento(String evento) {
		eventos.add(evento);
	}

	public List<String> getRegistro() {
		return eventos;
	}
}
