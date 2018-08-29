package ar.edu.untref.dyasc;

import ar.edu.untref.dyac.interfaces.IGenerador;

public class Monitor {

	public static void mostrarResultado(Integer numero, String opcion, String nombreArchivo) {

		if (numero != null) {

			switch (opcion) {
			case "-o=vd":
				mostrar(numero, nombreArchivo, new GeneradorVD());
				break;

			case "-o=hi":
				mostrar(numero, nombreArchivo, new GeneradorHI());
				break;

			case "-o=vi":
				mostrar(numero, nombreArchivo, new GeneradorVI());
				break;

			case "-o=hd":
				mostrar(numero, nombreArchivo, new GeneradorHD());
				break;

			case "":
				mostrar(numero, nombreArchivo, new GeneradorHD());
				break;

			default:
				System.out.print("Opciones no validas.");
				break;
			}
		}
	}

	public static void mostrarResultadoConModo(Integer numero, String opcion, String modo, String nombreArchivo) {

		if (numero != null) {

			switch (modo) {
			case "-m=s":
				if (opcion.contains("-o=v")) {
					mostrar(numero, nombreArchivo, new GeneradorVMS());
				} else {
					mostrar(numero, nombreArchivo, new GeneradorHMS());
				}
				break;

			case "-m=l":
				mostrarResultado(numero, opcion, nombreArchivo);
				break;

			default:
				mostrarResultado(numero, opcion, nombreArchivo);
				break;
			}
		}
	}

	private static void mostrar(int numero, String nombreArchivo, IGenerador iGenerador) {
		
		iGenerador.construirRespuesta(numero);
		String respuesta = iGenerador.getRespuesta();
		
		if (nombreArchivo == "") {
			System.out.print(respuesta);
		} else {
			String nombreRecortado = nombreArchivo.substring(3);
			EscritorArchivos.escribir(respuesta, nombreRecortado);
			System.out.print("fibo<" + numero + "> guardado en " + nombreRecortado);
		}
	}
}
