package ar.edu.untref.dyasc.dominio;

import ar.edu.untref.dyasc.servicios.ServicioVentas;

public class Libreria {

	private RegistroVentas registroVentas;
	private RegistroSuscripcion registroSuscripciones;
	private ServicioVentas servicioVentas;

	public Libreria(RegistroVentas registroVentas, RegistroSuscripcion registroSuscripciones, ServicioVentas servicioVentas) {
		this.registroVentas = registroVentas;
		this.registroSuscripciones = registroSuscripciones;
		this.servicioVentas = servicioVentas;
	}

	public void realizarVenta(Venta venta) {
		registroVentas.registrar(venta);
	}

	public void realizarSuscripcion(Suscripcion suscripcion) {
		registroSuscripciones.registrar(suscripcion);
	}

	public Double obtenerMonto(Mes mes, Cliente cliente) {
		return servicioVentas.getMonto(mes, cliente);
	}

	public Double obtenerMontoAnual(Cliente cliente) {
		return servicioVentas.getMontoAnual(cliente);
	}
}
