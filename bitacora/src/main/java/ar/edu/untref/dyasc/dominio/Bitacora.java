package ar.edu.untref.dyasc.dominio;

public class Bitacora {

	private ServicioBitacora servicioBitacora;
	private IRegistradorEvento registradorEvento;

	public Bitacora(ServicioBitacora servicioBitacora, IRegistradorEvento registradorEvento) {
		this.servicioBitacora = servicioBitacora;
		this.registradorEvento = registradorEvento;
	}

	public void registrarEvento() {
		String resultado = servicioBitacora.obtenerResultado();
		registradorEvento.registrar(resultado);
	}
}
