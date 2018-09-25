package ar.edu.untref.dyasc.dominio;

import java.util.HashMap;
import java.util.Map;

public class Monitor {

	private Map<String, TipoArgumento> opciones = new HashMap<>();
	private Map<TipoArgumento, IGenerador> generadores = new HashMap<>();

	public Monitor() {

		opciones.put("-o=vd", TipoArgumento.VERTICAL_DIRECTA);
		opciones.put("-o=vi", TipoArgumento.VERTICAL_INVERTIDA);
		opciones.put("-o=hd", TipoArgumento.HORIZONTAL_DIRECTA);
		opciones.put("-o=hi", TipoArgumento.HORIZONTAL_INVERTIDA);

		generadores.put(TipoArgumento.VERTICAL_DIRECTA, new GeneradorVD());
		generadores.put(TipoArgumento.VERTICAL_INVERTIDA, new GeneradorVI());
		generadores.put(TipoArgumento.HORIZONTAL_DIRECTA, new GeneradorHD());
		generadores.put(TipoArgumento.HORIZONTAL_INVERTIDA, new GeneradorHI());
	}

	public void mostrarResultado(Integer numero, String opcion, String nombreArchivo) {

		TipoArgumento tipo = opciones.get(opcion);

		generadores.get(tipo).construirRespuesta(numero);
		String respuesta = generadores.get(tipo).getRespuesta();

		if (nombreArchivo == "") {
			System.out.print(respuesta);
		} else {
			String nombreRecortado = nombreArchivo.substring(3);
			Escritor.escribir(respuesta, nombreRecortado);
			System.out.print("fibo<" + numero + "> guardado en " + nombreRecortado);
		}
	}

	public void mostrarResultadoConModo(Integer numero, String opcion, String modo, String nombreArchivo) {

		// if (numero != null) {
		//
		// switch (modo) {
		// case "-m=s":
		// if (opcion.contains("-o=v")) {
		// mostrar(numero, nombreArchivo, new GeneradorVMS());
		// } else {
		// mostrar(numero, nombreArchivo, new GeneradorHMS());
		// }
		// break;
		//
		// case "-m=l":
		// mostrarResultado(numero, opcion, nombreArchivo);
		// break;
		//
		// default:
		// mostrarResultado(numero, opcion, nombreArchivo);
		// break;
		// }
		// }
	}
}
