package ar.edu.untref.dyasc.dominio;

import java.util.ArrayList;
import java.util.List;

public class RegistroVentas {

	private static final double PORCENTAJE_20 = 0.2;
	private static final double PORCENTAJE_5 = 0.05;

	private List<Venta> ventas = new ArrayList<>();

	public void registrar(Venta venta) {
		ventas.add(venta);
	}

	public Double getMonto(Mes mes, Cliente cliente) {

		List<Venta> ventaMes = ventasPorMes(mes);
		List<Venta> ventasPorCliente = ventasPorCliente(cliente, ventaMes);
		List<Producto> productos = productosCliente(ventasPorCliente);

		return calcularMontoTotalProductos(productos);
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
		for (Venta venta : ventas) {
			if (venta.getMes() == mes) {
				ventaMes.add(venta);
			}
		}
		return ventaMes;
	}

	private Double calcularMontoTotalProductos(List<Producto> productos) {

		Double total = 0.0;

		for (Producto producto : productos) {
			if (producto.getClass() == Periodico.class || producto.getClass() == Revista.class) {
				Double veintePorciento = producto.getPrecio() * PORCENTAJE_20;
				total += producto.getPrecio() - veintePorciento;
			} else {
				Double cincoPorciento = producto.getPrecio() * PORCENTAJE_5;
				total += producto.getPrecio() - cincoPorciento;
			}
		}

		return total;
	}

	public boolean contains(Venta venta) {
		return ventas.contains(venta);
	}
}