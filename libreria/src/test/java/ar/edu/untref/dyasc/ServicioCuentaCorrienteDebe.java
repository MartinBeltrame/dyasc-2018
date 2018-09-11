package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.servicios.ServicioCuentaCorriente;

public class ServicioCuentaCorrienteDebe {

	private Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);
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
}
