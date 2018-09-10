package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Libro;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.Producto;
import ar.edu.untref.dyasc.dominio.RegistroVentas;
import ar.edu.untref.dyasc.dominio.Venta;

public class RegistroVentasDebe {

	private Producto PRODUCTO = new Libro(100.0);
	private Mes ENERO = Mes.ENERO;
	private Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);

	private Venta NUEVA_VENTA = new Venta(PRODUCTO, ENERO, CLIENTE);

	private RegistroVentas registroVentas;

	@Before
	public void inicializar() {
		registroVentas = new RegistroVentas();
	}

	@Test
	public void verificar_que_la_venta_ha_sido_registrada() {

		registroVentas.registrar(NUEVA_VENTA);

		Assert.assertTrue(registroVentas.contiene(NUEVA_VENTA));
	}
}
