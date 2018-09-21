package ar.edu.untref.dyasc.dominio;

public class Escritor implements IRegistradorEvento {

	private String ruta;

	public Escritor(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public void registrar(String resultado) {
		EscritorArchivos.escribir(resultado, ruta);
	}
}
