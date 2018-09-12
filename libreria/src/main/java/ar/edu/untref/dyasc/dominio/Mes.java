package ar.edu.untref.dyasc.dominio;

import java.util.ArrayList;
import java.util.List;

public enum Mes {
	ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE;

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
}
