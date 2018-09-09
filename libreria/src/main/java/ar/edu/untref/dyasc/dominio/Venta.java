package ar.edu.untref.dyasc.dominio;

public class Venta {

	private Producto producto;
	private Mes mes;
	private Cliente cliente;

	public Venta(Producto producto, Mes mes, Cliente cliente) {
		this.producto = producto;
		this.mes = mes;
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public Mes getMes() {
		return mes;
	}

	public Cliente getCliente() {
		return cliente;
	}
}