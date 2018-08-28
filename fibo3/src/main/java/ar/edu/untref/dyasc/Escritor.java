package ar.edu.untref.dyasc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Escritor {

	public void escribir(String contenido, String nombreArchivo) {

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
