package ar.edu.untref.dyasc.salida;

public class ConsolaArchivo implements Salida {

	private String nombreArchivo;

	public ConsolaArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	@Override
	public void procesar(String resultado) {

		if (nombreArchivo == null || nombreArchivo.equals("")) {
			nombreArchivo = "bitacora.txt";
		}
		System.out.print(resultado);
		Escritor.escribir(resultado, nombreArchivo);
	}
}
