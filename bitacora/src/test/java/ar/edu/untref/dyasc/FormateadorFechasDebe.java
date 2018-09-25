package ar.edu.untref.dyasc;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.dyasc.utilidades.FormateadorFechas;

public class FormateadorFechasDebe {
	
	@Test
	public void devolver_en_formato_string_la_fecha_y_hora_recibida() {
		
		String obtenido = FormateadorFechas.formatear(LocalDateTime.of(2018, 9, 20, 12, 0, 2));

		String esperado = "20/09/2018 - 12:00:02";
		Assert.assertEquals(esperado, obtenido);
	}
}
