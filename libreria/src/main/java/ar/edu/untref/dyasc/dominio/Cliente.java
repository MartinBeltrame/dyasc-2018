package ar.edu.untref.dyasc.dominio;

public class Cliente {

	private int dni;
	private String nombre;
	private String apellido;
	private String direccion;
	private CuentaCorriente cuenta;

	public Cliente(String nombre, String apellido, String direccion, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.dni = dni;
	}

	public int getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public CuentaCorriente getCuentaCorriente() {
		return cuenta;
	}
	
	public void setCuenta(CuentaCorriente cuenta) {
		this.cuenta = cuenta;
	}
}
