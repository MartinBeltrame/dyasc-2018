package ar.edu.untref.dyasc.utilidades;

import java.time.LocalDateTime;

public class FormateadorFechas {

	public static String formatear(LocalDateTime fecha) {

		int dia = fecha.getDayOfMonth();
		int mes = fecha.getMonth().getValue();
		int anio = fecha.getYear();
		int hora = fecha.getHour();
		int minutos = fecha.getMinute();
		int segundos = fecha.getSecond();

		String sDia = formatoString(dia);
		String sMes = formatoString(mes);
		String sHora = formatoString(hora);
		String sMinutos = formatoString(minutos);
		String sSegundos = formatoString(segundos);

		return sDia + "/" + sMes + "/" + anio + " - " + sHora + ":" + sMinutos + ":" + sSegundos;
	}

	private static String formatoString(int fecha) {
		return fecha < 10 ? ("0" + fecha) : ("" + fecha);
	}
	
	public static String formatearHora(LocalDateTime fecha) {
	
		int hora = fecha.getHour();
		int minutos = fecha.getMinute();
		int segundos = fecha.getSecond();

		String sHora = formatoString(hora);
		String sMinutos = formatoString(minutos);
		String sSegundos = formatoString(segundos);

		return sHora + sMinutos + sSegundos;
	}
}
