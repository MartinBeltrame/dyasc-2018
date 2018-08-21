package ar.edu.untref.dyasc;

public class Program {

	private static int fibonacciDeUnNumero(int numero) {
		if (numero <= 1) {
			return 1;
		} else {
			return fibonacciDeUnNumero(numero - 1) + fibonacciDeUnNumero(numero - 2);
		}
	}

	private static void mostrarSerieFibonacci(int numero) {
		System.out.print("fibo<" + numero + ">:");
		for (int i = 1; i <= numero; i++) {
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
