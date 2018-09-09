package ar.edu.untref.dyasc.dominio;

public class Periodico extends Producto {

	private static final double PORCENTAJE_20 = 0.2;
	private Double precio;

	public Periodico(Double precio) {
		super(precio);
		this.precio = precio;
	}

	@Override
	public Double getPrecio() {
		Double descuento = precio * PORCENTAJE_20;
		return super.getPrecio() - descuento;
	}
}
