package ar.edu.untref.dyasc;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Bitacora;
import ar.edu.untref.dyasc.dominio.Evento;
import ar.edu.untref.dyasc.dominio.ServicioBitacora;

public class ServicioBitacoraDebe {

	private static final Evento EVENTO_1 = new Evento("Evento 1");
	private static final Evento EVENTO_2 = new Evento("Evento 2");
	private static final Evento EVENTO_3 = new Evento("Evento 3");

	private Bitacora bitacora;
	private ServicioBitacora servicioBitacora;

	private LocalDateTime fechaActual;

	@Before
	public void inicializar() {

		bitacora = new Bitacora();
		servicioBitacora = new ServicioBitacora();

		fechaActual = LocalDateTime.now();
	}

	@Test
	public void registrar_un_evento() {

		bitacora.agregarEvento(EVENTO_1);
		List<Evento> registro = bitacora.getRegistro();

		String resultado = "Evento 1 - " + formatoFecha();
		Assert.assertEquals(resultado, servicioBitacora.registrarEvento(registro));
	}

	@Test
	public void registrar_mas_de_un_evento() {

		bitacora.agregarEvento(EVENTO_1);
		bitacora.agregarEvento(EVENTO_2);
		bitacora.agregarEvento(EVENTO_3);
		List<Evento> registro = bitacora.getRegistro();

		String resultado = "Evento 1 - " + formatoFecha() + 
					"\n" + "Evento 2 - " + formatoFecha() + 
					"\n" + "Evento 3 - " + formatoFecha();
		Assert.assertEquals(resultado, servicioBitacora.registrarEvento(registro));
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
