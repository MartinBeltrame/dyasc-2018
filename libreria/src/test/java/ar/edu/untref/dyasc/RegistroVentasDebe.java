package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.Producto;
import ar.edu.untref.dyasc.dominio.RegistroVentas;
import ar.edu.untref.dyasc.dominio.Venta;

@RunWith(MockitoJUnitRunner.class)
public class RegistroVentasDebe {

	private Producto PRODUCTO = new Producto();
	private Mes ENERO = Mes.ENERO;
	private Cliente CLIENTE = new Cliente("Jorge", "Rich", "Av. Siempreviva", 1123);
	private Venta NUEVA_VENTA = new Venta(PRODUCTO, ENERO, CLIENTE);
	
	private RegistroVentas registroVentas = new RegistroVentas();
	
	@Test
	public void verificar_que_la_venta_ha_sido_registrada() {
		
		registroVentas.registrar(NUEVA_VENTA);
		
		Assert.assertTrue(registroVentas.getVentas().contains(NUEVA_VENTA));
	}
}
