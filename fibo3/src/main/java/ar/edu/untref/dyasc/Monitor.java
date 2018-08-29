package ar.edu.untref.dyasc;

public class Monitor {

	public static void mostrarResultado(Integer numero, String opcion, String nombreArchivo) {

		if (numero != null) {

			switch (opcion) {
			case "-o=vd":
				new MonitorVD().mostrar(numero, nombreArchivo);
				break;

			case "-o=hi":
				new MonitorHI().mostrar(numero, nombreArchivo);
				break;

			case "-o=vi":
				new MonitorVI().mostrar(numero, nombreArchivo);
				break;

			case "-o=hd":
				new MonitorHD().mostrar(numero, nombreArchivo);
				break;

			case "":
				new MonitorHD().mostrar(numero, nombreArchivo);
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
					new MonitorVMS().mostrar(numero, nombreArchivo);
				} else {
					new MonitorHMS().mostrar(numero, nombreArchivo);
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
}
