package ar.edu.untref.dyasc.dominio;

import java.util.List;

public class ServicioBitacora {

	private RepositorioBitacora repositorioBitacora = new RepositorioBitacora();

	public String obtenerSalida() {

		List<Evento> registro = repositorioBitacora.getRegistro();

		String resultado = "";
		for (int i = 0; i < registro.size(); i++) {

			Evento evento = registro.get(i);
			resultado += evento.getMensaje() + " - " + evento.getFecha();

			if (i != registro.size() - 1) {
				resultado += "\n";
			}
		}
		return resultado;
	}

	public void agregarEvento(Evento evento) {
		repositorioBitacora.agregarEvento(evento);
	}

	public List<Evento> registro() {
		return repositorioBitacora.getRegistro();
	}
}
