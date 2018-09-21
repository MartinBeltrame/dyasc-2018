package ar.edu.untref.dyasc;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Bitacora;
import ar.edu.untref.dyasc.dominio.Evento;

public class BitacoraDebe {

	private Bitacora bitacora;
	private LocalDateTime fechaActual;

	private static final Evento EVENTO_1 = new Evento("Evento 1");

	@Before
	public void inicializar() {
		bitacora = new Bitacora();
		fechaActual = LocalDateTime.now();
	}

	@Test
	public void agregar_un_nuevo_evento_a_la_bitacora() {

		bitacora.agregarEvento(EVENTO_1);

		Assert.assertTrue(!bitacora.getRegistro().isEmpty());
	}

	@Test
	public void agregar_un_nuevo_evento_con_la_hora_y_fecha_actual() {

		bitacora.agregarEvento(EVENTO_1);

		Evento EVENTO_1 = bitacora.getRegistro().get(0);

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

		return dia + "/" + mes + "/" + anio + " - " + hora + ":" + minutos;
	}
}
