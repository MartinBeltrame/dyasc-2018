package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.ArticulosLibreria;
import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Libro;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.Producto;
import ar.edu.untref.dyasc.dominio.RegistroVentas;
import ar.edu.untref.dyasc.dominio.Venta;
import ar.edu.untref.dyasc.servicios.ServicioVentas;

public class ServicioVentasNoSuscribiblesDebe {

	private Producto PRODUCTO = new Libro(100.0);
	private Mes ENERO = Mes.ENERO;
	private Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);

	private Venta NUEVA_VENTA = new Venta(PRODUCTO, ENERO, CLIENTE);

	private ServicioVentas servicioVentas;
	private RegistroVentas registroVentas;

	@Before
	public void inicializar() {
		registroVentas = new RegistroVentas();
		servicioVentas = new ServicioVentas(registroVentas);
	}

	@Test
	public void devolver_el_monto_mensual_de_un_cliente_sin_ventas() {

		Double monto = 0.0;

		Assert.assertEquals(monto, servicioVentas.getMonto(ENERO, CLIENTE));
	}

	@Test
	public void devolver_el_monto_mensual_de_un_cliente_con_una_venta() {

		registroVentas.registrar(NUEVA_VENTA);

		Double monto = 95.0;

		Assert.assertEquals(monto, servicioVentas.getMonto(ENERO, CLIENTE));
	}

	@Test
	public void devolver_el_monto_mensual_de_un_cliente_con_dos_ventas() {

		registroVentas.registrar(NUEVA_VENTA);
		registroVentas.registrar(NUEVA_VENTA);

		Double monto = 190.0;

		Assert.assertEquals(monto, servicioVentas.getMonto(ENERO, CLIENTE));
	}

	@Test
	public void devolver_el_monto_mensual_de_un_cliente_con_una_venta_con_iva() {

		Producto PRODUCTO = new ArticulosLibreria(100.0);
		Mes ENERO = Mes.ENERO;
		Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);

		Venta VENTA = new Venta(PRODUCTO, ENERO, CLIENTE);

		registroVentas.registrar(VENTA);

		Double monto = 121.0;

		Assert.assertEquals(monto, servicioVentas.getMonto(ENERO, CLIENTE));
	}
}
