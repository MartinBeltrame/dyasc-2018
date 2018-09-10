package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.ArticulosLibreria;
import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Libro;
import ar.edu.untref.dyasc.dominio.Periodico;
import ar.edu.untref.dyasc.dominio.Producto;
import ar.edu.untref.dyasc.dominio.RegistroSuscripcion;
import ar.edu.untref.dyasc.dominio.Suscripcion;

public class RegistroSuscripcionesDebe {

	private RegistroSuscripcion registroSuscripcion;

	@Before
	public void inicializar() {
		registroSuscripcion = new RegistroSuscripcion();
	}

	@Test
	public void verificar_que_la_suscripcion_ha_sido_registrada_correctamente() {

		Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);
		Producto PRODUCTO = new Periodico(100.0);
		Suscripcion SUSCRIPCION = new Suscripcion(CLIENTE, PRODUCTO);

		registroSuscripcion.registrar(SUSCRIPCION);

		Assert.assertTrue(registroSuscripcion.contiene(SUSCRIPCION));
	}

	@Test
	public void impedir_agregar_una_suscripcion_con_un_producto_no_suscribible() {

		Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);
		Producto PRODUCTO_1 = new Libro(100.0);
		Producto PRODUCTO_2 = new ArticulosLibreria(100.0);
		Suscripcion SUSCRIPCION_1 = new Suscripcion(CLIENTE, PRODUCTO_1);
		Suscripcion SUSCRIPCION_2 = new Suscripcion(CLIENTE, PRODUCTO_2);

		registroSuscripcion.registrar(SUSCRIPCION_1);
		registroSuscripcion.registrar(SUSCRIPCION_2);

		Assert.assertFalse(registroSuscripcion.contiene(SUSCRIPCION_1));
		Assert.assertFalse(registroSuscripcion.contiene(SUSCRIPCION_2));
	}
	
	@Test
	public void verificar_que_un_cliente_esta_suscripto_a_un_producto() {
		
		Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);
		Producto PRODUCTO = new Periodico(100.0);
		Suscripcion SUSCRIPCION = new Suscripcion(CLIENTE, PRODUCTO);

		registroSuscripcion.registrar(SUSCRIPCION);
		
		Assert.assertTrue(registroSuscripcion.contiene(CLIENTE));
	}
}
