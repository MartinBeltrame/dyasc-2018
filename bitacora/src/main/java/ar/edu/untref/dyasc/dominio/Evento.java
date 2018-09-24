package ar.edu.untref.dyasc.dominio;

import java.time.LocalDateTime;

import ar.edu.untref.dyasc.utilidades.FormateadorFechas;

public class Evento {

	private String mensaje;
	private LocalDateTime fechaActual;

	public Evento(String mensaje) {
		this.mensaje = mensaje;
		fechaActual = LocalDateTime.now();
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getFecha() {
		return FormateadorFechas.formatear(fechaActual);
	}
}
