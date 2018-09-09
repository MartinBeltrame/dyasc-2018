package ar.edu.untref.dyasc.dominio;

public class Suscripcion {

	private Cliente cliente;
	private Producto producto;

	public Suscripcion(Cliente cliente, Producto producto) {
		this.cliente = cliente;
		this.producto = producto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Producto getProducto() {
		return producto;
	}
}
