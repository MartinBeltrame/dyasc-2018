package ar.edu.untref.dyasc.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.untref.dyasc.dominio.ArticulosLibreria;
import ar.edu.untref.dyasc.dominio.Cliente;
import ar.edu.untref.dyasc.dominio.Libro;
import ar.edu.untref.dyasc.dominio.Mes;
import ar.edu.untref.dyasc.dominio.Periodico;
import ar.edu.untref.dyasc.dominio.Revista;
import ar.edu.untref.dyasc.dominio.Suscripcion;
import ar.edu.untref.dyasc.dominio.Venta;

public class Mockeador {

	private static List<Venta> ventas = new ArrayList<>();
	private static List<Cliente> clientes = new ArrayList<>();
	private static List<Suscripcion> suscripciones = new ArrayList<>();

	public static void mockearVentas() {

		Cliente juan = new Cliente("Juan", "Lorta", "Av. siempreviva", 23232322);
		Cliente alicia = new Cliente("Alicia", "Lorta", "Av. siempreviva", 23234432);
		Cliente oscar = new Cliente("Oscar", "Roto", "Av. callao", 12478999);

		clientes.add(juan);
		clientes.add(alicia);
		clientes.add(oscar);

		Revista revista = new Revista(50.0);
		Libro libro = new Libro(300.0);
		ArticulosLibreria articulosLibreria = new ArticulosLibreria(45.0);
		Periodico periodico = new Periodico(90.0);

		Suscripcion suscripcion1 = new Suscripcion(oscar, revista);
		suscripciones.add(suscripcion1);

		// Ventas juan
		Venta venta1 = new Venta(revista, Mes.ENERO, juan);
		Venta venta4 = new Venta(articulosLibreria, Mes.MARZO, juan);

		// Ventas alicias
		Venta venta2 = new Venta(libro, Mes.ENERO, alicia);
		Venta venta3 = new Venta(periodico, Mes.FEBRERO, alicia);

		// Ventas Oscar
		Venta venta5 = new Venta(revista, Mes.ABRIL, oscar);

		ventas.add(venta1);
		ventas.add(venta2);
		ventas.add(venta3);
		ventas.add(venta4);
		ventas.add(venta5);
	}

	public static List<Cliente> getClientes() {
		return clientes;
	}

	public static List<Suscripcion> getSuscripciones() {
		return suscripciones;
	}

	public static List<Venta> getVentas() {
		return ventas;
	}
}
