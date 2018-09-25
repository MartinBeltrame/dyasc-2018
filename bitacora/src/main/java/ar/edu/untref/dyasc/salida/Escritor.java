package ar.edu.untref.dyasc.salida;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import ar.edu.untref.dyasc.utilidades.FormateadorFechas;

public class Escritor {

	public static void escribir(String contenido, String nombreArchivo) {

		LocalDateTime fecha = LocalDateTime.now();
		String ruta = FormateadorFechas.formatearHora(fecha) + "." + nombreArchivo;

		FileOutputStream fop = null;
		File archivo;
		try {
			archivo = new File(ruta);
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
