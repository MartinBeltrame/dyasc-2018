package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Libreria;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.RegistroSuscripcion;
import ar.edu.untref.dyasc.dominio.RegistroVentas;
import ar.edu.untref.dyasc.dominio.Revista;
import ar.edu.untref.dyasc.dominio.Venta;
import ar.edu.untref.dyasc.servicios.Monitor;
import ar.edu.untref.dyasc.servicios.ServicioVentas;

public class Program {

	public static void main(String[] args) {

		Cliente juan = new Cliente("Juan", "Lorta", "Av. siempreviva", 23232322);
		Mes enero = Mes.ENERO;
		Revista producto = new Revista(50.0);

		RegistroSuscripcion registroSuscripciones = new RegistroSuscripcion();
		RegistroVentas registroVentas = new RegistroVentas();

		ServicioVentas servicioVentas = new ServicioVentas(registroVentas, registroSuscripciones);

		Monitor monitor = new Monitor(servicioVentas);

		Libreria libreria = new Libreria(registroVentas, registroSuscripciones, monitor);
		Venta venta = new Venta(producto, enero, juan);

		libreria.realizarVenta(venta);
		libreria.obtenerMonto(enero, juan);
	}
}
