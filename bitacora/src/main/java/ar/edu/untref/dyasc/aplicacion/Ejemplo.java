package ar.edu.untref.dyasc.aplicacion;

import ar.edu.untref.dyasc.dominio.Bitacora;

public class Ejemplo {

	public static void main(String[] args) {

		if (args.length > 0) {

			String argumento = args[0];

			Bitacora bitacora = new Bitacora(argumento);
			bitacora.registrarEvento();
		} else {
			System.out.println("Opción no valida.");
		}
	}
}
