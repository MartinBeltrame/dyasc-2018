package ar.edu.untref.dyasc;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Libreria;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.RegistroSuscripcion;
import ar.edu.untref.dyasc.dominio.RegistroVentas;
import ar.edu.untref.dyasc.dominio.Suscripcion;
import ar.edu.untref.dyasc.dominio.Venta;
import ar.edu.untref.dyasc.servicios.Mockeador;
import ar.edu.untref.dyasc.servicios.Monitor;
import ar.edu.untref.dyasc.servicios.ServicioVentas;

public class ProgramDebe {

	private Libreria libreria;
	private Cliente juan;
	private Cliente alicia;
	private Cliente oscar;

	@Before
	public void inicializar() {

		RegistroSuscripcion registroSuscripciones = new RegistroSuscripcion();
		RegistroVentas registroVentas = new RegistroVentas();
		ServicioVentas servicioVentas = new ServicioVentas(registroVentas, registroSuscripciones);
		Monitor monitor = new Monitor(servicioVentas);
		libreria = new Libreria(registroVentas, registroSuscripciones, monitor);

		Mockeador.mockearVentas();

		List<Venta> ventas = Mockeador.getVentas();
		List<Cliente> clientes = Mockeador.getClientes();
		List<Suscripcion> suscripciones = Mockeador.getSuscripciones();

		for (Venta venta : ventas) {
			libreria.realizarVenta(venta);
		}

		for (Suscripcion suscripcion : suscripciones) {
			libreria.realizarSuscripcion(suscripcion);
		}

		juan = clientes.get(0);
		alicia = clientes.get(1);
		oscar = clientes.get(2);
	}

	@Test
	public void devolver_cero_para_un_cliente_que_no_compro_productos_en_febrero() {

		Double montoJuan = libreria.obtenerMonto(Mes.FEBRERO, juan);
		Double montoOscar = libreria.obtenerMonto(Mes.FEBRERO, oscar);

		Double resultadoJuan = 0.0;
		Double resultadoOscar = 0.0;

		Assert.assertEquals(resultadoJuan, montoJuan);
		Assert.assertEquals(resultadoOscar, montoOscar);
	}

	@Test
	public void obtener_el_monto_total_de_cada_cliente_para_enero_con_productos_no_suscriptos() {

		Double montoJuan = libreria.obtenerMonto(Mes.ENERO, juan);
		Double montoAlicia = libreria.obtenerMonto(Mes.ENERO, alicia);
		Double montoOscar = libreria.obtenerMonto(Mes.ENERO, oscar);

		Double resultadoJuan = 47.5;
		Double resultadoAlicia = 285.0;
		Double resultadoOscar = 285.0;

		Assert.assertEquals(resultadoJuan, montoJuan);
		Assert.assertEquals(resultadoAlicia, montoAlicia);
		Assert.assertEquals(resultadoOscar, montoOscar);
	}

	@Test
	public void obtener_el_monto_total_un_cliente_que_compro_un_periodico_sin_estar_suscripto() {

		Double montoAlicia = libreria.obtenerMonto(Mes.FEBRERO, alicia);

		Double resultadoAlicia = 85.5;

		Assert.assertEquals(resultadoAlicia, montoAlicia);
	}

	@Test
	public void obtener_el_monto_total_un_cliente_que_compro_un_articulo_de_libreria() {

		Double montoJuan = libreria.obtenerMonto(Mes.MARZO, juan);

		Double resultadoJuan = 52.2;

		Assert.assertEquals(resultadoJuan, montoJuan);
	}

	@Test
	public void obtener_el_monto_de_un_cliente_que_compro_una_revista_estando_suscripto() {

		Double montoOscar = libreria.obtenerMonto(Mes.MARZO, oscar);

		Double resultadoOscar = 40.0;

		Assert.assertEquals(resultadoOscar, montoOscar);
	}

	@Test
	public void obtener_el_monto_de_un_cliente_que_compro_mas_de_un_producto_en_abril() {

		Double montoOscar = libreria.obtenerMonto(Mes.ABRIL, oscar);

		Double resultadoOscar = 337.2;

		Assert.assertEquals(resultadoOscar, montoOscar);
	}
}
