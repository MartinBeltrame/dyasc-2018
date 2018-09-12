package ar.edu.untref.dyasc.dominio;

import java.util.ArrayList;
import java.util.List;

public enum Mes {
	ENERO(0), 
	FEBRERO(1), 
	MARZO(2), 
	ABRIL(3), 
	MAYO(4), 
	JUNIO(5), 
	JULIO(6), 
	AGOSTO(7), 
	SEPTIEMBRE(8), 
	OCTUBRE(9), 
	NOVIEMBRE(10), 
	DICIEMBRE(11);

	private int numero;

	Mes(int numero) {
		this.numero = numero;
	}

	public static List<Mes> getMeses() {

		List<Mes> meses = new ArrayList<>();

		meses.add(Mes.ENERO);
		meses.add(Mes.FEBRERO);
		meses.add(Mes.MARZO);
		meses.add(Mes.ABRIL);
		meses.add(Mes.MAYO);
		meses.add(Mes.JUNIO);
		meses.add(Mes.JULIO);
		meses.add(Mes.AGOSTO);
		meses.add(Mes.SEPTIEMBRE);
		meses.add(Mes.OCTUBRE);
		meses.add(Mes.NOVIEMBRE);
		meses.add(Mes.DICIEMBRE);

		return meses;
	}

	public int getNumero() {
		return numero;
	}
}
