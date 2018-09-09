package ar.edu.untref.dyasc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Libreria;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.Producto;
import ar.edu.untref.dyasc.dominio.RegistroSuscripcion;
import ar.edu.untref.dyasc.dominio.RegistroVentas;
import ar.edu.untref.dyasc.dominio.Suscripcion;
import ar.edu.untref.dyasc.dominio.Venta;

@RunWith(MockitoJUnitRunner.class)
public class LibreriaDebe {

	private Producto PRODUCTO = new Producto(100.0);
	private Mes ENERO = Mes.ENERO;
	private Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);

	private Venta VENTA = new Venta(PRODUCTO, ENERO, CLIENTE);
	private Suscripcion SUSCRIPCION = new Suscripcion();

	private Libreria libreria;

	@Mock
	RegistroVentas registroVentas;
	@Mock
	RegistroSuscripcion registroSuscripciones;

	@Before
	public void inicializar() {
		libreria = new Libreria(registroVentas, registroSuscripciones);
	}

	@Test
	public void vender_un_producto() {

		libreria.realizarVenta(VENTA);

		Mockito.verify(registroVentas).registrar(VENTA);
	}

	@Test
	public void registrar_una_suscripcion() {

		libreria.realizarSuscripcion(SUSCRIPCION);

		Mockito.verify(registroSuscripciones).registrar(SUSCRIPCION);
	}
}
