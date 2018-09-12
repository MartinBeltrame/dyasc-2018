package ar.edu.untref.dyasc.servicios;

import java.util.Calendar;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.CuentaCorriente;
import ar.edu.untref.dyasc.dominio.Mes;

public class ServicioCuentaCorriente {

	private Calendar calendario = Calendar.getInstance();

	public void crearCuenta(Cliente cliente) {
		cliente.setCuenta(new CuentaCorriente());
	}

	public void efectuarCompra(Cliente cliente, Mes mes, Double montoCompra) {

		boolean coincidenciaMes = calendario.get(Calendar.MONTH) == mes.getNumero();

		if (coincidenciaMes) {
			CuentaCorriente cuentaCorriente = cliente.getCuentaCorriente();

			Double montoActual = cuentaCorriente.getMonto();
			Double montoFinal = montoActual - montoCompra;

			cuentaCorriente.setMonto(montoFinal);
		}
	}
}
