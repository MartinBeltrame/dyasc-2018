package ar.edu.untref.dyasc.dominio;

public class ArticulosLibreria extends Producto {

	private static final Double IVA = 0.21;
	private Double precio;

	public ArticulosLibreria(Double precio) {
		super(precio);
		this.precio = precio;
	}

	@Override
	public Double getPrecio() {
		Double iva = precio * IVA;
		return super.getPrecio() + iva;
	}
}
