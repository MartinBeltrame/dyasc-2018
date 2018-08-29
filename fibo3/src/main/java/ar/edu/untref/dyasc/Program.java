package ar.edu.untref.dyasc;

public class Program {

	private static void capturarArgumentos(String[] argumentos) {

		int tamanio = argumentos.length;

		if (tamanio > 0 && tamanio <= 4) {

			Integer numero = Integer.valueOf(argumentos[tamanio - 1]);

			if (tamanio == 1) {
				Monitor.mostrarResultado(numero, "", "");
			} else if (tamanio == 2) {
				Monitor.mostrarResultado(numero, argumentos[0], "");
			} else {
				if (argumentos[1].contains("-m=")) {
					String opcion = argumentos[0];
					String modo = argumentos[1];
					Monitor.mostrarResultadoConModo(numero, opcion, modo, "");
				} else if (argumentos[1].contains("-f=")) {
					String opcion = argumentos[0];
					String nombreArchivo = argumentos[1];
					String modo = argumentos[2];
					Monitor.mostrarResultadoConModo(numero, opcion, modo, nombreArchivo);
				}
			}
		}
	}

	public static void main(String[] args) {
		capturarArgumentos(args);
	}
}
