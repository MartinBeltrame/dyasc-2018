package ar.edu.untref.dyasc;

import java.util.List;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Libreria;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.RegistroSuscripcion;
import ar.edu.untref.dyasc.dominio.RegistroVentas;
import ar.edu.untref.dyasc.dominio.Suscripcion;
import ar.edu.untref.dyasc.dominio.Venta;
import ar.edu.untref.dyasc.servicios.Mockeador;
import ar.edu.untref.dyasc.servicios.Monitor;
import ar.edu.untref.dyasc.servicios.ServicioVentas;

public class Program {

	private static Libreria libreria;

	private static void inicializar() {
		RegistroSuscripcion registroSuscripciones = new RegistroSuscripcion();
		RegistroVentas registroVentas = new RegistroVentas();
		ServicioVentas servicioVentas = new ServicioVentas(registroVentas, registroSuscripciones);
		Monitor monitor = new Monitor(servicioVentas);
		libreria = new Libreria(registroVentas, registroSuscripciones, monitor);

		Mockeador.mockearVentas();
	}

	public static void main(String[] args) {

		inicializar();

		List<Venta> ventas = Mockeador.getVentas();
		List<Cliente> clientes = Mockeador.getClientes();
		List<Suscripcion> suscripciones = Mockeador.getSuscripciones();

		for (Venta venta : ventas) {
			libreria.realizarVenta(venta);
		}

		for (Suscripcion suscripcion : suscripciones) {
			libreria.realizarSuscripcion(suscripcion);
		}

		Cliente juan = clientes.get(0);
		Cliente alicia = clientes.get(1);
		Cliente oscar = clientes.get(2);

		libreria.obtenerMonto(Mes.ENERO, juan);
		libreria.obtenerMonto(Mes.FEBRERO, alicia);
		libreria.obtenerMonto(Mes.MARZO, juan);
		libreria.obtenerMonto(Mes.ABRIL, oscar);
	}
}
