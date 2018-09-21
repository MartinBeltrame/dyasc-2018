package ar.edu.untref.dyasc.dominio;

public class Escritor implements IRegistradorEvento {

	private String nombreArchivo;

	public Escritor(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	@Override
	public void registrar(String resultado) {
		EscritorArchivos.escribir(resultado, nombreArchivo);
	}
}
