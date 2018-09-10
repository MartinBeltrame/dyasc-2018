package ar.edu.untref.dyasc.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.untref.dyasc.dominio.ArticulosLibreria;
import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.Producto;
import ar.edu.untref.dyasc.dominio.RegistroVentas;
import ar.edu.untref.dyasc.dominio.Venta;

public class ServicioVentas {

	private static final double PORCENTAJE_20 = 0.2;
	private static final double PORCENTAJE_5 = 0.05;
	private static final double IVA = 0.21;

	private RegistroVentas registroVentas;

	public ServicioVentas(RegistroVentas registroVentas) {
		this.registroVentas = registroVentas;
	}

	public Double getMonto(Mes mes, Cliente cliente) {

		List<Venta> ventaMes = ventasPorMes(mes);
		List<Venta> ventasPorCliente = ventasPorCliente(cliente, ventaMes);
		List<Producto> productos = productosCliente(ventasPorCliente);

		return calcularMontoTotal(productos, cliente);
	}

	private List<Producto> productosCliente(List<Venta> ventasPorCliente) {
		List<Producto> productos = new ArrayList<>();
		for (Venta venta : ventasPorCliente) {
			productos.add(venta.getProducto());
		}
		return productos;
	}

	private List<Venta> ventasPorCliente(Cliente cliente, List<Venta> ventaMes) {
		List<Venta> ventasPorCliente = new ArrayList<>();
		for (Venta venta : ventaMes) {
			if (venta.getCliente() == cliente) {
				ventasPorCliente.add(venta);
			}
		}
		return ventasPorCliente;
	}

	private List<Venta> ventasPorMes(Mes mes) {
		List<Venta> ventaMes = new ArrayList<>();
		for (Venta venta : registroVentas.getVentas()) {
			if (venta.getMes() == mes) {
				ventaMes.add(venta);
			}
		}
		return ventaMes;
	}

	private Double calcularMontoTotal(List<Producto> productos, Cliente cliente) {

		Double total = 0.0;

		for (Producto producto : productos) {
			Double descuento = producto.getPrecio() * PORCENTAJE_5;
			if (producto.getClass() == ArticulosLibreria.class) {
				Double aumento = producto.getPrecio() * IVA;
				total += producto.getPrecio() + aumento - descuento;
			} else {
				total += producto.getPrecio() - descuento;
			}
		}

		return total;
	}
}
