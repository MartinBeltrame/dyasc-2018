package ar.edu.untref.dyasc.salida;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
		escribir(resultado);
	}

	private void escribir(String contenido) {

		FileOutputStream fop = null;
		File archivo;
		try {
			archivo = new File(nombreArchivo);
			fop = new FileOutputStream(archivo);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			byte[] contenidoEnBytes = contenido.getBytes();

			fop.write(contenidoEnBytes);
			fop.flush();
			fop.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
