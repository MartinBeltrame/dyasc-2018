package ar.edu.untref.dyasc.servicios;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Mes;

public class Monitor {

	private ServicioVentas servicioVentas;

	public Monitor(ServicioVentas servicioVentas) {
		this.servicioVentas = servicioVentas;
	}

	public Double mostrarResultado(Mes mes, Cliente cliente) {

		Double monto = servicioVentas.getMonto(mes, cliente);

		String resultado = "Cliente: " + cliente.getNombre() + "\n" + "Mes: " + mes.toString() + "\n" + "Monto: "
				+ monto;
		imprimirResultado(resultado);
		return monto;
	}

	private void imprimirResultado(String resultado) {
		System.out.println(resultado + "\n");
	}
}
