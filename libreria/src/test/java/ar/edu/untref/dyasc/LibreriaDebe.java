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
import ar.edu.untref.dyasc.servicios.ServicioVentas;

@RunWith(MockitoJUnitRunner.class)
public class LibreriaDebe {

	private Producto PRODUCTO = new Producto(100.0);
	private Mes MES = Mes.ENERO;
	private Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);

	private Venta VENTA = new Venta(PRODUCTO, MES, CLIENTE);
	private Suscripcion SUSCRIPCION = new Suscripcion(CLIENTE, PRODUCTO);

	private Libreria libreria;

	@Mock
	RegistroVentas registroVentas;
	@Mock
	RegistroSuscripcion registroSuscripciones;
	@Mock
	ServicioVentas servicioVentas;

	@Before
	public void inicializar() {
		libreria = new Libreria(registroVentas, registroSuscripciones, servicioVentas);
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

	@Test
	public void mostrar_el_monto_total_de_un_cliente_en_un_mes() {

		libreria.obtenerMonto(MES, CLIENTE);

		Mockito.verify(servicioVentas).getMonto(MES, CLIENTE);
	}

	@Test
	public void mostrar_el_monto_total_de_un_cliente_en_un_anio() {

		libreria.obtenerMontoAnual(CLIENTE);

		Mockito.verify(servicioVentas).getMontoAnual(CLIENTE);
	}
}
