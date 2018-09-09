package ar.edu.untref.dyasc.dominio;

public class Libreria {

	private RegistroVentas registroVentas;
	private RegistroSuscripcion registroSuscripciones;

	public Libreria(RegistroVentas registroVentas, RegistroSuscripcion registroSuscripciones) {
		this.registroVentas = registroVentas;
		this.registroSuscripciones = registroSuscripciones;
	}

	public void realizarVenta(Venta venta) {
		registroVentas.registrar(venta);
	}

	public void realizarSuscripcion(Suscripcion suscripcion) {
		registroSuscripciones.registrar(suscripcion);
	}
}
