package ar.edu.untref.dyasc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ar.edu.untref.dyasc.dominio.Bitacora;
import ar.edu.untref.dyasc.dominio.Escritor;
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
	@Mock
	Escritor escritor;

	private Bitacora bitacora;
	private ServicioBitacora servicioBitacora;
	private String resultado;

	@Before
	public void inicializar() {
		RepositorioBitacora repositorioBitacora = new RepositorioBitacora();
		repositorioBitacora.agregarEvento(EVENTO_1);
		repositorioBitacora.agregarEvento(EVENTO_2);
		repositorioBitacora.agregarEvento(EVENTO_3);

		servicioBitacora = new ServicioBitacora(repositorioBitacora);
		resultado = servicioBitacora.obtenerResultado();
	}

	@Test
	public void mostrar_el_resultado_obtenido_por_consola() {

		bitacora = new Bitacora(servicioBitacora, monitor);
		bitacora.registrarEvento();

		Mockito.verify(monitor).registrar(resultado);
	}

	@Test
	public void escribir_el_resultado_en_un_archivo_txt() {
		
		bitacora = new Bitacora(servicioBitacora, escritor);
		bitacora.registrarEvento();
		
		Mockito.verify(escritor).registrar(resultado);
	}
}
