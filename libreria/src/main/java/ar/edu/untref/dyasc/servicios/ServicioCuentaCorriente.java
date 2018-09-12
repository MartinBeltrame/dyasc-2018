package ar.edu.untref.dyasc.servicios;

import java.util.Calendar;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.CuentaCorriente;
import ar.edu.untref.dyasc.dominio.Venta;

public class ServicioCuentaCorriente {

	private Calendar calendario = Calendar.getInstance();

	public void crearCuenta(Cliente cliente) {
		cliente.setCuenta(new CuentaCorriente());
	}

	public void efectuarCompra(Venta venta, Double montoCompra) {

		boolean coincidenciaMes = calendario.get(Calendar.MONTH) == venta.getMes().getNumero();

		if (coincidenciaMes) {
			CuentaCorriente cuentaCorriente = venta.getCliente().getCuentaCorriente();

			Double montoActual = cuentaCorriente.getMonto();
			Double montoFinal = montoActual - montoCompra;

			cuentaCorriente.setMonto(montoFinal);
		}
	}
}
