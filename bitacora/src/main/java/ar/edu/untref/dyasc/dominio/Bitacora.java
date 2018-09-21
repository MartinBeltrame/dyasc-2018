package ar.edu.untref.dyasc.dominio;

public class Bitacora {

	private ServicioBitacora servicioBitacora;

	public Bitacora(ServicioBitacora servicioBitacora) {
		this.servicioBitacora = servicioBitacora;
	}

	public void registrarEvento(String argumento) {

		String variableDestino = argumento.substring(17, argumento.length());
		String resultado = servicioBitacora.obtenerResultado();

		if (variableDestino.contains(",")) {
			new Monitor().registrar(resultado);

			String nombreArchivo = variableDestino.split(",")[0];
			new Escritor(nombreArchivo).registrar(resultado);
		} else {
			if (variableDestino.equals("CONSOLA")) {
				new Monitor().registrar(resultado);
			} else {
				new Escritor(variableDestino).registrar(resultado);
			}
		}
	}
}
