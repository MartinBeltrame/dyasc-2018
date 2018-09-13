package ar.edu.untref.dyasc.servicios;

import java.util.List;

import ar.edu.untref.dyasc.dominio.ArticulosLibreria;
import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.Periodico;
import ar.edu.untref.dyasc.dominio.Producto;
import ar.edu.untref.dyasc.dominio.RegistroSuscripcion;
import ar.edu.untref.dyasc.dominio.RegistroVentas;
import ar.edu.untref.dyasc.dominio.Revista;

public class ServicioVentas {

	private static final double PORCENTAJE_20 = 0.2;
	private static final double PORCENTAJE_5 = 0.05;
	private static final double IVA = 0.21;

	private RegistroVentas registroVentas;
	private RegistroSuscripcion registroSuscripcion;

	public ServicioVentas(RegistroVentas registroVentas, RegistroSuscripcion registroSuscripcion) {
		this.registroVentas = registroVentas;
		this.registroSuscripcion = registroSuscripcion;
	}

	public Double getMonto(Mes mes, Cliente cliente) {
		
		List<Producto> productos = registroVentas.getProductosPorCliente(mes, cliente);
		return calcularMontoTotal(productos, cliente);
	}

	public void efectuarCompra(ServicioCuentaCorriente servicioCuentaCorriente, Cliente cliente, Mes mes) {
		
		Double monto = getMonto(mes, cliente);
		servicioCuentaCorriente.efectuarCompra(cliente, mes, monto);
	}

	private Double calcularMontoTotal(List<Producto> productos, Cliente cliente) {

		Double total = 0.0;

		for (Producto producto : productos) {
			if (producto.getClass() == ArticulosLibreria.class) {
				Double descuento = producto.getPrecio() * PORCENTAJE_5;
				Double aumento = producto.getPrecio() * IVA;
				total += producto.getPrecio() + aumento - descuento;
			} else if (producto.getClass() == Revista.class || producto.getClass() == Periodico.class) {
				Double descuento;
				if (registroSuscripcion.contieneCliente(cliente)) {
					descuento = producto.getPrecio() * PORCENTAJE_20;
				} else {
					descuento = producto.getPrecio() * PORCENTAJE_5;
				}
				total += producto.getPrecio() - descuento;
			} else {
				Double descuento = producto.getPrecio() * PORCENTAJE_5;
				total += producto.getPrecio() - descuento;
			}
		}

		return total;
	}

	public Double getMontoAnual(Cliente cliente) {

		Double montoTotal = 0.0;

		for (Mes mes : Mes.getMeses()) {
			montoTotal += getMonto(mes, cliente);
		}
		return montoTotal;
	}
}
