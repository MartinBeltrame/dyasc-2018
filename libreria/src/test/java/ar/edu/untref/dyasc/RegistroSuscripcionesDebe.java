package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.RegistroSuscripcion;
import ar.edu.untref.dyasc.dominio.Suscripcion;

public class RegistroSuscripcionesDebe {

	private Suscripcion NUEVA_SUSCRIPCION = new Suscripcion();
	private RegistroSuscripcion registroSuscripcion;

	@Before
	public void inicializar() {
		registroSuscripcion = new RegistroSuscripcion();
	}
	
	@Test
	public void verificar_la_suscripcion_ha_sido_registrada_correctamente() {
		
		registroSuscripcion.registrar(NUEVA_SUSCRIPCION);
		
		Assert.assertTrue(registroSuscripcion.contains(NUEVA_SUSCRIPCION));
	}
}
