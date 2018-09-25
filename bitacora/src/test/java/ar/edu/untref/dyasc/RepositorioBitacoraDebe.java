package ar.edu.untref.dyasc;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Evento;
import ar.edu.untref.dyasc.dominio.RepositorioBitacora;

public class RepositorioBitacoraDebe {

	private static final Evento EVENTO_1 = new Evento("Evento 1");

	private RepositorioBitacora repositorioBitacora;
	private LocalDateTime fechaActual;

	@Before
	public void inicializar() {

		repositorioBitacora = new RepositorioBitacora();

		fechaActual = LocalDateTime.now();
	}

	@Test
	public void agregar_un_nuevo_evento_con_la_hora_y_fecha_actual() {

		repositorioBitacora.agregarEvento(EVENTO_1);

		String fecha = formatoFecha();
		String mensaje = "Evento 1";
		Assert.assertEquals(mensaje, EVENTO_1.getMensaje());
		Assert.assertEquals(fecha, EVENTO_1.getFecha());
	}

	private String formatoFecha() {

		int dia = fechaActual.getDayOfMonth();
		int mes = fechaActual.getMonth().getValue();
		int anio = fechaActual.getYear();
		int hora = fechaActual.getHour();
		int minutos = fechaActual.getMinute();
		int segundos = fechaActual.getSecond();

		String sDia = formatoString(dia);
		String sMes = formatoString(mes);
		String sHora = formatoString(hora);
		String sMinutos = formatoString(minutos);
		String sSegundos = formatoString(segundos);

		return sDia + "/" + sMes + "/" + anio + " - " + sHora + ":" + sMinutos + ":" + sSegundos;
	}

	private String formatoString(int fecha) {
		return fecha < 10 ? ("0" + fecha) : ("" + fecha);
	}
}
