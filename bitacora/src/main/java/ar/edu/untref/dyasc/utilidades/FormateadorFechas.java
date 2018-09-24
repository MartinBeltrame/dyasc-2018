package ar.edu.untref.dyasc.utilidades;

import java.time.LocalDateTime;

public class FormateadorFechas {

	public static String formatear(LocalDateTime fecha) {

		int dia = fecha.getDayOfMonth();
		int mes = fecha.getMonth().getValue();
		int anio = fecha.getYear();
		int hora = fecha.getHour();
		int minutos = fecha.getMinute();

		String sDia = formatoString(dia);
		String sMes = formatoString(mes);
		String sHora = formatoString(hora);
		String sMinutos = formatoString(minutos);

		return sDia + "/" + sMes + "/" + anio + " - " + sHora + ":" + sMinutos;
	}

	private static String formatoString(int fecha) {
		return fecha < 10 ? ("0" + fecha) : ("" + fecha);
	}
}
