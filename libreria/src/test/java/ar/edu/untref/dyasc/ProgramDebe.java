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
import ar.edu.untref.dyasc.servicios.ServicioCuentaCorriente;
import ar.edu.untref.dyasc.servicios.ServicioVentas;

public class ProgramDebe {

	private Libreria libreria;
	private Cliente juan;
	private Cliente alicia;
	private Cliente oscar;
	private Cliente juliana;
	private ServicioCuentaCorriente servicioCuentaCorriente;
	private Monitor monitor;

	@Before
	public void inicializar() {

		RegistroSuscripcion registroSuscripciones = new RegistroSuscripcion();
		RegistroVentas registroVentas = new RegistroVentas();
		ServicioVentas servicioVentas = new ServicioVentas(registroVentas, registroSuscripciones);
		servicioCuentaCorriente = new ServicioCuentaCorriente();
		libreria = new Libreria(registroVentas, registroSuscripciones, servicioVentas);
		monitor = new Monitor();

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
		juliana = clientes.get(3);
	}

	@Test
	public void devolver_cero_para_un_cliente_que_no_compro_productos_en_un_mes() {

		Double montoJuan = libreria.obtenerMonto(Mes.FEBRERO, juan);
		Double montoOscar = libreria.obtenerMonto(Mes.FEBRERO, oscar);
		monitor.mostrarResultado(Mes.FEBRERO, juan, montoJuan);
		monitor.mostrarResultado(Mes.FEBRERO, oscar, montoOscar);

		Double resultadoJuan = 0.0;
		Double resultadoOscar = 0.0;
		Assert.assertEquals(resultadoJuan, montoJuan);
		Assert.assertEquals(resultadoOscar, montoOscar);
	}

	@Test
	public void obtener_el_monto_total_de_cada_cliente_para_un_mismo_mes_con_productos_no_suscriptos() {

		Double montoJuan = libreria.obtenerMonto(Mes.ENERO, juan);
		Double montoAlicia = libreria.obtenerMonto(Mes.ENERO, alicia);
		Double montoOscar = libreria.obtenerMonto(Mes.ENERO, oscar);
		monitor.mostrarResultado(Mes.ENERO, juan, montoJuan);
		monitor.mostrarResultado(Mes.ENERO, alicia, montoAlicia);
		monitor.mostrarResultado(Mes.ENERO, oscar, montoOscar);

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
		monitor.mostrarResultado(Mes.FEBRERO, alicia, montoAlicia);

		Double resultadoAlicia = 85.5;
		Assert.assertEquals(resultadoAlicia, montoAlicia);
	}

	@Test
	public void obtener_el_monto_total_un_cliente_que_compro_un_articulo_de_libreria() {

		Double montoJuan = libreria.obtenerMonto(Mes.MARZO, juan);
		monitor.mostrarResultado(Mes.MARZO, juan, montoJuan);

		Double resultadoJuan = 52.2;
		Assert.assertEquals(resultadoJuan, montoJuan);
	}

	@Test
	public void obtener_el_monto_de_un_cliente_que_compro_una_revista_estando_suscripto() {

		Double montoOscar = libreria.obtenerMonto(Mes.MARZO, oscar);
		monitor.mostrarResultado(Mes.MARZO, oscar, montoOscar);

		Double resultadoOscar = 40.0;
		Assert.assertEquals(resultadoOscar, montoOscar);
	}

	@Test
	public void obtener_el_monto_de_un_cliente_que_compro_mas_de_un_producto_en_un_mismo_mes() {

		Double montoOscar = libreria.obtenerMonto(Mes.ABRIL, oscar);
		monitor.mostrarResultado(Mes.ABRIL, oscar, montoOscar);

		Double resultadoOscar = 337.2;
		Assert.assertEquals(resultadoOscar, montoOscar);
	}

	@Test
	public void obtener_el_monto_de_un_cliente_que_compro_un_periodico_y_un_libro_en_un_mismo_mes_estando_suscripto() {

		Double montoJuliana = libreria.obtenerMonto(Mes.FEBRERO, juliana);
		monitor.mostrarResultado(Mes.FEBRERO, juliana, montoJuliana);

		Double resultadoJuliana = 357.0;
		Assert.assertEquals(resultadoJuliana, montoJuliana);
	}

	@Test
	public void obtener_el_monto_anual_de_un_cliente_no_suscripto() {

		Double montoJuan = libreria.obtenerMontoAnual(juan);
		monitor.mostrarResultadoAnual(juan, montoJuan);

		Double resultadoJuan = 99.7;
		Assert.assertEquals(resultadoJuan, montoJuan);
	}

	@Test
	public void obtener_el_monto_anual_de_un_cliente_suscripto() {

		Double monto = libreria.obtenerMontoAnual(oscar);
		monitor.mostrarResultadoAnual(oscar, monto);

		Double resultado = 662.2;
		Assert.assertEquals(resultado, monto);
	}

	@Test
	public void efectuar_el_cobro_a_fin_de_mes_de_un_cliente() {

		servicioCuentaCorriente.crearCuenta(juliana);
		juliana.getCuentaCorriente().setMonto(1000.0);

		Double montoEnero = libreria.obtenerMonto(Mes.SEPTIEMBRE, juliana);
		servicioCuentaCorriente.efectuarCompra(juliana, Mes.SEPTIEMBRE, montoEnero);

		Double resultado = 715.0;
		Assert.assertEquals(resultado, juliana.getCuentaCorriente().getMonto());
	}
}
