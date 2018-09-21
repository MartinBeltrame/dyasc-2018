package ar.edu.untref.dyasc.dominio;

public class Bitacora {

	private ServicioBitacora servicioBitacora;

	public Bitacora(ServicioBitacora servicioBitacora) {
		this.servicioBitacora = servicioBitacora;
	}

	public void registrarEvento(String variableDestino) {

		String resultado = servicioBitacora.obtenerResultado();

		if (variableDestino.equals("CONSOLA")) {
			new Monitor().registrar(resultado);
		} else {
			new Escritor(variableDestino).registrar(resultado);
		}
	}
}
