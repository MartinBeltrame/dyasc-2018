package ar.edu.untref.dyasc.dominio;

public class Escritor implements IRegistradorEvento {

	private String nombreArchivo;

	public Escritor() {
	}

	public Escritor(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	@Override
	public void registrar(String resultado) {

		if (nombreArchivo == null) {
			nombreArchivo = "bitacora.txt";
		}
		EscritorArchivos.escribir(resultado, nombreArchivo);
	}
}
