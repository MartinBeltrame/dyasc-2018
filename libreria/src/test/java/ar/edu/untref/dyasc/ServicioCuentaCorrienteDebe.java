package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.CuentaCorriente;
import ar.edu.untref.dyasc.dominio.Libro;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.Producto;
import ar.edu.untref.dyasc.dominio.Venta;
import ar.edu.untref.dyasc.servicios.ServicioCuentaCorriente;

public class ServicioCuentaCorrienteDebe {

	private Producto PRODUCTO = new Libro(100.0);
	private Mes ENERO = Mes.ENERO;
	private Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);

	private Venta VENTA = new Venta(PRODUCTO, ENERO, CLIENTE);

	private CuentaCorriente CUENTA_CORRIENTE = new CuentaCorriente();

	private ServicioCuentaCorriente servicioCuentaCorriente;

	@Before
	public void inicializar() {
		servicioCuentaCorriente = new ServicioCuentaCorriente();
		servicioCuentaCorriente.crearCuenta(CLIENTE);

		CUENTA_CORRIENTE = CLIENTE.getCuentaCorriente();
		CUENTA_CORRIENTE.setMonto(1000.0);
	}

	@Test
	public void crear_nueva_cuenta_corriente_a_un_cliente() {

		Assert.assertTrue(CLIENTE.getCuentaCorriente() != null);
	}

	@Test
	public void verficar_que_se_efectua_el_pago_y_se_realiza_el_descuento_en_la_cuenta_corriente() {

		servicioCuentaCorriente.efectuarCompra(VENTA, CUENTA_CORRIENTE, PRODUCTO.getPrecio());

		Double resultado = 900.0;
		Assert.assertEquals(resultado, CUENTA_CORRIENTE.getMonto());
	}
}
