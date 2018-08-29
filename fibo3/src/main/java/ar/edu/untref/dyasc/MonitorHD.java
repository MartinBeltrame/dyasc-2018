package ar.edu.untref.dyasc;

import ar.edu.untref.dyac.interfaces.IMonitor;

public class MonitorHD implements IMonitor {

	private String respuesta;

	@Override
	public void mostrar(int numero) {

		respuesta = "fibo<" + numero + ">:";

		for (int i = 0; i < numero; i++) {
			int resultado = Funciones.fibonacciDeUnNumero(i);
			respuesta += " " + resultado;
		}

		System.out.print(respuesta);
	}

	@Override
	public String getRespuesta() {
		return this.respuesta;
	}
}
