package ar.edu.untref.dyasc.salida;

public class Archivo extends Salida {

	private String nombreArchivo;

	public Archivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	@Override
	public void procesar(String respuesta) {
		Escritor.escribir(respuesta, nombreArchivo);
	}
}
