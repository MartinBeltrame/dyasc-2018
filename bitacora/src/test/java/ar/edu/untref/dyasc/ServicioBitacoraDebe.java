package ar.edu.untref.dyasc;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Evento;
import ar.edu.untref.dyasc.dominio.ServicioBitacora;

public class ServicioBitacoraDebe {

	private static final Evento EVENTO_1 = new Evento("Evento 1");
	private static final Evento EVENTO_2 = new Evento("Evento 2");
	private static final Evento EVENTO_3 = new Evento("Evento 3");

	private ServicioBitacora servicioBitacora;

	private LocalDateTime fechaActual;

	@Before
	public void inicializar() {

		servicioBitacora = new ServicioBitacora();

		fechaActual = LocalDateTime.now();
	}

	@Test
	public void obtener_el_resultado_en_string_para_un_evento_agregado() {

		servicioBitacora.agregarEvento(EVENTO_1);

		String resultado = "Evento 1 - " + formatoFecha();
		Assert.assertEquals(resultado, servicioBitacora.obtenerSalida());
	}

	@Test
	public void obtener_el_resultado_en_string_para_varios_eventos_agregados() {

		servicioBitacora.agregarEvento(EVENTO_1);
		servicioBitacora.agregarEvento(EVENTO_2);
		servicioBitacora.agregarEvento(EVENTO_3);

		String resultado = "Evento 1 - " + formatoFecha() + "\n" + "Evento 2 - " + formatoFecha() + "\n" + "Evento 3 - "
				+ formatoFecha();
		Assert.assertEquals(resultado, servicioBitacora.obtenerSalida());
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
