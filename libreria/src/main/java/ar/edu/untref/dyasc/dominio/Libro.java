package ar.edu.untref.dyasc.dominio;

public class Libro extends Producto {

	private static final Double PORCENTAJE_5 = 0.05;
	private Double precio;

	public Libro(Double precio) {
		super(precio);
		this.precio = precio;
	}

	@Override
	public Double getPrecio() {
		Double descuento = precio * PORCENTAJE_5;
		return super.getPrecio() - descuento;
	}
}
