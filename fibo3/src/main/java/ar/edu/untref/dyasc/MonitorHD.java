package ar.edu.untref.dyasc;

import ar.edu.untref.dyac.interfaces.IMonitor;

public class MonitorHD implements IMonitor {

	@Override
	public void mostrar(int numero) {
		System.out.print("fibo<" + numero + ">:");
		for (int i = 0; i < numero; i++) {
			int resultado = Funcion.fibonacciDeUnNumero(i);
			System.out.print(" " + resultado);
		}
	}
}
