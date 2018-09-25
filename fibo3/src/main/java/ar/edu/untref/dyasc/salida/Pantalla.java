package ar.edu.untref.dyasc.salida;

public class Pantalla extends Salida {

	public void mostrarResultado(Integer numero, String opcion, String nombreArchivo) {

		String respuesta = generadores.get(opcion).generarRespuesta(numero, null);

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

	@Override
	public void procesar() {
		// TODO Auto-generated method stub

	}
}
