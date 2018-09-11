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
		Cliente juliana = new Cliente("Juliana", "Kennedy", "Cordoba 2600", 32299000);

		clientes.add(juan);
		clientes.add(alicia);
		clientes.add(oscar);
		clientes.add(juliana);

		Revista revista = new Revista(50.0);
		Libro libro = new Libro(300.0);
		ArticulosLibreria articulosLibreria = new ArticulosLibreria(45.0);
		Periodico periodico = new Periodico(90.0);

		Suscripcion suscripcion1 = new Suscripcion(oscar, periodico);
		Suscripcion suscripcion2 = new Suscripcion(oscar, revista);
		Suscripcion suscripcion3 = new Suscripcion(juliana, periodico);
		Suscripcion suscripcion4 = new Suscripcion(juliana, revista);

		suscripciones.add(suscripcion1);
		suscripciones.add(suscripcion2);
		suscripciones.add(suscripcion3);
		suscripciones.add(suscripcion4);

		// Ventas juan
		Venta venta1 = new Venta(revista, Mes.ENERO, juan);
		Venta venta4 = new Venta(articulosLibreria, Mes.MARZO, juan);

		// Ventas alicias
		Venta venta2 = new Venta(libro, Mes.ENERO, alicia);
		Venta venta3 = new Venta(periodico, Mes.FEBRERO, alicia);

		// Ventas Oscar
		Venta venta5 = new Venta(libro, Mes.ENERO, oscar);
		Venta venta6 = new Venta(revista, Mes.MARZO, oscar);
		Venta venta7 = new Venta(articulosLibreria, Mes.ABRIL, oscar);
		Venta venta8 = new Venta(libro, Mes.ABRIL, oscar);

		// Ventas juliana
		Venta venta9 = new Venta(libro, Mes.FEBRERO, juliana);
		Venta venta10 = new Venta(periodico, Mes.FEBRERO, juliana);

		ventas.add(venta1);
		ventas.add(venta2);
		ventas.add(venta3);
		ventas.add(venta4);
		ventas.add(venta5);
		ventas.add(venta6);
		ventas.add(venta7);
		ventas.add(venta8);
		ventas.add(venta9);
		ventas.add(venta10);
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
