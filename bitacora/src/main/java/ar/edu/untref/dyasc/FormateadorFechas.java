package ar.edu.untref.dyasc;

import java.time.LocalDateTime;

public class FormateadorFechas {

	public static String formatear(LocalDateTime fecha) {

		int dia = fecha.getDayOfMonth();
		int mes = fecha.getMonth().getValue();
		int anio = fecha.getYear();
		int hora = fecha.getHour();
		int minutos = fecha.getMinute();

		return dia + "/" + mes + "/" + anio + " - " + hora + ":" + minutos;
	}
}
