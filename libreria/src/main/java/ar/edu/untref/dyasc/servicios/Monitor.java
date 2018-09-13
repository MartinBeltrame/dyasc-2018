package ar.edu.untref.dyasc.servicios;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Mes;

public class Monitor {

	public void mostrarResultado(Mes mes, Cliente cliente, Double monto) {

		String resultado = "Cliente: " + cliente.getNombre() + "\n" + "Mes: " + mes.toString() + "\n" + "Monto: "
				+ monto;
		System.out.println(resultado + "\n");
	}

	public void mostrarResultadoAnual(Cliente cliente, Double montoTotal) {

		String resultado = "Cliente: " + cliente.getNombre() + "\n" + "Monto Anual: " + montoTotal;
		System.out.println(resultado + "\n");
	}
}
