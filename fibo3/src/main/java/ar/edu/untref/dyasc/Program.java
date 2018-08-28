package ar.edu.untref.dyasc;

public class Program {

	public static void main(String[] args) {

		String opcion = args[0];
		Integer numero;

		if (args.length == 1 && args[0] != null) {
			numero = Integer.valueOf(args[0]);
			opcion = "";
		} else {
			numero = Integer.valueOf(args[1]);
		}

		Monitor.mostrarResultado(numero, opcion);
	}
}
