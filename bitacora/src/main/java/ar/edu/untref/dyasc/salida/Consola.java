package ar.edu.untref.dyasc.salida;

public class Consola implements Salida {

	@Override
	public void registrar(String resultado) {
		System.out.print(resultado);
	}
}
