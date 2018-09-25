package ar.edu.untref.dyasc;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Evento;
import ar.edu.untref.dyasc.dominio.RepositorioBitacora;
import ar.edu.untref.dyasc.utilidades.FormateadorFechas;

public class RepositorioBitacoraDebe {

	private static final Evento EVENTO_1 = new Evento("Evento 1");

	private RepositorioBitacora repositorioBitacora;

	@Before
	public void inicializar() {

		repositorioBitacora = new RepositorioBitacora();
	}

	@Test
	public void agregar_un_nuevo_evento_con_la_hora_y_fecha_actual() {

		repositorioBitacora.agregarEvento(EVENTO_1);

		String fecha = FormateadorFechas.formatear(LocalDateTime.now());
		String mensaje = "Evento 1";
		Assert.assertEquals(mensaje, EVENTO_1.getMensaje());
		Assert.assertEquals(fecha, EVENTO_1.getFecha());
	}
}
