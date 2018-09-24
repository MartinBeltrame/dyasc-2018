package ar.edu.untref.dyasc.salida;

public class Archivo implements Salida {

	private String nombreArchivo;

	public Archivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	@Override
	public void procesar(String resultado) {

		if (nombreArchivo == null || nombreArchivo.equals("")) {
			nombreArchivo = "bitacora.txt";
		}
		Escritor.escribir(resultado, nombreArchivo);
	}
}
