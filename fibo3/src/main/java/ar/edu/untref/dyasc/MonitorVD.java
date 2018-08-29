package ar.edu.untref.dyasc;

import ar.edu.untref.dyac.interfaces.IMonitor;

public class MonitorVD implements IMonitor {

	@Override
	public void mostrar(int numero) {
		System.out.println("fibo<" + numero + ">:");
		for (int i = 0; i < numero; i++) {
			int resultado = Funciones.fibonacciDeUnNumero(i);
			System.out.println(resultado);
		}
	}
}
