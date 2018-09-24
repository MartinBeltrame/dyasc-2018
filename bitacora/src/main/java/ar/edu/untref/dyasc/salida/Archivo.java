package ar.edu.untref.dyasc.salida;

public class Archivo implements Salida {

	private String nombreArchivo;

	public Archivo() {
	}

	public Archivo(String nombreArchivo) {
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
