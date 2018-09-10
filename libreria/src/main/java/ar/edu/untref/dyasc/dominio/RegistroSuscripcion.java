package ar.edu.untref.dyasc.dominio;

import java.util.ArrayList;
import java.util.List;

public class RegistroSuscripcion {

	private List<Suscripcion> suscripciones = new ArrayList<>();

	public boolean contiene(Suscripcion suscripcion) {
		return suscripciones.contains(suscripcion);
	}

	public boolean contiene(Cliente cliente) {

		for (Suscripcion suscripcion : suscripciones) {
			if (suscripcion.getCliente() == cliente) {
				return true;
			}
		}
		return false;
	}

	public void registrar(Suscripcion suscripcion) {

		Producto tipoProducto = suscripcion.getProducto();
		if (tipoProducto.getClass() == Periodico.class || tipoProducto.getClass() == Revista.class) {
			suscripciones.add(suscripcion);
		}
	}
}
