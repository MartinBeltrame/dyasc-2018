package ar.edu.untref.dyasc.dominio;

public class Periodico extends Producto {

	private int periodicidad;

	public Periodico(Double precio) {
		super(precio);
	}

	public int getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(int periodicidad) {
		this.periodicidad = periodicidad;
	}
}
