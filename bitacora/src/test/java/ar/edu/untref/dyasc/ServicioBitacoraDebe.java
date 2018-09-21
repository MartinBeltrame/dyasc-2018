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

	private Bitacora bitacora;
	private ServicioBitacora servicioBitacora;

	private LocalDateTime fechaActual;

	@Before
	public void inicializar() {

		bitacora = new Bitacora();
		servicioBitacora = new ServicioBitacora();
		
		fechaActual = LocalDateTime.now();
		bitacora.agregarEvento(EVENTO_1);
	}

	@Test
	public void registrar_un_evento() {

		List<Evento> registro = bitacora.getRegistro();
		String resultado = "Evento 1 - " + formatoFecha();
		Assert.assertEquals(resultado, servicioBitacora.registrarEvento(registro));
	}

	private String formatoFecha() {

		int dia = fechaActual.getDayOfMonth();
		int mes = fechaActual.getMonth().getValue();
		int anio = fechaActual.getYear();
		int hora = fechaActual.getHour();
		int minutos = fechaActual.getMinute();

		return dia + "/" + mes + "/" + anio + " - " + hora + ":" + minutos;
	}
}
