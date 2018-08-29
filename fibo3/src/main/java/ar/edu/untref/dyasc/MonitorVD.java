package ar.edu.untref.dyasc;

import ar.edu.untref.dyac.interfaces.IMonitor;

public class MonitorVD implements IMonitor {

	private String respuesta = "";

	@Override
	public void mostrar(int numero) {

		respuesta = "fibo<" + numero + ">:\n";

		for (int i = 0; i < numero; i++) {
			int resultado = Funciones.fibonacciDeUnNumero(i);
			respuesta += resultado + "\n";
		}

		System.out.print(respuesta);
	}

	@Override
	public String getRespuesta() {
		return respuesta;
	}
}
