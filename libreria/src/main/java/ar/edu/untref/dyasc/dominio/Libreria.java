package ar.edu.untref.dyasc.dominio;

import ar.edu.untref.dyasc.servicios.Monitor;

public class Libreria {

	private RegistroVentas registroVentas;
	private RegistroSuscripcion registroSuscripciones;
	private Monitor monitor;

	public Libreria(RegistroVentas registroVentas, RegistroSuscripcion registroSuscripciones, Monitor monitor) {
		this.registroVentas = registroVentas;
		this.registroSuscripciones = registroSuscripciones;
		this.monitor = monitor;
	}

	public void realizarVenta(Venta venta) {
		registroVentas.registrar(venta);
	}

	public void realizarSuscripcion(Suscripcion suscripcion) {
		registroSuscripciones.registrar(suscripcion);
	}

	public Double obtenerMonto(Mes mes, Cliente cliente) {
		return monitor.mostrarResultado(mes, cliente);
	}

	public Double obtenerMontoAnual(Cliente cliente) {
		return monitor.mostrarResultadoAnual(cliente);
	}
}
