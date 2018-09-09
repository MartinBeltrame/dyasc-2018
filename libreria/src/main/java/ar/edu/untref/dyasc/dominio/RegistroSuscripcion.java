package ar.edu.untref.dyasc.dominio;

import java.util.ArrayList;
import java.util.List;

public class RegistroSuscripcion {

	private List<Suscripcion> suscripciones = new ArrayList<>();

	public boolean contains(Suscripcion suscripcion) {
		return suscripciones.contains(suscripcion);
	}

	public void registrar(Suscripcion suscripcion) {
		suscripciones.add(suscripcion);
	}
}
