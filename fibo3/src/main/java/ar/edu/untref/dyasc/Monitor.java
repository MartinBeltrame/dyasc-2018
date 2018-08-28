package ar.edu.untref.dyasc;

public class Monitor {

	public static void mostrarResultado(Integer numero, String opcion) {

		if (numero != null) {

			switch (opcion) {
			case "-o=vd":
				new MonitorVD().mostrar(numero);
				break;

			case "-o=hi":
				new MonitorHI().mostrar(numero);
				break;

			case "-o=vi":
				new MonitorVI().mostrar(numero);
				break;

			case "":
				new MonitorHD().mostrar(numero);
				break;

			default:
				System.out.print("Opciones no validas.");
				break;
			}
		}
	}
}
