package ar.edu.untref.dyasc;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

public class ProgramDebe {

	private Libreria libreria;
	private Cliente juan;
	private Cliente alicia;
	private Cliente oscar;

	@Before
	public void inicializar() {

		RegistroSuscripcion registroSuscripciones = new RegistroSuscripcion();
		RegistroVentas registroVentas = new RegistroVentas();
		ServicioVentas servicioVentas = new ServicioVentas(registroVentas, registroSuscripciones);
		Monitor monitor = new Monitor(servicioVentas);
		libreria = new Libreria(registroVentas, registroSuscripciones, monitor);

		Mockeador.mockearVentas();

		List<Venta> ventas = Mockeador.getVentas();
		List<Cliente> clientes = Mockeador.getClientes();
		List<Suscripcion> suscripciones = Mockeador.getSuscripciones();

		for (Venta venta : ventas) {
			libreria.realizarVenta(venta);
		}

		for (Suscripcion suscripcion : suscripciones) {
			libreria.realizarSuscripcion(suscripcion);
		}

		juan = clientes.get(0);
		alicia = clientes.get(1);
		oscar = clientes.get(2);
	}

	@Test
	public void obtener_el_monto_total_de_cada_cliente_para_enero_con_productos_no_suscriptos() {

		Double montoJuan = libreria.obtenerMonto(Mes.ENERO, juan);
		Double montoAlicia = libreria.obtenerMonto(Mes.ENERO, alicia);
		Double montoOscar = libreria.obtenerMonto(Mes.ENERO, oscar);

		Double resultadoJuan = 47.5;
		Double resultadoAlicia = 285.0;
		Double resultadoOscar = 285.0;

		Assert.assertEquals(resultadoJuan, montoJuan);
		Assert.assertEquals(resultadoAlicia, montoAlicia);
		Assert.assertEquals(resultadoOscar, montoOscar);
	}

	@Test
	public void obtener_el_monto_total_de_cada_cliente_para_febrero_con_productos_no_suscriptos() {

		Double montoJuan = libreria.obtenerMonto(Mes.FEBRERO, juan);
		Double montoAlicia = libreria.obtenerMonto(Mes.FEBRERO, alicia);
		Double montoOscar = libreria.obtenerMonto(Mes.FEBRERO, oscar);

		Double resultadoJuan = 0.0;
		Double resultadoAlicia = 85.5;
		Double resultadoOscar = 0.0;

		Assert.assertEquals(resultadoJuan, montoJuan);
		Assert.assertEquals(resultadoAlicia, montoAlicia);
		Assert.assertEquals(resultadoOscar, montoOscar);
	}
}
