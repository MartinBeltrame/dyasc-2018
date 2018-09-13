package ar.edu.untref.dyasc.dominio;

import java.util.ArrayList;
import java.util.List;

public class RegistroVentas {

	private List<Venta> ventas = new ArrayList<>();

	public void registrar(Venta venta) {
		ventas.add(venta);
	}

	public boolean contiene(Venta venta) {
		return ventas.contains(venta);
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public List<Producto> productosVentasPorCliente(List<Venta> ventasPorCliente) {
		List<Producto> productos = new ArrayList<>();
		for (Venta venta : ventasPorCliente) {
			productos.add(venta.getProducto());
		}
		return productos;
	}

	public List<Venta> ventasPorCliente(Cliente cliente, List<Venta> ventaMes) {
		List<Venta> ventasPorCliente = new ArrayList<>();
		for (Venta venta : ventaMes) {
			if (venta.getCliente().equals(cliente)) {
				ventasPorCliente.add(venta);
			}
		}
		return ventasPorCliente;
	}

	public List<Venta> ventasPorMes(Mes mes) {
		List<Venta> ventaMes = new ArrayList<>();
		for (Venta venta : getVentas()) {
			if (venta.getMes().toString() == mes.toString()) {
				ventaMes.add(venta);
			}
		}
		return ventaMes;
	}
}