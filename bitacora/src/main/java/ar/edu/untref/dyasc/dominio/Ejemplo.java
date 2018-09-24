package ar.edu.untref.dyasc.dominio;

import ar.edu.untre.dyasc.servicios.ServicioBitacora;

public class Ejemplo {

	private String[] args;

	public Ejemplo(String[] args) {
		this.args = args;
	}

	public void ejecutarPrograma() {
		
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
