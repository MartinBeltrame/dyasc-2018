package ar.edu.untref.dyasc.servicios;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.CuentaCorriente;
import ar.edu.untref.dyasc.dominio.Venta;

public class ServicioCuentaCorriente {

	public String registrarCompra(Venta venta, CuentaCorriente cuenta) {
		return null;
	}

	public void crearCuenta(Cliente cliente) {
		cliente.setCuenta(new CuentaCorriente());
	}
}
