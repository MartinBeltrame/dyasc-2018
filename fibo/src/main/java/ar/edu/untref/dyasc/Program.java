package ar.edu.untref.dyasc;

public class Program {

	public static int fibonacciDeUnNumero(int numero) {

		if (numero <= 0) {
			return 0;
		} else if (numero == 1) {
			return 1;
		} else {
			return fibonacciDeUnNumero(numero - 1) + fibonacciDeUnNumero(numero - 2);
		}
	}

	private static void mostrarSerieFibonacci(int numero) {
		System.out.print("fibo<" + numero + ">:");
		for (int i = 0; i < numero; i++) {
			int resultado = fibonacciDeUnNumero(i);
			System.out.print(" " + resultado);
		}
	}

	public static void main(String[] args) {
		Integer parametro = Integer.valueOf(args[0]);
		if (parametro != null) {
			mostrarSerieFibonacci(parametro);
		}
	}
}
