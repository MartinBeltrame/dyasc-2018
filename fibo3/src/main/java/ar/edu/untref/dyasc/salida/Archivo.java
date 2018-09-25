package ar.edu.untref.dyasc.salida;

public class Archivo implements ISalida {

	private String nombreArchivo;

	public Archivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	@Override
	public void procesar(String respuesta) {
		Escritor.escribir(respuesta, nombreArchivo);
	}
}
