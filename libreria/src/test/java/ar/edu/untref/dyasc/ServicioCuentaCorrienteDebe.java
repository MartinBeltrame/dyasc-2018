package ar.edu.untref.dyasc;

import java.time.LocalDateTime;

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

	private Mes MES = Mes.ENERO;
	private Producto PRODUCTO = new Libro(100.0);
	private Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);
	private CuentaCorriente CUENTA_CORRIENTE = new CuentaCorriente();

	private ServicioCuentaCorriente servicioCuentaCorriente;

	@Before
	public void inicializar() {
		servicioCuentaCorriente = new ServicioCuentaCorriente();
	}

	@Test
	public void crear_nueva_cuenta_corriente_a_un_cliente() {

		servicioCuentaCorriente.crearCuenta(CLIENTE);

		Assert.assertTrue(CLIENTE.getCuentaCorriente() != null);
	}

	@Test
	public void verificar_que_el_cobro_no_se_efectua_por_no_ser_fin_de_mes() {

		Venta VENTA = new Venta(PRODUCTO, MES, CLIENTE);
		servicioCuentaCorriente.crearCuenta(CLIENTE);
		CUENTA_CORRIENTE = CLIENTE.getCuentaCorriente();
		CUENTA_CORRIENTE.setMonto(1000.0);

		servicioCuentaCorriente.efectuarCompra(VENTA, PRODUCTO.getPrecio());

		Double resultado = 1000.0;
		Assert.assertEquals(resultado, CUENTA_CORRIENTE.getMonto());
	}

	@Test
	public void verificar_que_el_cobro_se_efectua_siendo_fin_de_mes() {

		Mes MES_ACTUAL = mesActual();
		Venta VENTA = new Venta(PRODUCTO, MES_ACTUAL, CLIENTE);
		servicioCuentaCorriente.crearCuenta(CLIENTE);
		CUENTA_CORRIENTE = CLIENTE.getCuentaCorriente();
		CUENTA_CORRIENTE.setMonto(1000.0);

		servicioCuentaCorriente.efectuarCompra(VENTA, PRODUCTO.getPrecio());

		Double resultado = 900.0;
		Assert.assertEquals(resultado, CUENTA_CORRIENTE.getMonto());
	}

	private Mes mesActual() {
		return Mes.getMeses().get(LocalDateTime.now().getMonthValue() - 1);
	}
}
