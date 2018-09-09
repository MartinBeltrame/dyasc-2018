package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.Periodico;
import ar.edu.untref.dyasc.dominio.Producto;
import ar.edu.untref.dyasc.dominio.RegistroVentas;
import ar.edu.untref.dyasc.dominio.Venta;

public class RegistroVentasSuscribiblesDebe {

	private Producto PRODUCTO = new Periodico(100.0);
	private Mes ENERO = Mes.ENERO;
	private Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);

	private Venta NUEVA_VENTA = new Venta(PRODUCTO, ENERO, CLIENTE);

	private RegistroVentas registroVentas;

	@Before
	public void inicializar() {
		registroVentas = new RegistroVentas();
	}

	@Test
	public void devolver_el_monto_mensual_de_un_cliente_con_una_venta() {

		registroVentas.registrar(NUEVA_VENTA);

		Double monto = 80.0;

		Assert.assertEquals(monto, registroVentas.getMonto(ENERO, CLIENTE));
	}

	@Test
	public void devolver_el_monto_mensual_de_un_cliente_con_dos_ventas() {

		registroVentas.registrar(NUEVA_VENTA);
		registroVentas.registrar(NUEVA_VENTA);

		Double monto = 160.0;

		Assert.assertEquals(monto, registroVentas.getMonto(ENERO, CLIENTE));
	}

}
