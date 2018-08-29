package ar.edu.untref.dyasc;

public class Program {

	private static void capturarArgumentos(String[] argumentos) {

		int tamanio = argumentos.length;
		Integer numero = Integer.valueOf(argumentos[tamanio - 1]);

		if (tamanio == 1) {
			Monitor.mostrarResultado(numero, "");
		} else if (tamanio == 2) {
			String opcion = argumentos[0];
			Monitor.mostrarResultado(numero, opcion);
		} else {
			if (argumentos[1].contains("-m=")) {
				String opcion = argumentos[0];
				String modo = argumentos[1];
				Monitor.mostrarResultadoConModo(numero, opcion, modo);
			} else if (argumentos[1].contains("-f=")) {
				String opcion = argumentos[0];
				String nombreArchivo = argumentos[1];
				String modo = argumentos[2];
				// Escribe el archivo
			}
		}
	}

	public static void main(String[] args) {
		capturarArgumentos(args);
	}
}
