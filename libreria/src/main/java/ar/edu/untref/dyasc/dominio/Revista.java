package ar.edu.untref.dyasc.dominio;

public class Revista extends Producto {

	private static final double PORCENTAJE_20 = 0.2;
	private Double precio;

	public Revista(Double precio) {
		super(precio);
		this.precio = precio;
	}

	@Override
	public Double getPrecio() {
		Double descuento = precio * PORCENTAJE_20;
		return super.getPrecio() - descuento;
	}
}
