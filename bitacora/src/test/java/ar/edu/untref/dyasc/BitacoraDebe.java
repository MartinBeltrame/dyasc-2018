package ar.edu.untref.dyasc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ar.edu.untref.dyasc.dominio.Bitacora;
import ar.edu.untref.dyasc.dominio.Evento;
import ar.edu.untref.dyasc.dominio.Monitor;
import ar.edu.untref.dyasc.dominio.RepositorioBitacora;
import ar.edu.untref.dyasc.dominio.ServicioBitacora;

@RunWith(MockitoJUnitRunner.class)
public class BitacoraDebe {

	private static final Evento EVENTO_1 = new Evento("Evento 1");
	private static final Evento EVENTO_2 = new Evento("Evento 2");
	private static final Evento EVENTO_3 = new Evento("Evento 3");

	@Mock
	Monitor monitor;

	private Bitacora bitacora;
	private ServicioBitacora servicioBitacora;

	@Before
	public void inicializar() {
		RepositorioBitacora repositorioBitacora = new RepositorioBitacora();
		repositorioBitacora.agregarEvento(EVENTO_1);
		repositorioBitacora.agregarEvento(EVENTO_2);
		repositorioBitacora.agregarEvento(EVENTO_3);

		servicioBitacora = new ServicioBitacora(repositorioBitacora);
		bitacora = new Bitacora(servicioBitacora, monitor);
	}

	@Test
	public void mostrar_el_resultado_obtenido_por_consola() {

		bitacora.registrarEvento();

		String resultado = servicioBitacora.obtenerResultado();
		Mockito.verify(monitor).registrar(resultado);
	}
}
