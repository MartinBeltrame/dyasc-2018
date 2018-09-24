package ar.edu.untref.dyasc.salida;

public class Consola implements Salida {

	@Override
	public void procesar(String resultado) {
		System.out.print(resultado);
	}
}
