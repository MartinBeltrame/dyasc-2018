package ar.edu.untref.dyasc.aplicacion;

import ar.edu.untref.dyasc.dominio.Bitacora;
import ar.edu.untref.dyasc.dominio.Evento;
import ar.edu.untref.dyasc.dominio.RepositorioBitacora;
import ar.edu.untref.dyasc.dominio.ServicioBitacora;

public class Ejemplo {

	public static void main(String[] args) {

		if (args.length > 0) {

			String argumento = args[0];

			RepositorioBitacora repositorioBitacora = new RepositorioBitacora();
			repositorioBitacora.agregarEvento(new Evento("Evento 1"));
			repositorioBitacora.agregarEvento(new Evento("Evento 2"));
			repositorioBitacora.agregarEvento(new Evento("Evento 3"));
			repositorioBitacora.agregarEvento(new Evento("Evento 4"));

			ServicioBitacora servicioBitacora = new ServicioBitacora(repositorioBitacora);
			Bitacora bitacora = new Bitacora(servicioBitacora);

			bitacora.registrarEvento(argumento);

		} else {
			System.out.println("Opción no valida.");
		}
	}
}
