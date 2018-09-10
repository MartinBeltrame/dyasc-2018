package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Libreria;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.Producto;
import ar.edu.untref.dyasc.dominio.RegistroSuscripcion;
import ar.edu.untref.dyasc.dominio.RegistroVentas;
import ar.edu.untref.dyasc.dominio.Venta;
import ar.edu.untref.dyasc.servicios.Monitor;
import ar.edu.untref.dyasc.servicios.ServicioVentas;

public class MonitorDebe {

	private Producto PRODUCTO = new Producto(100.0);
	private Mes MES = Mes.ENERO;
	private Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);

	private Venta VENTA = new Venta(PRODUCTO, MES, CLIENTE);

	private Monitor monitor;
	private ServicioVentas servicioVentas;

	private Libreria libreria;

	private RegistroVentas registroVentas;
	private RegistroSuscripcion registroSuscripciones;

	@Before
	public void inicializar() {
		registroVentas = new RegistroVentas();
		registroSuscripciones = new RegistroSuscripcion();
		servicioVentas = new ServicioVentas(registroVentas, registroSuscripciones);
		monitor = new Monitor(servicioVentas);
		libreria = new Libreria(registroVentas, registroSuscripciones, monitor);
	}

	@Test
	public void mostrar_el_monto_mensual_de_un_cliente() {

		libreria.realizarVenta(VENTA);

		String expected = "Cliente: " + CLIENTE.getNombre() + "\n" + "Mes: " + MES.toString() + "\n" + "Monto: " + 95.0;

		Assert.assertEquals(expected, monitor.mostrarResultado(MES, CLIENTE));
	}
}
