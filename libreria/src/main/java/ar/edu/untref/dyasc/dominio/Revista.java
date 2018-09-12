package ar.edu.untref.dyasc.dominio;

public class Revista extends Producto {

	private int periodicidad;
	
	public Revista(Double precio) {
		super(precio);
	}
	
	public void setPeriodicidad(int periodicidad) {
		this.periodicidad = periodicidad;
	}
	
	public int getPeriodicidad() {
		return periodicidad;
	}
}
