package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.Periodico;
import ar.edu.untref.dyasc.dominio.Producto;
import ar.edu.untref.dyasc.dominio.RegistroSuscripcion;
import ar.edu.untref.dyasc.dominio.RegistroVentas;
import ar.edu.untref.dyasc.dominio.Suscripcion;
import ar.edu.untref.dyasc.dominio.Venta;
import ar.edu.untref.dyasc.servicios.ServicioVentas;

public class ServicioVentasSuscribiblesDebe {

	private Producto PRODUCTO = new Periodico(100.0);
	private Mes ENERO = Mes.ENERO;
	private Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);

	private Venta NUEVA_VENTA = new Venta(PRODUCTO, ENERO, CLIENTE);
	private Suscripcion SUSCRIPCION = new Suscripcion(CLIENTE, PRODUCTO);

	private ServicioVentas servicioVentas;
	private RegistroVentas registroVentas;
	private RegistroSuscripcion registroSuscripcion;

	@Before
	public void inicializar() {
		registroVentas = new RegistroVentas();
		registroSuscripcion = new RegistroSuscripcion();
		servicioVentas = new ServicioVentas(registroVentas, registroSuscripcion);
	}

	@Test
	public void devolver_el_monto_anual_de_un_cliente_con_una_venta_suscripta_a_un_producto() {

		registroVentas.registrar(NUEVA_VENTA);
		registroSuscripcion.registrar(SUSCRIPCION);

		Double monto = 80.0;
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
}
