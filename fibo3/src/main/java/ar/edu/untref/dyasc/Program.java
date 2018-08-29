package ar.edu.untref.dyasc;

public class Program {

	private static void capturarArgumentos(String[] argumentos) {

		int tamanio = argumentos.length;
		Integer numero = Integer.valueOf(argumentos[tamanio - 1]);

		switch (tamanio) {

		case 1:
			Monitor.mostrarResultado(numero, "");
			break;

		case 2:
			Monitor.mostrarResultado(numero, argumentos[0]);
			break;

		case 3:
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
			break;

		case 4:

			break;
		}
	}

	public static void main(String[] args) {
		capturarArgumentos(args);
	}
}
