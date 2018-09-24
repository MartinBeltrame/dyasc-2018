package ar.edu.untref.dyasc;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Evento;
import ar.edu.untref.dyasc.dominio.RepositorioBitacora;
import ar.edu.untref.dyasc.dominio.ServicioBitacora;

public class ServicioBitacoraDebe {

	private static final Evento EVENTO_1 = new Evento("Evento 1");
	private static final Evento EVENTO_2 = new Evento("Evento 2");
	private static final Evento EVENTO_3 = new Evento("Evento 3");

	private RepositorioBitacora repositorioBitacora;

	private ServicioBitacora servicioBitacora;

	private LocalDateTime fechaActual;

	@Before
	public void inicializar() {

		repositorioBitacora = new RepositorioBitacora();
		servicioBitacora = new ServicioBitacora(repositorioBitacora);

		fechaActual = LocalDateTime.now();
	}

	@Test
	public void obtener_el_resultado_en_string_para_un_evento_agregado() {

		repositorioBitacora.agregarEvento(EVENTO_1);

		String resultado = "Evento 1 - " + formatoFecha();
		Assert.assertEquals(resultado, servicioBitacora.obtenerSalida());
	}

	@Test
	public void obtener_el_resultado_en_string_para_varios_eventos_agregados() {

		repositorioBitacora.agregarEvento(EVENTO_1);
		repositorioBitacora.agregarEvento(EVENTO_2);
		repositorioBitacora.agregarEvento(EVENTO_3);

		String resultado = "Evento 1 - " + formatoFecha() + 
				"\n" + "Evento 2 - " + formatoFecha() + 
				"\n" + "Evento 3 - " + formatoFecha();
		Assert.assertEquals(resultado, servicioBitacora.obtenerSalida());
	}

	private String formatoFecha() {

		int dia = fechaActual.getDayOfMonth();
		int mes = fechaActual.getMonth().getValue();
		int anio = fechaActual.getYear();
		int hora = fechaActual.getHour();
		int minutos = fechaActual.getMinute();
		String sDia = formatoString(dia);
		String sMes = formatoString(mes);
		String sHora = formatoString(hora);
		String sMinutos = formatoString(minutos);

		return sDia + "/" + sMes + "/" + anio + " - " + sHora + ":" + sMinutos;
	}

	private String formatoString(int fecha) {
		return fecha < 10 ? ("0" + fecha) : ("" + fecha);
	}
}
