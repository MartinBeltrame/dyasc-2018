package ar.edu.untref.dyasc;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Evento;
import ar.edu.untref.dyasc.dominio.ServicioBitacora;
import ar.edu.untref.dyasc.utilidades.FormateadorFechas;

public class ServicioBitacoraDebe {

	private static final Evento EVENTO_1 = new Evento("Evento 1");
	private static final Evento EVENTO_2 = new Evento("Evento 2");
	private static final Evento EVENTO_3 = new Evento("Evento 3");

	private ServicioBitacora servicioBitacora;

	@Before
	public void inicializar() {

		servicioBitacora = new ServicioBitacora();
	}

	@Test
	public void obtener_el_resultado_en_string_para_un_evento_agregado() {

		servicioBitacora.agregarEvento(EVENTO_1);

		String fecha = FormateadorFechas.formatear(LocalDateTime.now());
		String resultado = "Evento 1 - " + fecha;
		Assert.assertEquals(resultado, servicioBitacora.obtenerSalida());
	}

	@Test
	public void obtener_el_resultado_en_string_para_varios_eventos_agregados() {

		servicioBitacora.agregarEvento(EVENTO_1);
		servicioBitacora.agregarEvento(EVENTO_2);
		servicioBitacora.agregarEvento(EVENTO_3);

		String fecha = FormateadorFechas.formatear(LocalDateTime.now());
		String resultado = "Evento 1 - " + fecha + 
					"\n" + "Evento 2 - " + fecha + 
					"\n" + "Evento 3 - " + fecha;
		Assert.assertEquals(resultado, servicioBitacora.obtenerSalida());
	}
}
