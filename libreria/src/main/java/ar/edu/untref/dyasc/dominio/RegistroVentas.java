package ar.edu.untref.dyasc.dominio;

import java.util.ArrayList;
import java.util.List;

public class RegistroVentas {

	private List<Venta> ventas = new ArrayList<>();

	public void registrar(Venta venta) {
		ventas.add(venta);
	}

	public boolean contiene(Venta venta) {
		return ventas.contains(venta);
	}

	public List<Venta> getVentas() {
		return ventas;
	}
}