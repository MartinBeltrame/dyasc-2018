package ar.edu.untref.dyasc.dominio;

public class Monitor implements IRegistradorEvento {

	@Override
	public void registrar(String resultado) {
		System.out.print(resultado);
	}
}
