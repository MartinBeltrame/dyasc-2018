package ar.edu.untref.dyasc.aplicacion;

import java.util.Scanner;

import ar.edu.untref.dyasc.dominio.Bitacora;

public class Ejemplo {

	public static void main(String[] args) {

		if (args.length > 0) {

			String argumento = args[0];

			Bitacora bitacora = new Bitacora(argumento);
			Scanner entrada = new Scanner(System.in);

			boolean entradaAbierta = true;

			while (entradaAbierta && entrada.hasNextLine()) {

				String mensaje = entrada.nextLine();
				if (mensaje.toLowerCase().equals("fin")) {
					entrada.close();
					entradaAbierta = false;
				} else {
					bitacora.registrarEvento(mensaje);
				}
			}

			bitacora.procesar();
		} else {
			System.out.println("Opción no valida.");
		}
	}
}
