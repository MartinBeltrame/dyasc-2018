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

	public static void mostrarResultadoConModo(Integer numero, String opcion, String modo) {

		if (numero != null) {

			switch (modo) {
			case "-m=s":
				if (opcion.contains("-o=v")) {
					new MonitorVMS().mostrar(numero);
				} else {
					new MonitorHMS().mostrar(numero);
				}
				break;

			case "-m=l":
				mostrarResultado(numero, opcion);
				break;

			default:
				mostrarResultado(numero, opcion);
				break;
			}
		}
	}
}
