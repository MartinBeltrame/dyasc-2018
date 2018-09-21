package ar.edu.untref.dyasc.dominio;

public class Bitacora {

	private ServicioBitacora servicioBitacora;

	public Bitacora(ServicioBitacora servicioBitacora) {
		this.servicioBitacora = servicioBitacora;
	}

	public void registrarEvento(String argumento) {

		String variableDestino = argumento.substring(17, argumento.length());
		String resultado = servicioBitacora.obtenerResultado();
		TipoArgumento tipo = TipoArgumento.identificarTipo(variableDestino);

		switch (tipo) {
		case CONSOLA_Y_ARCHIVO:
			new Monitor().registrar(resultado);

			String nombreArchivo = variableDestino.split(",")[0];
			new Escritor(nombreArchivo).registrar(resultado);
			break;

		case CONSOLA:
			new Monitor().registrar(resultado);
			break;

		case ARCHIVO:
			new Escritor(variableDestino).registrar(resultado);
			break;
		}
	}
}
