package ar.edu.untref.dyasc.dominio;

import java.util.List;

public class ServicioBitacora {

	private IRegistradorEvento iRegistradorEvento;

	public ServicioBitacora(IRegistradorEvento iRegistradorEvento) {
		this.iRegistradorEvento = iRegistradorEvento;

	}

	public String registrarEvento(List<Evento> registro) {

		String resultado = "";
		for (int i = 0; i < registro.size(); i++) {

			Evento evento = registro.get(i);
			resultado += evento.getMensaje() + " - " + evento.getFecha();

			if (i != registro.size() - 1) {
				resultado += "\n";
			}
		}

		iRegistradorEvento.registrar(resultado);
		return resultado;
	}
}
