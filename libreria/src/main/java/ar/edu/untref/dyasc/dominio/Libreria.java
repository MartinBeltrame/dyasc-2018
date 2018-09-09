package ar.edu.untref.dyasc.dominio;

public class Libreria {
	
	private RegistroVentas registroVentas;

	public Libreria(RegistroVentas registroVentas) {
		this.registroVentas = registroVentas;
	}

	public void realizarVenta(Venta venta) {
		registroVentas.registrar(venta);
	}
}
